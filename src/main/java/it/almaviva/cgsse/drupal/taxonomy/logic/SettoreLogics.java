package it.almaviva.cgsse.drupal.taxonomy.logic;

import it.almaviva.cgsse.bo.bean.taxonomy.TaxonomySettoreBOBean;
import it.almaviva.cgsse.drupal.common.logic.TaxonomyLogic;
import it.almaviva.cgsse.drupal.taxonomy.bean.settore.TaxonomySettoreRequestBean;
import it.almaviva.cgsse.drupal.taxonomy.client.TaxonomySettoreClient;

import java.util.List;


public class SettoreLogics extends TaxonomyLogic<TaxonomySettoreRequestBean,TaxonomySettoreBOBean> {



    public List<TaxonomySettoreBOBean> execGetAll() {
        System.out.println("SettoreLogics - execGetAll");
        TaxonomySettoreClient client = new TaxonomySettoreClient(new TaxonomySettoreRequestBean());
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
     * @see  TaxonomySettoreBOBean
     */
    public List<TaxonomySettoreBOBean> execGetByFK(String fk) throws Exception {
        System.out.println("SettoreLogics - execGetByFK: "+ fk);

        TaxonomySettoreRequestBean req = new TaxonomySettoreRequestBean();
        req.setFk(fk);
        TaxonomySettoreClient client = new TaxonomySettoreClient(req);
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
     * @see TaxonomySettoreRequestBean
     */
    public Boolean execInsert(TaxonomySettoreRequestBean req)  {
        System.out.println("SettoreLogics - execInsert: "+ req.toString());

        TaxonomySettoreClient client = new TaxonomySettoreClient(req);

        try {
            client.post();
            TaxonomySettoreBOBean res = client.getResBO();
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
     * @see TaxonomySettoreRequestBean
     */
    public Boolean execEdit(TaxonomySettoreRequestBean req){
        System.out.println("SettoreLogics - execEdit: "+ req.toString());
        TaxonomySettoreClient client = new TaxonomySettoreClient(req);
        try {
            //CERCO L'UUID
            client.getByFk();
            List<TaxonomySettoreBOBean> reqList = client.getResBOList();

            //MODIFICO SE CONTENUTO è PRESENTE
            if(!reqList.isEmpty()){
                System.out.println("Contenuto trovato - execEdit");

                req.setUuid(reqList.get(0).getUuid());
                client = new TaxonomySettoreClient(req);
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
        System.out.println("SettoreLogics - execDeleteByFK: "+ fk);
        TaxonomySettoreRequestBean req =  new TaxonomySettoreRequestBean();
        req.setFk(fk);
        TaxonomySettoreClient client = new TaxonomySettoreClient(req);

        try {
            //CERCO L'UUID
            client.getByFk();
            List<TaxonomySettoreBOBean> reqList = client.getResBOList();

            //ELIMINO SE CONTENUTO è PRESENTE
            if(!reqList.isEmpty()){
                System.out.println("Contenuto trovato - execDeleteByFK: "+ fk);
                req.setUuid(reqList.get(0).getUuid());
                client = new TaxonomySettoreClient(req);
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
