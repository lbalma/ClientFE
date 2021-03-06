package it.almaviva.cgsse.drupal.common.bean;

public abstract class AJsonapiRequestBean {

    /**
     * Metodo per convertire un oggetto in una string per una chiamata ad un servizio <b>insert</b> jsonapi
     * @return stringa
     */
    public abstract String toJsonBodyInsert();

    /**
     * Metodo per convertire un oggetto in una string per una chiamata ad un servizio <b>update</b> jsonapi
     * @return stringa
     */
    public abstract String toJsonBodyUpdate();

    public abstract String toJsonBodyInject();

    public abstract String toJsonBodyTypeId();

    public abstract String getTheUuid();
    public abstract String getTheFk();

}
