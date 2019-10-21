package it.almaviva.cgsse.drupal.jsonapi;

/**
 * Classe per conversione jsonapi to object, della struttura ReletedObject
 */
public class ReletedObject {

    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(ReletedObject.class.getName())
                .append("{" )
                .append("href='" ).append( href ).append( '\'' )
                .append('}');
        return s.toString();
    }
}
