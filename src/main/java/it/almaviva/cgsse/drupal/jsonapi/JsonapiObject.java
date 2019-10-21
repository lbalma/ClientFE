package it.almaviva.cgsse.drupal.jsonapi;

public class JsonapiObject {

    private String version;
    private MetaObject meta;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public MetaObject getMeta() {
        return meta;
    }

    public void setMeta(MetaObject meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        return "JsonapiObject{" +
                "version='" + version + '\'' +
                ", meta=" + meta +
                '}';
    }
}
