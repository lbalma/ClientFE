package it.almaviva.cgsse.drupal.content.logic;

import it.almaviva.cgsse.bo.bean.content.ContentInterventoBOBean;
import it.almaviva.cgsse.drupal.content.bean.GenericFile;
import it.almaviva.cgsse.drupal.content.bean.file.FileWorkableBean;
import it.almaviva.cgsse.drupal.content.bean.intervento.ContentInterventoRequestBean;
import it.almaviva.cgsse.drupal.content.bean.intervento.InterventoWorkableBean;
import it.almaviva.cgsse.drupal.content.client.InterventoClient;
import it.almaviva.cgsse.drupal.content.factory.BOFactory;

import java.util.List;

/**
 * Logica per la gestione degli interventi
 *
 */
public class InterventoLogics {

    /**
     * Torna tutti gli interventi contenuti dal FE, senza filtri
     *
     * @return List<ContentInterventoBOBean>
     * @see ContentInterventoBOBean
     */
    public List<ContentInterventoBOBean> execGetAll() {
        System.out.println("InterventoLogics - execGetAll");
        InterventoClient client = new InterventoClient(new ContentInterventoRequestBean());
        try {
            client.getAll();
            return BOFactory.convertWorkableToBOInterventi(client.getResList());
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Torna tutti gli interventi contenuti dal FE, filtrati da FK, la lista dovrebbe contenere solo 11 risultato
     * @param fk
     * @return List<ContentInterventoBOBean>
     * @see ContentInterventoBOBean
     */
    public List<ContentInterventoBOBean> execGetByFK(String fk) {
        System.out.println("InterventoLogics - execGetByFK: "+ fk);
        ContentInterventoRequestBean req =  new ContentInterventoRequestBean();
        try {
            req.setFk(fk);
            InterventoClient client = new InterventoClient(req);
            client.getByFk();
            return BOFactory.convertWorkableToBOInterventi(client.getResList());
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Publica un intervento
     *
     * @param req
     * @return Boolean
     * @see ContentInterventoRequestBean
     */
    public Boolean execInsert(ContentInterventoRequestBean req)  {
        System.out.println("InterventoLogics - execInsert: "+ req.toString());

        InterventoClient client = new InterventoClient(req);

        //VERIFICO SE è presente l'allegato, se quest'ultimo è presente dovro caricarlo per primo in seguito carichero l'intervento
        if(req.getAllegato() != null && req.getAllegato().getFile() != null)
        {
            try {
                System.out.println("InterventoLogics - execInsert: Inserisco l'allegato");

                client.postFile("field_allegato");
                FileWorkableBean workableFile = client.getResFile();
                req.getAllegato().setUuid(workableFile.getUuid());
                req.getAllegato().setDescription(workableFile.getDescription());
                client = new InterventoClient(req);
            }catch(Exception e){
                e.printStackTrace();
                return false;
            }
        }
        try {
            client.post();
            InterventoWorkableBean res = client.getRes();
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
     * @see ContentInterventoRequestBean
     */
    public Boolean execEdit(ContentInterventoRequestBean req){
        System.out.println("InterventoLogics - execEdit: "+ req.toString());
        InterventoClient client = new InterventoClient(req);
        try {
            //CERCO L'UUID
            client.getByFk();
            List<InterventoWorkableBean> reqList = client.getResList();

            //MODIFICO SE CONTENUTO è PRESENTE
            if(!reqList.isEmpty()){
                System.out.println("Contenuto trovato - execEdit");

                req.setUuid(reqList.get(0).getUuid());
                client = new InterventoClient(req);

                if(req.getAllegato()!= null && req.getAllegato().getFile() != null){
                    client.postFile("field_allegato");

                    FileWorkableBean workableFile = client.getResFile();
                    req.getAllegato().setUuid(workableFile.getUuid());
                    req.getAllegato().setDescription(workableFile.getDescription());
                    GenericFile gf = new GenericFile();
                    gf.setUuid(workableFile.getUuid());
                    gf.setFile(req.getAllegato().getFile());
                    gf.setName(req.getAllegato().getName());
                    gf.setDescription(workableFile.getDescription());

                    client.patchUpdateContentFile("field_allegato", gf);
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
        System.out.println("InterventoLogics - execDeleteByFK: "+ fk);
        ContentInterventoRequestBean req =  new ContentInterventoRequestBean();
        req.setFk(fk);
        InterventoClient client = new InterventoClient(req);

        try {
            //CERCO L'UUID
            client.getByFk();
            List<InterventoWorkableBean> reqList = client.getResList();

            //ELIMINO SE CONTENUTO è PRESENTE
            if(!reqList.isEmpty()){
                System.out.println("Contenuto trovato - execDeleteByFK: "+ fk);
                req.setUuid(reqList.get(0).getUuid());
                client = new InterventoClient(req);
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
