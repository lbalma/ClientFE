package it.almaviva.cgsse.drupal.content.factory;

import it.almaviva.cgsse.bo.bean.content.ContentInterventoBOBean;
import it.almaviva.cgsse.bo.bean.content.ContentScioperoBOBean;
import it.almaviva.cgsse.drupal.content.bean.intervento.InterventoWorkableBean;
import it.almaviva.cgsse.drupal.content.bean.sciopero.ScioperoWorkableBean;
import it.almaviva.cgsse.utils.Tools;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BOFactory {
    public static List<ContentInterventoBOBean> convertWorkableToBOInterventi(List<InterventoWorkableBean> reqList) throws ParseException {
        List<ContentInterventoBOBean> res = new LinkedList<>();
        for(InterventoWorkableBean bean:reqList){
            ContentInterventoBOBean boBean = new ContentInterventoBOBean();
            boBean.setIntervento(bean.getIntervento());
            boBean.setPosizione(bean.getPosizione());
            boBean.setDataIntervento(Tools.drupalStringDateToDate(bean.getDataIntervento()));
            boBean.setDescrizione(bean.getDescrizione());
            boBean.setFk(bean.getFk());
            boBean.setAllegato(bean.getAllegato());
            boBean.setTitle(bean.getTitle());

            res.add(boBean);
        }

        return res;
    }

    public static ContentScioperoBOBean convertWorkableToBOScioperi(ScioperoWorkableBean bean) throws ParseException {
        ContentScioperoBOBean boBean = new ContentScioperoBOBean();
        boBean.setTitle(bean.getTitle());
        boBean.setControparte(bean.getControparte());
        boBean.setPosizione(bean.getPosizione());
        boBean.setFk(bean.getFk());
        boBean.setFine(Tools.drupalStringDateToDate(bean.getFine()));
        boBean.setInizio(Tools.drupalStringDateToDate(bean.getInizio()));
        boBean.setRevocato(bean.getRevocato());
        boBean.setDifferito(bean.getDifferito());

        return boBean;
    }
}
