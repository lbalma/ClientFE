package it.almaviva.cgsse.drupal.content.bean.intervento;

import it.almaviva.cgsse.drupal.jsonapi.AttributesObject;

/**
 * Classe contenente gli attributi specifici per la tassonomia Azienda.
 * Questa classe è usata per castare l'attributo 'attributes' del jsonapi di risposta tornato dai servizzi esposti del FE
 */
public class ContentInterventoResponseAttributes extends AttributesObject {

    private String body;
    private String field_data_intervento;
    private String field_descrizione;
    private String field_intervento;
    private String field_fk;
    private String field_posizione;
    private String title;


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getField_data_intervento() {
        return field_data_intervento;
    }

    public void setField_data_intervento(String field_data_intervento) {
        this.field_data_intervento = field_data_intervento;
    }

    public String getField_descrizione() {
        return field_descrizione;
    }

    public void setField_descrizione(String field_descrizione) {
        this.field_descrizione = field_descrizione;
    }

    public String getField_intervento() {
        return field_intervento;
    }

    public void setField_intervento(String field_intervento) {
        this.field_intervento = field_intervento;
    }

    public String getField_fk() {
        return field_fk;
    }

    public void setField_fk(String field_fk) {
        this.field_fk = field_fk;
    }

    public String getField_posizione() {
        return field_posizione;
    }

    public void setField_posizione(String field_posizione) {
        this.field_posizione = field_posizione;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ContentInterventoResponseAttributes{" +
                "body='" + body + '\'' +
                ", field_data_intervento='" + field_data_intervento + '\'' +
                ", field_descrizione=" + field_descrizione +
                ", field_intervento='" + field_intervento + '\'' +
                ", field_fk='" + field_fk + '\'' +
                ", title='" + title + '\'' +
                ", field_posizione='" + field_posizione + '\'' +
                '}';
    }
}
