package it.almaviva.cgsse.drupal.content.client;

import it.almaviva.cgsse.drupal.common.bean.AJsonapiRequestBean;

import java.util.List;

public class ClientUtils {
    public static String getBodyJsonToRequestBeanList(List<AJsonapiRequestBean> req) {
        StringBuilder s = new StringBuilder();
        if(req != null){
            s.append("{\"data\":[");
            for(int i = 0; i < req.size(); i++){
                s.append(req.get(i).toJsonBodyTypeId());
                if(i != req.size()-1){
                    s.append(",");
                }
            }
        }
        s.append("]}");

        return s.toString();
    }
}
