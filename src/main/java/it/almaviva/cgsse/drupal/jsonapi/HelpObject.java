package it.almaviva.cgsse.drupal.jsonapi;

/**
 * Classe per conversione jsonapi to object, della struttura HelpObject
 */
public class HelpObject {

    private String href;
    private MetaObject meta;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public MetaObject getMeta() {
        return meta;
    }

    public void setMeta(MetaObject meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(HelpObject.class.getName())
                .append( "{" )
                .append("href='" ).append( href ).append( '\'' )
                .append(", meta=" ).append( meta )
                .append('}');
        return s.toString();
    }
}
