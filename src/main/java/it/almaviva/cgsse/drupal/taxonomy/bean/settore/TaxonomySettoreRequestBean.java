package it.almaviva.cgsse.drupal.taxonomy.bean.settore;
import it.almaviva.cgsse.drupal.taxonomy.bean.ATaxonomy;

import static it.almaviva.cgsse.drupal.taxonomy.utils.Costants.TAXONOMY_SETTORE;

/**
 * Classe per effettuare richieste hai servizzi esposti del FE per la tassonomia Azienda
 */
public class TaxonomySettoreRequestBean extends ATaxonomy {

    private String name;
    private String uuid;
    private String fk;

    public TaxonomySettoreRequestBean() {
    }

    public TaxonomySettoreRequestBean(String name) {
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
        return TAXONOMY_SETTORE;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String getUuid() {
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
