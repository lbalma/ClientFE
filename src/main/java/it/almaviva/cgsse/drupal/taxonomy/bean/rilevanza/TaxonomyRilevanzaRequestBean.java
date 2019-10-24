package it.almaviva.cgsse.drupal.taxonomy.bean.rilevanza;
import it.almaviva.cgsse.drupal.taxonomy.bean.ATaxonomy;

import static it.almaviva.cgsse.drupal.taxonomy.Costants.TAXONOMY_AZIENDA;

/**
 * Classe per effettuare richieste hai servizzi esposti del FE per la tassonomia Azienda
 */
public class TaxonomyRilevanzaRequestBean extends ATaxonomy {

    private String name;
    private String uuid;
    private String fk;

    public TaxonomyRilevanzaRequestBean() {
    }

    public TaxonomyRilevanzaRequestBean(String name) {
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
        sb.append("\"name\":\"").append(getName()).append("\",");
        sb.append("\"field_fk\":\"").append(getFk()).append("\"");
        return sb.toString();
    }

    @Override
    protected String getTipo() {
        return TAXONOMY_AZIENDA;
    }

    public void setUUID(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String getUUID() {
        return uuid;
    }

    @Override
    public String getFk() {
        return fk;
    }

    public void setFk(String fk) {
        this.fk = fk;
    }
}
