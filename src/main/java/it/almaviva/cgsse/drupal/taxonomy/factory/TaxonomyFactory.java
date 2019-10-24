package it.almaviva.cgsse.drupal.taxonomy.factory;

import com.google.gson.Gson;
import it.almaviva.cgsse.bo.bean.taxonomy.TaxonomyAziendaBOBean;
import it.almaviva.cgsse.bo.bean.taxonomy.TaxonomyRilevanzaBOBean;
import it.almaviva.cgsse.bo.bean.taxonomy.TaxonomySettoreBOBean;
import it.almaviva.cgsse.drupal.jsonapi.DataObject;
import it.almaviva.cgsse.drupal.taxonomy.bean.azienda.TaxonomyAziendaResponseAttributes;
import it.almaviva.cgsse.drupal.taxonomy.bean.azienda.TaxonomyAziendaResponseBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.azienda.TaxonomyAziendaResponseBeanList;
import it.almaviva.cgsse.drupal.taxonomy.bean.rilevanza.TaxonomyRilevanzaResponseAttributes;
import it.almaviva.cgsse.drupal.taxonomy.bean.rilevanza.TaxonomyRilevanzaResponseBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.rilevanza.TaxonomyRilevanzaResponseBeanList;
import it.almaviva.cgsse.drupal.taxonomy.bean.settore.TaxonomySettoreResponseAttributes;
import it.almaviva.cgsse.drupal.taxonomy.bean.settore.TaxonomySettoreResponseBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.settore.TaxonomySettoreResponseBeanList;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory delle tassonomie
 */
public class TaxonomyFactory {

    /**
     * Crea da una stringa json un oggetto contenente tutti gli attributi
     *
     * @param jsonString
     * @return
     */
    public static TaxonomyAziendaResponseBean createAziendaResponse_jsonapiFormat(String jsonString){
        Gson g = new Gson();
        TaxonomyAziendaResponseBean obj = g.fromJson(jsonString, TaxonomyAziendaResponseBean.class);

        return obj;
    }

    /**
     * Crea da una stringa json un oggetto da passare al BO, con attributi filtrati
     *
     * @param jsonString
     * @return
     */
    public static TaxonomyAziendaBOBean createAziendaResponse_boFormat(String jsonString){
        Gson g = new Gson();
        TaxonomyAziendaResponseBean obj = g.fromJson(jsonString, TaxonomyAziendaResponseBean.class);
        TaxonomyAziendaBOBean boBean = new TaxonomyAziendaBOBean();
        boBean.setName(((TaxonomyAziendaResponseAttributes)obj.getdata().getAttributes()).getName());
        boBean.setUuid(obj.getdata().getId());
        boBean.setFk(((TaxonomyAziendaResponseAttributes)obj.getdata().getAttributes()).getField_fk());

        return boBean;
    }

    /**
     * Crea da una stringa json un oggetto contenente tutti gli attributi
     *
     * @param jsonString
     * @return
     */
    public static TaxonomyAziendaResponseBeanList createAziendaResponse_jsonapiFormatList(String jsonString){
        Gson g = new Gson();
        TaxonomyAziendaResponseBeanList obj = g.fromJson(jsonString, TaxonomyAziendaResponseBeanList.class);

        return obj;
    }

    /**
     * Crea da una stringa json un oggetto da passare al BO, con attributi filtrati
     *
     * @param jsonString
     * @return
     */
    public static List<TaxonomyAziendaBOBean> createAziendaResponse_boFormatList(String jsonString){
        Gson g = new Gson();
        TaxonomyAziendaResponseBeanList obj = g.fromJson(jsonString, TaxonomyAziendaResponseBeanList.class);

        List<TaxonomyAziendaBOBean> res = new ArrayList<>();
        for(DataObject dataObject: obj.getData()){
            TaxonomyAziendaBOBean boBean = new TaxonomyAziendaBOBean();
            boBean.setName(((TaxonomyAziendaResponseAttributes)dataObject.getAttributes()).getName());
            boBean.setUuid(dataObject.getId());
            boBean.setFk(((TaxonomyAziendaResponseAttributes)dataObject.getAttributes()).getField_fk());
            res.add(boBean);
        }

        return res;
    }



    /**
     * Crea da una stringa json un oggetto contenente tutti gli attributi
     *
     * @param jsonString
     * @return
     */
    public static TaxonomySettoreResponseBean createSettoreResponse_jsonapiFormat(String jsonString){
        Gson g = new Gson();
        TaxonomySettoreResponseBean obj = g.fromJson(jsonString, TaxonomySettoreResponseBean.class);

        return obj;
    }

