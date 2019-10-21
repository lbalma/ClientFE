package it.almaviva.cgsse.drupal.jsonapi;

/**
 * Classe per conversione jsonapi to object, della struttura JsonapiObject
 */
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
        StringBuilder s = new StringBuilder(JsonapiObject.class.getName())
                .append("{")
                .append("version='").append(version ).append('\'')
                .append(", meta=").append(meta)
                .append('}');
        return s.toString();
    }
}
