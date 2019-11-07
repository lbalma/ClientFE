package it.almaviva.cgsse.drupal.content.logic;

import it.almaviva.cgsse.bo.bean.content.ContentScioperoBOBean;
import it.almaviva.cgsse.bo.bean.taxonomy.TaxonomyAziendaBOBean;
import it.almaviva.cgsse.bo.bean.taxonomy.TaxonomyRilevanzaBOBean;
import it.almaviva.cgsse.bo.bean.taxonomy.TaxonomySettoreBOBean;
import it.almaviva.cgsse.drupal.content.bean.intervento.ContentInterventoRequestBean;
import it.almaviva.cgsse.drupal.content.bean.intervento.InterventoWorkableBean;
import it.almaviva.cgsse.drupal.content.bean.sciopero.ContentScioperoRequestBean;
import it.almaviva.cgsse.drupal.content.bean.sciopero.ScioperoWorkableBean;
import it.almaviva.cgsse.drupal.content.client.InterventoClient;
import it.almaviva.cgsse.drupal.content.client.ScioperoClient;
import it.almaviva.cgsse.drupal.content.factory.BOFactory;
import it.almaviva.cgsse.drupal.taxonomy.bean.azienda.TaxonomyAziendaRequestBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.rilevanza.TaxonomyRilevanzaRequestBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.settore.TaxonomySettoreRequestBean;
import it.almaviva.cgsse.drupal.taxonomy.client.TaxonomyAziendaClient;
import it.almaviva.cgsse.drupal.taxonomy.client.TaxonomyRilevanzaClient;
import it.almaviva.cgsse.drupal.taxonomy.client.TaxonomySettoreClient;

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

        if(req.getAzienda() != null && req.getAzienda().getFk() != null && !req.getAzienda().getFk().isEmpty()){
            TaxonomyAziendaRequestBean reqAzienda = new TaxonomyAziendaRequestBean();
            reqAzienda.setFk(req.getAzienda().getFk());
            TaxonomyAziendaClient aziendaClient = new TaxonomyAziendaClient(reqAzienda);
            try {
                aziendaClient.getByFk();
                List<TaxonomyAziendaBOBean>  aziende = aziendaClient.getResBOList();
                if(aziende != null && !aziende.isEmpty()){
                    req.getAzienda().setUuid(aziende.get(0).getUuid());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(req.getSettore() != null && req.getSettore().getFk() != null && !req.getSettore().getFk().isEmpty()){
            TaxonomySettoreRequestBean reqSettore = new TaxonomySettoreRequestBean();
            reqSettore.setFk(req.getSettore().getFk());
            TaxonomySettoreClient settoreClient = new TaxonomySettoreClient(reqSettore);
            try {
                settoreClient.getByFk();
                List<TaxonomySettoreBOBean>  settori = settoreClient.getResBOList();
                if(settori != null && !settori.isEmpty()){
                    req.getSettore().setUuid(settori.get(0).getUuid());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        if(req.getRilevanza() != null && req.getRilevanza().getFk() != null && !req.getRilevanza().getFk().isEmpty()){
            TaxonomyRilevanzaRequestBean reRilevanza = new TaxonomyRilevanzaRequestBean();
            reRilevanza.setFk(req.getRilevanza().getFk());
            TaxonomyRilevanzaClient rilevanzaClient = new TaxonomyRilevanzaClient(reRilevanza);
            try {
                rilevanzaClient.getByFk();
                List<TaxonomyRilevanzaBOBean>  rilevanze = rilevanzaClient.getResBOList();
                if(rilevanze != null && !rilevanze.isEmpty()){
                    req.getRilevanza().setUuid(rilevanze.get(0).getUuid());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

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
                if(req.getAzienda() != null && req.getAzienda().getFk() != null && !req.getAzienda().getFk().isEmpty()){
                    TaxonomyAziendaRequestBean reqAzienda = new TaxonomyAziendaRequestBean();
                    reqAzienda.setFk(req.getAzienda().getFk());
                    TaxonomyAziendaClient aziendaClient = new TaxonomyAziendaClient(reqAzienda);
                    try {
                        aziendaClient.getByFk();
                        List<TaxonomyAziendaBOBean>  aziende = aziendaClient.getResBOList();
                        if(aziende != null && !aziende.isEmpty()){
                            req.getAzienda().setUuid(aziende.get(0).getUuid());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if(req.getSettore() != null && req.getSettore().getFk() != null && !req.getSettore().getFk().isEmpty()){
                    TaxonomySettoreRequestBean reqSettore = new TaxonomySettoreRequestBean();
                    reqSettore.setFk(req.getSettore().getFk());
                    TaxonomySettoreClient settoreClient = new TaxonomySettoreClient(reqSettore);
                    try {
                        settoreClient.getByFk();
                        List<TaxonomySettoreBOBean>  settori = settoreClient.getResBOList();
                        if(settori != null && !settori.isEmpty()){
                            req.getSettore().setUuid(settori.get(0).getUuid());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


                if(req.getRilevanza() != null && req.getRilevanza().getFk() != null && !req.getRilevanza().getFk().isEmpty()){
                    TaxonomyRilevanzaRequestBean reRilevanza = new TaxonomyRilevanzaRequestBean();
                    reRilevanza.setFk(req.getRilevanza().getFk());
                    TaxonomyRilevanzaClient rilevanzaClient = new TaxonomyRilevanzaClient(reRilevanza);
                    try {
                        rilevanzaClient.getByFk();
                        List<TaxonomyRilevanzaBOBean>  rilevanze = rilevanzaClient.getResBOList();
                        if(rilevanze != null && !rilevanze.isEmpty()){
                            req.getRilevanza().setUuid(rilevanze.get(0).getUuid());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

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

                if(req.getAzienda() != null && req.getAzienda().getUuid() != null && !req.getAzienda().getUuid().isEmpty()){
                    client.patchUpdateContentRelationship("field_azienda",req.getAzienda());
                }
                if(req.getSettore() != null && req.getSettore().getUuid() != null && !req.getSettore().getUuid().isEmpty()){
                    client.patchUpdateContentRelationship("field_settore",req.getSettore());
                }
                if(req.getRilevanza() != null && req.getRilevanza().getUuid() != null && !req.getRilevanza().getUuid().isEmpty()){
                    client.patchUpdateContentRelationship("field_rilevanza",req.getRilevanza());
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

            if(workable.getAzienda() != null &&  !workable.getAzienda().isEmpty() && !workable.getAzienda().equals("missing")){ //TODO COSTANTE
                TaxonomyAziendaRequestBean req = new TaxonomyAziendaRequestBean();
                req.setUuid(workable.getAzienda());
                TaxonomyAziendaClient client = new TaxonomyAziendaClient(req);
                client.get();
                boBean.setAzienda(client.getResBO());
            }

            if(workable.getSettore() != null &&  !workable.getSettore().isEmpty() && !workable.getSettore().equals("missing")){ //TODO COSTANTE
                TaxonomySettoreRequestBean req = new TaxonomySettoreRequestBean();
                req.setUuid(workable.getSettore());
                TaxonomySettoreClient client = new TaxonomySettoreClient(req);
                client.get();
                boBean.setSettore(client.getResBO());
            }

            if(workable.getRilevanza() != null &&  !workable.getRilevanza().isEmpty() && !workable.getRilevanza().equals("missing")){ //TODO COSTANTE
                TaxonomyRilevanzaRequestBean req = new TaxonomyRilevanzaRequestBean();
                req.setUuid(workable.getRilevanza());
                TaxonomyRilevanzaClient client = new TaxonomyRilevanzaClient(req);
                client.get();
                boBean.setRilevanza(client.getResBO());
            }

            res.add(boBean);
        }
        return res;
    }
}
