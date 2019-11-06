package it.almaviva.cgsse.drupal.taxonomy.logic;

import it.almaviva.cgsse.bo.bean.taxonomy.TaxonomyAziendaBOBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.azienda.TaxonomyAziendaRequestBean;
import it.almaviva.cgsse.drupal.taxonomy.client.TaxonomyAziendaClient;

import java.util.List;


public class AziendaLogics {



    public List<TaxonomyAziendaBOBean> execGetAll() {
        System.out.println("AziendaLogics - execGetAll");
        TaxonomyAziendaClient client = new TaxonomyAziendaClient(new TaxonomyAziendaRequestBean());
        try {
             client.getAll();
            return client.getResBOList();
        }catch(Exception e){
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
     * @see  TaxonomyAziendaBOBean
     */
    public List<TaxonomyAziendaBOBean> execGetByFK(String fk) throws Exception {
        System.out.println("AziendaLogics - execGetByFK: "+ fk);

        TaxonomyAziendaRequestBean req = new TaxonomyAziendaRequestBean();
        req.setFk(fk);
        TaxonomyAziendaClient client = new TaxonomyAziendaClient(req);
        client.getByFk();

        try{
            client.getByFk();
            return client.getResBOList();
        }catch (Exception e){
            System.out.println(e);
        }

        return null;
    }


    /**
     * Publica un intervento
     *
     * @param req
     * @return Boolean
     * @see TaxonomyAziendaRequestBean
     */
    public Boolean execInsert(TaxonomyAziendaRequestBean req)  {
        System.out.println("AziendaLogics - execInsert: "+ req.toString());

        TaxonomyAziendaClient client = new TaxonomyAziendaClient(req);

        try {
            client.post();
            TaxonomyAziendaBOBean res = client.getResBO();
            req.setUuid(res.getUuid());
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
     * @see TaxonomyAziendaRequestBean
     */
    public Boolean execEdit(TaxonomyAziendaRequestBean req){
        System.out.println("AziendaLogics - execEdit: "+ req.toString());
        TaxonomyAziendaClient client = new TaxonomyAziendaClient(req);
        try {
            //CERCO L'UUID
            client.getByFk();
            List<TaxonomyAziendaBOBean> reqList = client.getResBOList();

            //MODIFICO SE CONTENUTO è PRESENTE
            if(!reqList.isEmpty()){
                System.out.println("Contenuto trovato - execEdit");

                req.setUuid(reqList.get(0).getUuid());
                client = new TaxonomyAziendaClient(req);
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
        System.out.println("AziendaLogics - execDeleteByFK: "+ fk);
        TaxonomyAziendaRequestBean req =  new TaxonomyAziendaRequestBean();
        req.setFk(fk);
        TaxonomyAziendaClient client = new TaxonomyAziendaClient(req);

        try {
            //CERCO L'UUID
            client.getByFk();
            List<TaxonomyAziendaBOBean> reqList = client.getResBOList();

            //ELIMINO SE CONTENUTO è PRESENTE
            if(!reqList.isEmpty()){
                System.out.println("Contenuto trovato - execDeleteByFK: "+ fk);
                req.setUuid(reqList.get(0).getUuid());
                client = new TaxonomyAziendaClient(req);
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


}
