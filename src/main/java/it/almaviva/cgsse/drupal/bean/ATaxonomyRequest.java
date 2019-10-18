package it.almaviva.cgsse.drupal.bean;

public abstract class ATaxonomyRequest {

    /**
     * Metodo per convertire un oggetto in una string per una chiamata ad un servizio <b>insert</b> jsonapi
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
     * Metodo per convertire un oggetto in una string per una chiamata ad un servizio <b>update</b> jsonapi
     * @return stringa
     */
    public String toJsonBodyUpdate(){
        StringBuilder body = new StringBuilder();
        body.append("{\"data\":{");

        //TODO Aggiungere uuid

        body.append("\"type\": \"ntaxonomy_term--").append(getTipo()).append("\",");
        body.append("\"attributes\":{").append(attributeToJson()).append("}");
        body.append("}}");
        return body.toString();
    };


    protected abstract String attributeToJson();
    protected abstract String getTipo();

}
