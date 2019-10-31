package it.almaviva.cgsse.drupal.content.factory;

import it.almaviva.cgsse.bo.bean.content.ContentInterventoBOBean;
import it.almaviva.cgsse.drupal.content.bean.intervento.InterventoWorkableBean;

import java.util.LinkedList;
import java.util.List;

public class BOFactory {
    public static List<ContentInterventoBOBean> convertWorkableToBO(List<InterventoWorkableBean> reqList) {
        List<ContentInterventoBOBean> res = new LinkedList<>();
        for(InterventoWorkableBean bean:reqList){
            ContentInterventoBOBean boBean = new ContentInterventoBOBean();
            boBean.setIntervento(bean.getIntervento());
            boBean.setPosizione(bean.getPosizione());
            boBean.setDataIntervento(bean.getDataIntervento());
            boBean.setDesctizione(bean.getDescrizione());
            boBean.setFk(bean.getFk());
            boBean.setAllegato(bean.getAllegato());
            boBean.setTitle(bean.getTitle());

            res.add(boBean);
        }

        return res;
    }
}
