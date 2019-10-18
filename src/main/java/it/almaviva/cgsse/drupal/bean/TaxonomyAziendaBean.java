package it.almaviva.cgsse.drupal.bean;

/**
 *
 */
public class TaxonomyAziendaBean extends ATaxonomyRequest{

    private String name;

    public TaxonomyAziendaBean() {
    }

    public TaxonomyAziendaBean(String name) {
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
}
