package it.almaviva.cgsse.drupal.taxonomy.bean;

import it.almaviva.cgsse.drupal.jsonapi.AttributesObject;

/**
 * Classe contenente gli attributi specifici per la tassonomia Azienda.
 * Questa classe è usata per castare l'attributo 'attributes' del jsonapi di risposta tornato dai servizzi esposti del FE
 */
public class TaxonomyAziendaResponseAttributes extends AttributesObject {

    private String name;
    private String uuid; //TODO forse non serve

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
