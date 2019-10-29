package it.almaviva.cgsse.drupal.content.factory;

import com.google.gson.Gson;
import it.almaviva.cgsse.drupal.content.bean.file.ContentFileResponseBean;
import it.almaviva.cgsse.drupal.content.bean.file.FileWorkableBean;
import it.almaviva.cgsse.drupal.content.bean.intervento.*;
import it.almaviva.cgsse.drupal.content.bean.sciopero.*;
import it.almaviva.cgsse.drupal.jsonapi.DataForContentObject;
import it.almaviva.cgsse.drupal.jsonapi.DataObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Factory dei Contenuti
 */
public class ContentFactory {

    /**
     * Crea da una stringa json un oggetto contenente tutti gli attributi
     *
     * @param jsonString
     * @return
     */
    public static ContentScioperoResponseBean createScioperoResponse_jsonapiFormat(String jsonString){
        Gson g = new Gson();
        ContentScioperoResponseBean obj = g.fromJson(jsonString, ContentScioperoResponseBean.class);

        return obj;
    }

    /**
     * Crea da una stringa json un oggetto contenente tutti gli attributi
     *
     * @param jsonString
     * @return
     */
    public static ContentScioperoResponseBeanList createScioperoResponse_jsonapiFormatList(String jsonString){
        Gson g = new Gson();
        ContentScioperoResponseBeanList obj = g.fromJson(jsonString, ContentScioperoResponseBeanList.class);

        return obj;
    }

    /**
     * Crea da una stringa json un oggetto da passare al BO, con attributi filtrati
     *
     * @param jsonString
     * @return
     */

    public static ScioperoWorkableBean createScioperoResponse_WarkableFormat(String jsonString){
        Gson g = new Gson();
        ContentScioperoResponseBean obj = g.fromJson(jsonString, ContentScioperoResponseBean.class);

        return generateScioperoWorkableBean(obj.getdata());
    }



    /**
     * Crea da una stringa json un oggetto da passare al BO, con attributi filtrati
     *
     * @param jsonString
     * @return
     */

    public static List<ScioperoWorkableBean> createScioperoResponse_WarkableFormatList(String jsonString){
        Gson g = new Gson();
        ContentScioperoResponseBeanList obj = g.fromJson(jsonString, ContentScioperoResponseBeanList.class);

        List<ScioperoWorkableBean> res = new ArrayList<>();
        for(DataForContentObject dataObject: obj.getData()){
            res.add(generateScioperoWorkableBean(dataObject));
        }

        return res;
    }

    private static ScioperoWorkableBean generateScioperoWorkableBean(DataForContentObject dataObject){
        ScioperoWorkableBean workableBean = new ScioperoWorkableBean();
        workableBean.setControparte(((ContentScioperoResponseAttributes)dataObject.getAttributes()).getField_controparte());
        workableBean.setDifferito(((ContentScioperoResponseAttributes)dataObject.getAttributes()).getField_differito());
        workableBean.setFine(((ContentScioperoResponseAttributes)dataObject.getAttributes()).getField_fine());
        workableBean.setFk(((ContentScioperoResponseAttributes)dataObject.getAttributes()).getField_fk());
        workableBean.setInizio(((ContentScioperoResponseAttributes)dataObject.getAttributes()).getField_inizio());
        workableBean.setPosizione(((ContentScioperoResponseAttributes)dataObject.getAttributes()).getField_posizione());
        workableBean.setRevocato(((ContentScioperoResponseAttributes)dataObject.getAttributes()).getField_revocato());
        workableBean.setTitle(((ContentScioperoResponseAttributes)dataObject.getAttributes()).getTitle());
        workableBean.setUuid(dataObject.getId());

        //TASSONOMIE
        if(((ContentScioperoResponseRelationships)dataObject.getRelationships()).getField_azienda() != null
                && ((ContentScioperoResponseRelationships)dataObject.getRelationships()).getField_azienda().getData()!= null ) {

            workableBean.setAzienda(((ContentScioperoResponseRelationships)dataObject.getRelationships()).getField_azienda().getData().getId());
        }

        if(((ContentScioperoResponseRelationships)dataObject.getRelationships()).getField_settore() != null
                && ((ContentScioperoResponseRelationships)dataObject.getRelationships()).getField_settore().getData()!= null ) {

            workableBean.setSettore(((ContentScioperoResponseRelationships)dataObject.getRelationships()).getField_settore().getData().getId());
        }

        if(((ContentScioperoResponseRelationships)dataObject.getRelationships()).getField_rilevanza() != null
                && ((ContentScioperoResponseRelationships)dataObject.getRelationships()).getField_rilevanza().getData()!= null ) {

            workableBean.setRilevanza(((ContentScioperoResponseRelationships)dataObject.getRelationships()).getField_rilevanza().getData().getId());
        }

        //RELATIONSHIP
        if(((ContentScioperoResponseRelationships)dataObject.getRelationships()).getField_interventi() != null
                && ((ContentScioperoResponseRelationships)dataObject.getRelationships()).getField_interventi().getData()!= null ) {

            List<String> interventi = new LinkedList<>();
            for (DataObject intervento : ((ContentScioperoResponseRelationships) dataObject.getRelationships()).getField_interventi().getData()) {
                interventi.add(intervento.getId());
            }

            workableBean.setInterventi(interventi);
        }

        return workableBean;
    }












