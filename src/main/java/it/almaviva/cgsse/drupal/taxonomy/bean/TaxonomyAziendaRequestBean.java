package it.almaviva.cgsse.drupal.taxonomy.bean;

/**
 *
 */
public class TaxonomyAziendaRequestBean extends ATaxonomy{

    private String name;
    private String uuid;

    public TaxonomyAziendaRequestBean() {
    }

    public TaxonomyAziendaRequestBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected String attributeToJson() {
        StringBuilder sb = new StringBuilder();
        sb.append("\"name\":\"").append(getName()).append("\"");
        return sb.toString();
    }

    @Override
    protected String getTipo() {
        return "azienda";
    }

    public void setUUID(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String getUUID() {
        return uuid;
    }
}
