package it.almaviva.cgsse.drupal.content.bean.sciopero;

import it.almaviva.cgsse.drupal.jsonapi.AttributesObject;

/**
 * Classe contenente gli attributi specifici per la tassonomia Azienda.
 * Questa classe è usata per castare l'attributo 'attributes' del jsonapi di risposta tornato dai servizzi esposti del FE
 */
public class ContentScioperoResponseAttributes extends AttributesObject {

    private String title;
    private String body;
    private String field_controparte;
    private Boolean field_differito;
    private String field_fine;
    private String field_fk;
    private String field_inizio;
    private String field_posizione;
    private Boolean field_revocato;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getField_controparte() {
        return field_controparte;
    }

    public void setField_controparte(String field_controparte) {
        this.field_controparte = field_controparte;
    }

    public Boolean getField_differito() {
        return field_differito;
    }

    public void setField_differito(Boolean field_differito) {
        this.field_differito = field_differito;
    }

    public String getField_fine() {
        return field_fine;
    }

    public void setField_fine(String field_fine) {
        this.field_fine = field_fine;
    }

    public String getField_fk() {
        return field_fk;
    }

    public void setField_fk(String field_fk) {
        this.field_fk = field_fk;
    }

    public String getField_inizio() {
        return field_inizio;
    }

    public void setField_inizio(String field_inizio) {
        this.field_inizio = field_inizio;
    }

    public String getField_posizione() {
        return field_posizione;
    }

    public void setField_posizione(String field_posizione) {
        this.field_posizione = field_posizione;
    }

    public Boolean getField_revocato() {
        return field_revocato;
    }

    public void setField_revocato(Boolean field_revocato) {
        this.field_revocato = field_revocato;
    }

    //TODO
    @Override
    public String toString() {
        return "ContentScioperiResponseAttributes{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", field_controparte='" + field_controparte + '\'' +
                ", field_differito=" + field_differito +
                ", field_fine='" + field_fine + '\'' +
                ", field_fk='" + field_fk + '\'' +
                ", field_inizio='" + field_inizio + '\'' +
                ", field_posizione='" + field_posizione + '\'' +
                ", field_revocato=" + field_revocato +
                '}';
    }
}
