package it.almaviva.cgsse.drupal.taxonomy.factory;

import com.google.gson.Gson;
import it.almaviva.cgsse.bo.bean.TaxonomyAziendaBOBean;
import it.almaviva.cgsse.drupal.jsonapi.DataObject;
import it.almaviva.cgsse.drupal.taxonomy.bean.TaxonomyAziendaResponseAttributes;
import it.almaviva.cgsse.drupal.taxonomy.bean.TaxonomyAziendaResponseBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.TaxonomyAziendaResponseBeanList;

import java.util.ArrayList;
import java.util.List;

public class TaxonomyFactory {

    public static TaxonomyAziendaResponseBean createAziendaResponse_jsonapiFormat(String jsonString){
        Gson g = new Gson();
        TaxonomyAziendaResponseBean obj = g.fromJson(jsonString, TaxonomyAziendaResponseBean.class);

        return obj;
    }

    public static TaxonomyAziendaBOBean createAziendaResponse_boFormat(String jsonString){
        Gson g = new Gson();
        TaxonomyAziendaResponseBean obj = g.fromJson(jsonString, TaxonomyAziendaResponseBean.class);
        TaxonomyAziendaBOBean boBean = new TaxonomyAziendaBOBean();
        boBean.setName(((TaxonomyAziendaResponseAttributes)obj.getdata().getAttributes()).getName());
        boBean.setUuid(obj.getdata().getId());
        return boBean;
    }


    public static TaxonomyAziendaResponseBeanList createAziendaResponse_jsonapiFormatList(String jsonString){
        Gson g = new Gson();
        TaxonomyAziendaResponseBeanList obj = g.fromJson(jsonString, TaxonomyAziendaResponseBeanList.class);

        return obj;
    }

    public static List<TaxonomyAziendaBOBean> createAziendaResponse_boFormatList(String jsonString){
        Gson g = new Gson();
        TaxonomyAziendaResponseBeanList obj = g.fromJson(jsonString, TaxonomyAziendaResponseBeanList.class);

        List<TaxonomyAziendaBOBean> res = new ArrayList<TaxonomyAziendaBOBean>();
        for(DataObject dataObject: obj.getData()){
            TaxonomyAziendaBOBean boBean = new TaxonomyAziendaBOBean();
            boBean.setName(((TaxonomyAziendaResponseAttributes)dataObject.getAttributes()).getName());
            boBean.setUuid(dataObject.getId());
            res.add(boBean);
        }

        return res;
    }
}