    /**
     * Crea da una stringa json un oggetto da passare al BO, con attributi filtrati
     *
     * @param jsonString
     * @return
     */
    public static TaxonomySettoreBOBean createSettoreResponse_boFormat(String jsonString){
        Gson g = new Gson();
        TaxonomySettoreResponseBean obj = g.fromJson(jsonString, TaxonomySettoreResponseBean.class);
        TaxonomySettoreBOBean boBean = new TaxonomySettoreBOBean();
        boBean.setName(((TaxonomySettoreResponseAttributes)obj.getdata().getAttributes()).getName());
        boBean.setUuid(obj.getdata().getId());
        boBean.setFk(((TaxonomySettoreResponseAttributes)obj.getdata().getAttributes()).getField_fk());

        return boBean;
    }

    /**
     * Crea da una stringa json un oggetto contenente tutti gli attributi
     *
     * @param jsonString
     * @return
     */
    public static TaxonomySettoreResponseBeanList createSettoreResponse_jsonapiFormatList(String jsonString){
        Gson g = new Gson();
        TaxonomySettoreResponseBeanList obj = g.fromJson(jsonString, TaxonomySettoreResponseBeanList.class);

        return obj;
    }

    /**
     * Crea da una stringa json un oggetto da passare al BO, con attributi filtrati
     *
     * @param jsonString
     * @return
     */
    public static List<TaxonomySettoreBOBean> createSettoreResponse_boFormatList(String jsonString){
        Gson g = new Gson();
        TaxonomySettoreResponseBeanList obj = g.fromJson(jsonString, TaxonomySettoreResponseBeanList.class);

        List<TaxonomySettoreBOBean> res = new ArrayList<>();
        for(DataObject dataObject: obj.getData()){
            TaxonomySettoreBOBean boBean = new TaxonomySettoreBOBean();
            boBean.setName(((TaxonomySettoreResponseAttributes)dataObject.getAttributes()).getName());
            boBean.setUuid(dataObject.getId());
            boBean.setFk(((TaxonomySettoreResponseAttributes)dataObject.getAttributes()).getField_fk());

            res.add(boBean);
        }

        return res;
    }



    /**
     * Crea da una stringa json un oggetto contenente tutti gli attributi
     *
     * @param jsonString
     * @return
     */
    public static TaxonomyRilevanzaResponseBean createRilevanzaResponse_jsonapiFormat(String jsonString){
        Gson g = new Gson();
        TaxonomyRilevanzaResponseBean obj = g.fromJson(jsonString, TaxonomyRilevanzaResponseBean.class);

        return obj;
    }

    /**
     * Crea da una stringa json un oggetto da passare al BO, con attributi filtrati
     *
     * @param jsonString
     * @return
     */
    public static TaxonomyRilevanzaBOBean createRilevanzaResponse_boFormat(String jsonString){
        Gson g = new Gson();
        TaxonomyRilevanzaResponseBean obj = g.fromJson(jsonString, TaxonomyRilevanzaResponseBean.class);
        TaxonomyRilevanzaBOBean boBean = new TaxonomyRilevanzaBOBean();
        boBean.setName(((TaxonomyRilevanzaResponseAttributes)obj.getdata().getAttributes()).getName());
        boBean.setUuid(obj.getdata().getId());
        boBean.setFk(((TaxonomyRilevanzaResponseAttributes)obj.getdata().getAttributes()).getField_fk());

        return boBean;
    }

    /**
     * Crea da una stringa json un oggetto contenente tutti gli attributi
     *
     * @param jsonString
     * @return
     */
    public static TaxonomyRilevanzaResponseBeanList createRilevanzaResponse_jsonapiFormatList(String jsonString){
        Gson g = new Gson();
        TaxonomyRilevanzaResponseBeanList obj = g.fromJson(jsonString, TaxonomyRilevanzaResponseBeanList.class);

        return obj;
    }

    /**
     * Crea da una stringa json un oggetto da passare al BO, con attributi filtrati
     *
     * @param jsonString
     * @return
     */
    public static List<TaxonomyRilevanzaBOBean> createRilevanzaResponse_boFormatList(String jsonString){
        Gson g = new Gson();
        TaxonomyRilevanzaResponseBeanList obj = g.fromJson(jsonString, TaxonomyRilevanzaResponseBeanList.class);

        List<TaxonomyRilevanzaBOBean> res = new ArrayList<>();
        for(DataObject dataObject: obj.getData()){
            TaxonomyRilevanzaBOBean boBean = new TaxonomyRilevanzaBOBean();
            boBean.setName(((TaxonomyRilevanzaResponseAttributes)dataObject.getAttributes()).getName());
            boBean.setUuid(dataObject.getId());
            boBean.setFk(((TaxonomyRilevanzaResponseAttributes)dataObject.getAttributes()).getField_fk());

            res.add(boBean);
        }

        return res;
    }
}