    /**
     * Crea da una stringa json un oggetto contenente tutti gli attributi
     *
     * @param jsonString
     * @return
     */
    public static ContentInterventoResponseBean createInterventoResponse_jsonapiFormat(String jsonString){
        Gson g = new Gson();
        ContentInterventoResponseBean obj = g.fromJson(jsonString, ContentInterventoResponseBean.class);

        return obj;
    }

    /**
     * Crea da una stringa json un oggetto contenente tutti gli attributi
     *
     * @param jsonString
     * @return
     */
    public static ContentInterventoResponseBeanList createInterventoResponse_jsonapiFormatList(String jsonString){
        Gson g = new Gson();
        ContentInterventoResponseBeanList obj = g.fromJson(jsonString, ContentInterventoResponseBeanList.class);

        return obj;
    }

    /**
     * Crea da una stringa json un oggetto da passare al BO, con attributi filtrati
     *
     * @param jsonString
     * @return
     */

    public static InterventoWorkableBean createInterventoResponse_WarkableFormat(String jsonString){
        Gson g = new Gson();
        ContentInterventoResponseBean obj = g.fromJson(jsonString, ContentInterventoResponseBean.class);

        return generateInterventoWorkableBean(obj.getdata());
    }



    /**
     * Crea da una stringa json un oggetto da passare al BO, con attributi filtrati
     *
     * @param jsonString
     * @return
     */

    public static List<InterventoWorkableBean> createInterventoResponse_WarkableFormatList(String jsonString){
        Gson g = new Gson();
        ContentInterventoResponseBeanList obj = g.fromJson(jsonString, ContentInterventoResponseBeanList.class);

        List<InterventoWorkableBean> res = new ArrayList<>();
        for(DataForContentObject dataObject: obj.getData()){
            res.add(generateInterventoWorkableBean(dataObject));
        }

        return res;
    }

    private static InterventoWorkableBean generateInterventoWorkableBean(DataForContentObject dataObject){
        InterventoWorkableBean workableBean = new InterventoWorkableBean();

        workableBean.setIntervento(((ContentInterventoResponseAttributes)dataObject.getAttributes()).getField_intervento());
        workableBean.setPosizione(((ContentInterventoResponseAttributes)dataObject.getAttributes()).getField_posizione());
        workableBean.setDataIntervento(((ContentInterventoResponseAttributes)dataObject.getAttributes()).getField_data_intervento());
        workableBean.setDescrizione(((ContentInterventoResponseAttributes)dataObject.getAttributes()).getField_descrizione());
        workableBean.setFk(((ContentInterventoResponseAttributes)dataObject.getAttributes()).getField_fk());
        workableBean.setTitle(((ContentInterventoResponseAttributes)dataObject.getAttributes()).getTitle());
        workableBean.setUuid(dataObject.getId());

        //RELATIONSHIP
        if(((ContentInterventoResponseRelationships)dataObject.getRelationships()).getField_allegato() != null
                && ((ContentInterventoResponseRelationships)dataObject.getRelationships()).getField_allegato().getData()!= null ) {

            workableBean.setAllegato(((ContentInterventoResponseRelationships)dataObject.getRelationships()).getField_allegato().getData().getId());
        }


        return workableBean;
    }



    /**
     * Crea da una stringa json un oggetto contenente tutti gli attributi
     *
     * @param jsonString
     * @return
     */
    public static ContentFileResponseBean createFileResponse_jsonapiFormat(String jsonString){
        Gson g = new Gson();
        ContentFileResponseBean obj = g.fromJson(jsonString, ContentFileResponseBean.class);

        return obj;
    }


    /**
     * Crea da una stringa json un oggetto contenente tutti gli attributi
     *
     * @param jsonString
     * @return
     */
    public static FileWorkableBean createFileResponse_WarkableFormat(String jsonString){
        Gson g = new Gson();
        ContentFileResponseBean obj = g.fromJson(jsonString, ContentFileResponseBean.class);

        FileWorkableBean workableBean = new FileWorkableBean();
        workableBean.setUuid(obj.getdata().getId());
        workableBean.setDescription(obj.getdata().getId());
        return workableBean;
    }

}
