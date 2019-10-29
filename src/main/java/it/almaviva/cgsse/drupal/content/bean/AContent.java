package it.almaviva.cgsse.drupal.content.bean;

import it.almaviva.cgsse.drupal.common.bean.AJsonapiRequestBean;

/**
 * Classe asratta contenente i metodi generici per una semplice comunicazione con FE
 */
public abstract class AContent extends AJsonapiRequestBean {

    /**
     * Metodo per convertire un oggetto in una string per una chiamata ad un servizio <b>insert</b> jsonapi
     * @return stringa
     */
    @Override
    public String toJsonBodyInsert(){
        StringBuilder body = new StringBuilder();
        body.append("{\"data\":{");
        body.append("\"type\": \"ntaxonomy_term--").append(getTipo()).append("\",");
        body.append("\"attributes\":{").append(attributeToJson()).append("},");
        body.append("\"relationships\":{").append(relationshipToJson()).append("}");
       // body.append(taxonomyToJson().trim().isEmpty() ? "" : ","+ taxonomyToJson());
        body.append("}");
        body.append("}");

        System.out.println(body.toString());
        return body.toString();
    }



    /**
     * Metodo per convertire un oggetto in una string per una chiamata ad un servizio <b>update</b> jsonapi
     * @return stringa
     */
    @Override
    public String toJsonBodyUpdate(){
        StringBuilder body = new StringBuilder();
        body.append("{\"data\":{");
        body.append("\"type\": \"ntaxonomy_term--").append(getTipo()).append("\",");
        body.append("\"id\":\"").append(getUuid()).append("\",");
        body.append("\"attributes\":{").append(attributeToJson()).append("},");
        body.append("\"relationship\":{").append(relationshipToJson()).append("}");
     //   body.append(taxonomyToJson().trim().isEmpty() ? "" : ","+ taxonomyToJson());

        body.append("}}");

        System.out.println(body.toString());
        return body.toString();
    };

    @Override
    public String toJsonBodyTypeId(){
        StringBuilder body = new StringBuilder();
        if(getUuid() != null){
            body.append("{");
            body.append("\"type\": \"node--").append(getTipo()).append("\",");
            body.append("\"id\":\"").append(getUuid()).append("\"");
            body.append("}");
        }else{
            body.append("{}");
        }

        System.out.println(body.toString());
        return body.toString();
    }

    @Override
    public String toJsonBodyInject(){
        StringBuilder body = new StringBuilder();
        if(getUuid() != null){
            body.append("{\"data\":{");
            body.append("\"type\": \"node--").append(getTipo()).append("\",");
            body.append("\"id\":\"").append(getUuid()).append("\"");
            body.append("}}");
        }else{
            body.append("{\"data\": null}");
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
    protected abstract String relationshipToJson();
    //protected abstract String taxonomyToJson();
    protected abstract String getTipo();
    public abstract String getUuid();
    public abstract String getFk();

    public byte[] getBinaryFile() {
        return new byte[0];
    }

    public String getFileName() {
        return "";
    }

}
