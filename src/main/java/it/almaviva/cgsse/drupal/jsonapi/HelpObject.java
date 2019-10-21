package it.almaviva.cgsse.drupal.jsonapi;

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
        return "HelpObject{" +
                "href='" + href + '\'' +
                ", meta=" + meta +
                '}';
    }
}
