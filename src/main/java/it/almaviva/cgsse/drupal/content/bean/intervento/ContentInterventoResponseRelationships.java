package it.almaviva.cgsse.drupal.content.bean.intervento;

import it.almaviva.cgsse.drupal.jsonapi.DataAndLinksObject;
import it.almaviva.cgsse.drupal.jsonapi.RelationshipsForContentObjcet;

/**
 * Classe contenente gli attributi specifici per la tassonomia Azienda.
 * Questa classe è usata per castare l'attributo 'attributes' del jsonapi di risposta tornato dai servizzi esposti del FE
 */
public class ContentInterventoResponseRelationships extends RelationshipsForContentObjcet {

    private DataAndLinksObject field_allegato;

    public DataAndLinksObject getField_allegato() {
        return field_allegato;
    }

    public void setField_allegato(DataAndLinksObject field_allegato) {
        this.field_allegato = field_allegato;
    }

    @Override
    public String toString() {
        return "ContentInteventoResponseRelationships{" +
                "field_allegato=" + field_allegato +
                '}';
    }
}

