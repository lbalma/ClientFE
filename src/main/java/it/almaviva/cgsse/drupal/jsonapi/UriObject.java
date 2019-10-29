package it.almaviva.cgsse.drupal.jsonapi;

/**
 * Classe per conversione jsonapi to object, della struttura Uri
 */
public class UriObject {

    private String value;
    private String url;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(SelfObject.class.getName())
                .append("{" )
                .append("value='").append( value ).append("\',")
                .append("url='").append( url ).append('\'' )
                .append('}');
        return s.toString();
    }
}
