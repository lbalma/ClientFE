package it.almaviva.cgsse.drupal.content.bean.sciopero;

import it.almaviva.cgsse.drupal.jsonapi.DataAndLinksObject;
import it.almaviva.cgsse.drupal.jsonapi.DataListAndLinksObject;
import it.almaviva.cgsse.drupal.jsonapi.RelationshipsForContentObjcet;

import java.util.List;

/**
 * Classe contenente gli attributi specifici per la tassonomia Azienda.
 * Questa classe è usata per castare l'attributo 'attributes' del jsonapi di risposta tornato dai servizzi esposti del FE
 */
public class ContentScioperoResponseRelationships extends RelationshipsForContentObjcet {

    private DataAndLinksObject field_azienda;
    private DataAndLinksObject field_rilevanza;
    private DataAndLinksObject field_settore;
    private DataListAndLinksObject field_delibere;
    private DataListAndLinksObject field_interventi;

    public DataAndLinksObject getField_azienda() {
        return field_azienda;
    }

    public void setField_azienda(DataAndLinksObject field_azienda) {
        this.field_azienda = field_azienda;
    }

    public DataAndLinksObject getField_rilevanza() {
        return field_rilevanza;
    }

    public void setField_rilevanza(DataAndLinksObject field_rilevanza) {
        this.field_rilevanza = field_rilevanza;
    }

    public DataAndLinksObject getField_settore() {
        return field_settore;
    }

    public void setField_settore(DataAndLinksObject field_settore) {
        this.field_settore = field_settore;
    }

    public DataListAndLinksObject getField_delibere() {
        return field_delibere;
    }

    public void setField_delibere(DataListAndLinksObject field_delibere) {
        this.field_delibere = field_delibere;
    }

    public DataListAndLinksObject getField_interventi() {
        return field_interventi;
    }

    public void setField_interventi(DataListAndLinksObject field_interventi) {
        this.field_interventi = field_interventi;
    }

    //TODO
    @Override
    public String toString() {
        return "ContentScioperiResponseRelationships{" +
                "field_azienda=" + field_azienda +
                ", field_rilevanza=" + field_rilevanza +
                ", field_settore=" + field_settore +
                ", field_delibere=" + field_delibere +
                ", field_interventi=" + field_interventi +
                '}';
    }
}
