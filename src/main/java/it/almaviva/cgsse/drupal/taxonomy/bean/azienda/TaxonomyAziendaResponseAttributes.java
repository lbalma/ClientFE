package it.almaviva.cgsse.drupal.taxonomy.bean.azienda;

import it.almaviva.cgsse.drupal.jsonapi.AttributesObject;

/**
 * Classe contenente gli attributi specifici per la tassonomia Azienda.
 * Questa classe è usata per castare l'attributo 'attributes' del jsonapi di risposta tornato dai servizzi esposti del FE
 */
public class TaxonomyAziendaResponseAttributes extends AttributesObject {

    private String name;
    private String field_fk;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField_fk() {
        return field_fk;
    }

    public void setField_fk(String field_fk) {
        this.field_fk = field_fk;
    }
}
