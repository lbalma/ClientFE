package it.almaviva.cgsse.drupal.taxonomy.bean;

import it.almaviva.cgsse.drupal.jsonapi.AttributesObject;

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
