package it.almaviva.cgsse.drupal.taxonomy.logic;

import it.almaviva.cgsse.bo.bean.taxonomy.TaxonomyRilevanzaBOBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.rilevanza.TaxonomyRilevanzaRequestBean;
import it.almaviva.cgsse.drupal.taxonomy.client.TaxonomyRilevanzaClient;

import java.util.List;


public class RilevanzaLogics {



    public List<TaxonomyRilevanzaBOBean> execGetAll() {
        System.out.println("RilevanzaLogics - execGetAll");
        TaxonomyRilevanzaClient client = new TaxonomyRilevanzaClient(new TaxonomyRilevanzaRequestBean());
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
     * @see  TaxonomyRilevanzaBOBean
     */
    public List<TaxonomyRilevanzaBOBean> execGetByFK(String fk) throws Exception {
        System.out.println("RilevanzaLogics - execGetByFK: "+ fk);

        TaxonomyRilevanzaRequestBean req = new TaxonomyRilevanzaRequestBean();
        req.setFk(fk);
        TaxonomyRilevanzaClient client = new TaxonomyRilevanzaClient(req);
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
     * @see TaxonomyRilevanzaRequestBean
     */
    public Boolean execInsert(TaxonomyRilevanzaRequestBean req)  {
        System.out.println("RilevanzaLogics - execInsert: "+ req.toString());

        TaxonomyRilevanzaClient client = new TaxonomyRilevanzaClient(req);

        try {
            client.post();
            TaxonomyRilevanzaBOBean res = client.getResBO();
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
     * @see TaxonomyRilevanzaRequestBean
     */
    public Boolean execEdit(TaxonomyRilevanzaRequestBean req){
        System.out.println("RilevanzaLogics - execEdit: "+ req.toString());
        TaxonomyRilevanzaClient client = new TaxonomyRilevanzaClient(req);
        try {
            //CERCO L'UUID
            client.getByFk();
            List<TaxonomyRilevanzaBOBean> reqList = client.getResBOList();

            //MODIFICO SE CONTENUTO è PRESENTE
            if(!reqList.isEmpty()){
                System.out.println("Contenuto trovato - execEdit");

                req.setUuid(reqList.get(0).getUuid());
                client = new TaxonomyRilevanzaClient(req);
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
        System.out.println("RilevanzaLogics - execDeleteByFK: "+ fk);
        TaxonomyRilevanzaRequestBean req =  new TaxonomyRilevanzaRequestBean();
        req.setFk(fk);
        TaxonomyRilevanzaClient client = new TaxonomyRilevanzaClient(req);

        try {
            //CERCO L'UUID
            client.getByFk();
            List<TaxonomyRilevanzaBOBean> reqList = client.getResBOList();

            //ELIMINO SE CONTENUTO è PRESENTE
            if(!reqList.isEmpty()){
                System.out.println("Contenuto trovato - execDeleteByFK: "+ fk);
                req.setUuid(reqList.get(0).getUuid());
                client = new TaxonomyRilevanzaClient(req);
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
