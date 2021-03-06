package it.almaviva.cgsse.drupal.taxonomy.bean;

import it.almaviva.cgsse.drupal.common.bean.AJsonapiRequestBean;

/**
 * Classe asratta contenente i metodi generici per una semplice comunicazione con FE
 */
public abstract class ATaxonomy extends AJsonapiRequestBean {

    /**
     * Metodo per convertire un oggetto in una string json per una chiamata ad un servizio <b>insert</b> jsonapi
     * @return stringa
     */
    public String toJsonBodyInsert(){
        StringBuilder body = new StringBuilder();
        body.append("{\"data\":{");
        body.append("\"type\": \"ntaxonomy_term--").append(getTipo()).append("\",");
        body.append("\"attributes\":{").append(attributeToJson()).append("}");
        body.append("}}");
        return body.toString();
    }


    /**
     * Metodo per convertire un oggetto in una string json per una chiamata ad un servizio <b>update</b> jsonapi
     * @return stringa
     */
    public String toJsonBodyUpdate(){
        StringBuilder body = new StringBuilder();
        body.append("{\"data\":{");
        body.append("\"type\": \"ntaxonomy_term--").append(getTipo()).append("\",");
        body.append("\"id\":\"").append(getUuid()).append("\",");
        body.append("\"attributes\":{").append(attributeToJson()).append("}");
        body.append("}}");
        return body.toString();
    };

    /**
     * Metodo per convertire un oggetto in una string json
     * @return stringa
     */
    public String toJsonBody(){
        StringBuilder body = new StringBuilder();
        if(getUuid() != null){
            body.append("{\"data\":{");
            body.append("\"type\": \"ntaxonomy_term--").append(getTipo()).append("\",");
            body.append("\"id\":\"").append(getUuid()).append("\"");
            body.append("}}");
        }else{
            body.append("{\"data\": null}");
        }

        return body.toString();
    }

    /**
     * Metodo per convertire un oggetto in una string json
     * @return stringa
     */
    @Override
    public String toJsonBodyInject(){
        StringBuilder body = new StringBuilder();
        if(getUuid() != null){
            body.append("{\"data\":{");
            body.append("\"type\": \"taxonomy_term--").append(getTipo()).append("\",");
            body.append("\"id\":\"").append(getUuid()).append("\"");
            body.append("}}");
        }else{
            body.append("{\"data\": null}");
        }

        System.out.println(body.toString());
        return body.toString();
    }

    @Override
    public String toJsonBodyTypeId(){
        StringBuilder body = new StringBuilder();
        if(getUuid() != null){
            body.append("{");
            body.append("\"type\": \"taxonomy_term--").append(getTipo()).append("\",");
            body.append("\"id\":\"").append(getUuid()).append("\"");
            body.append("}");
        }else{
            body.append("{}");
        }

        System.out.println(body.toString());
        return body.toString();
    }

    @Override
    public  String getTheUuid(){
        return getUuid();
    }

    @Override
    public  String getTheFk(){
        return getFk();
    }


    protected abstract String attributeToJson();
    protected abstract String getTipo();
    public abstract String getUuid();
    public abstract String getFk();


}
