package it.almaviva.cgsse.drupal.content.logic;

import it.almaviva.cgsse.bo.bean.content.ContentScioperoBOBean;
import it.almaviva.cgsse.drupal.content.bean.intervento.ContentInterventoRequestBean;
import it.almaviva.cgsse.drupal.content.bean.intervento.InterventoWorkableBean;
import it.almaviva.cgsse.drupal.content.bean.sciopero.ContentScioperoRequestBean;
import it.almaviva.cgsse.drupal.content.client.InterventoClient;
import it.almaviva.cgsse.drupal.content.client.ScioperoClient;
import it.almaviva.cgsse.drupal.content.bean.sciopero.ScioperoWorkableBean;
import it.almaviva.cgsse.drupal.content.factory.BOFactory;
import it.almaviva.cgsse.drupal.taxonomy.bean.azienda.TaxonomyAziendaRequestBean;
import it.almaviva.cgsse.drupal.taxonomy.client.TaxonomyAziendaClient;


import java.util.LinkedList;
import java.util.List;

/**
 * Logica che permette di eseguire correttamente le chiamate al FE
 *
 * Se il contenuto delle entità cambia la logica dovrà avere un minimo di impatti se non nullo
 */
public class ScioperoLogics {

    /**
     * Metodo che torna tutti gli scioperi presenti nel FE
     *
     * @return una lista di oggetti Content Sciopero
     * @throws Exception
     * @see  ContentScioperoBOBean
     */
    public List<ContentScioperoBOBean> execGetAll() {
        System.out.println("ScioperoLogics - execGetAll ");

        List<ContentScioperoBOBean> res;

        try{
            ScioperoClient client = new ScioperoClient(new ContentScioperoRequestBean());
            client.getAll();
            List<ScioperoWorkableBean> resCient = client.getResList();
            res = convertWorkableToBOScioperi(resCient);
            return res;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Data una Foreign Key torna se esiste lo sciopero di riferimento nel FE
     *
     * @param fk Foreign Key
     * @return Content Sciopero
     * @throws Exception
     * @see  ContentScioperoBOBean
     */
    public List<ContentScioperoBOBean> execGetByFK(String fk) throws Exception {
        System.out.println("ScioperoLogics - execGetByFK: "+ fk);

        List<ContentScioperoBOBean> res;

        try{
            ContentScioperoRequestBean req = new ContentScioperoRequestBean();
            req.setFk(fk);
            ScioperoClient client = new ScioperoClient(req);
            client.getByFk();
            List<ScioperoWorkableBean> resCient = client.getResList();
            res = convertWorkableToBOScioperi(resCient);

            return res;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


    public Boolean execInsert(ContentScioperoRequestBean req)  {
        System.out.println("ScioperoLogics - execInsert: "+ req.toString());
        ScioperoClient client = new ScioperoClient(req);

        //VERIFICO SE è presente l'intervento, se quest'ultimo è presente dovro caricarlo per primo in seguito carichero lo sciopero
        if(req.getInterventi() != null && !req.getInterventi().isEmpty())
        {
            try {
                System.out.println("ScioperoLogics - execInsert: Inserisco lo sciopero");
                InterventoLogics interventoLogics = new InterventoLogics();
                for(ContentInterventoRequestBean reqIntervento : req.getInterventi()){
                    interventoLogics.execInsert(reqIntervento);
                }
            }catch(Exception e){
                e.printStackTrace();
                return false;
            }
        }
        try {
            client.post();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;

        }
    }


    /**
     * Modifica un intervento gia publicato
     *
     * @param req
     * @return Boolean
     * @see ContentInterventoRequestBean
     */
    public Boolean execEdit(ContentScioperoRequestBean req){
        System.out.println("ScioperoLogics - execEdit: "+ req.toString());
        ScioperoClient client = new ScioperoClient(req);
        try {
            //CERCO L'UUID
            client.getByFk();
            List<ScioperoWorkableBean> reqList = client.getResList();

            //MODIFICO SE CONTENUTO è PRESENTE
            if(!reqList.isEmpty()){
                System.out.println("Contenuto trovato - execEdit");

                req.setUuid(reqList.get(0).getUuid());
                client = new ScioperoClient(req);

                if(req.getInterventi() != null && !req.getInterventi().isEmpty()){
                    try {
                        System.out.println("ScioperoLogics - execInsert: Inserisco lo sciopero");
                        InterventoLogics interventoLogics = new InterventoLogics();
                        for(ContentInterventoRequestBean reqIntervento : req.getInterventi()){
                            interventoLogics.execEdit(reqIntervento);
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                        return false;
                    }
                }

                client.patch();
            }else{
                System.out.println("Contenuto non trovato - execEdit: "+ req.toString());
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Elimina un intervento gia publicato tramite fk
     *
     * @param fk
     * @return Boolean
     */
    public Boolean execDeleteByFK(String fk){
        System.out.println("ScioperoLogics - execDeleteByFK: "+ fk);
        ContentScioperoRequestBean req =  new ContentScioperoRequestBean();
        req.setFk(fk);
        ScioperoClient client = new ScioperoClient(req);

        try {
            //CERCO L'UUID
            client.getByFk();
            List<ScioperoWorkableBean> reqList = client.getResList();

            //ELIMINO SE CONTENUTO è PRESENTE
            if(!reqList.isEmpty()){

                //ELIMINO INTERVENTI SE PRESENTI
                for(String uuidIntervento : reqList.get(0).getInterventi()){
                    if(!uuidIntervento.equals("missing")){ //TODO COSTANTE
                        ContentInterventoRequestBean reqIntervento = new ContentInterventoRequestBean();
                        reqIntervento.setUuid(uuidIntervento);
                        InterventoClient clientIntervento = new InterventoClient(reqIntervento);
                        clientIntervento.del();
                    }
                }

                System.out.println("Contenuto trovato - execDeleteByFK: "+ fk);
                req.setUuid(reqList.get(0).getUuid());
                client = new ScioperoClient(req);
                client.del();
            }else{
                System.out.println("Contenuto non trovato - execDeleteByFK: "+ fk);
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


    private List<ContentScioperoBOBean> convertWorkableToBOScioperi(List<ScioperoWorkableBean> resCient) throws Exception {
        List<ContentScioperoBOBean> res = new LinkedList<>();
        //Preparo l'output
        for(ScioperoWorkableBean workable : resCient){
            ContentScioperoBOBean boBean = BOFactory.convertWorkableToBOScioperi(workable);
            List<InterventoWorkableBean> interventoWorkBeanL = new LinkedList<>();
            for(String uuidIntervento : workable.getInterventi()){
                if(!uuidIntervento.equals("missing")){ //TODO COSTANTE
                    ContentInterventoRequestBean reqIntervento = new ContentInterventoRequestBean();
                    reqIntervento.setUuid(uuidIntervento);
                    InterventoClient clientIntervento = new InterventoClient(reqIntervento);
                    clientIntervento.get();
                    InterventoWorkableBean interventoWorkBean = clientIntervento.getRes();
                    interventoWorkBeanL.add(interventoWorkBean);
                }
            }
            boBean.setInterventi(BOFactory.convertWorkableToBOInterventi(interventoWorkBeanL));

            //TODO mancano


            //TODO Tassonomie

            //TODO delibere

            res.add(boBean);
        }
        return res;
    }
}
