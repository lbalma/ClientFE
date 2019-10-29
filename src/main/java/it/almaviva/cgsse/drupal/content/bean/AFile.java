package it.almaviva.cgsse.drupal.content.bean;

/**
 * Classe asratta contenente i metodi generici per una semplice comunicazione con FE
 */
public abstract class AFile {


    /**
     * Metodo per convertire un oggetto in una string json
     * @return stringa
     */
    public String toJsonBody(){
        StringBuilder body = new StringBuilder();

        if(getUuid() != null && !getUuid().trim().isEmpty()){
            body.append("{\"data\":{");
            body.append("\"type\": \"file--").append(getTipo()).append("\",");
            body.append("\"id\":\"").append(getUuid()).append("\",");
            body.append("\"meta\":{\"description\": \"").append(getDescription()).append("\"}");
            body.append("}}");
        }else{
            body.append("{\"data\":null}");
        }

        System.out.println(body.toString());
        return body.toString();
    }

    protected abstract String getTipo();
    public abstract String getUuid();
    public abstract String getDescription();
}
