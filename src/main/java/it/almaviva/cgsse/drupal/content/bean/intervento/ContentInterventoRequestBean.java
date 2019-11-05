package it.almaviva.cgsse.drupal.content.bean.intervento;

import it.almaviva.cgsse.drupal.content.bean.AContent;
import it.almaviva.cgsse.drupal.content.bean.GenericFile;
import it.almaviva.cgsse.drupal.content.bean.IRelationship;
import it.almaviva.cgsse.utils.Tools;

import java.util.Date;

import static it.almaviva.cgsse.drupal.content.utils.Costants.CONTENT_INTERVENTO;

public class ContentInterventoRequestBean extends AContent implements IRelationship {

     private String uuid;
     private String intervento;
     private String posizione;
     private String title;
     private Date dataIntervento;
     private String descrizione;
     private String fk;

     private GenericFile allegato = new GenericFile();

    @Override
    public String getFk() {
        return fk;
    }

    @Override
    public byte[] getBinaryFile() {
        if(this.allegato != null && this.allegato.getFile() != null){
            return this.allegato.getFile();
        }
        return new byte[0];
    }

    @Override
    public String getFileName() {
        if(this.allegato != null && this.allegato.getName() != null){
            return this.allegato.getName();
        }
        return "";
    }

    public void setFk(String fk) {
        this.fk = fk;
    }

    public String getIntervento() {
        return intervento;
    }

    public void setIntervento(String intervento) {
        this.intervento = intervento;
    }

    public String getPosizione() {
        return posizione;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }

    public Date getDataIntervento() {
        return dataIntervento;
    }

    public void setDataIntervento(Date dataIntervento) {
        this.dataIntervento = dataIntervento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GenericFile getAllegato() {
        return allegato;
    }

    public void setAllegato(GenericFile allegato) {
        this.allegato = allegato;
    }

    @Override
    protected String attributeToJson() {
        StringBuilder sb = new StringBuilder();
        sb.append("\"title\":\"").append(getTitle()).append("\",");
        sb.append("\"field_data_intervento\":\"").append(Tools.dateToDrupalStringDate(getDataIntervento())).append("\",");
        sb.append("\"field_descrizione\":\"").append(getDescrizione()).append("\",");
        sb.append("\"field_posizione\":\"").append(getPosizione()).append("\",");
        sb.append("\"field_fk\":\"").append(getFk()).append("\",");
        sb.append("\"field_intervento\":\"").append(getIntervento()).append("\"");

        return sb.toString();
    }

    @Override
    protected String relationshipToJson() {
        StringBuilder sb = new StringBuilder();
        sb.append("\"field_allegato\":");
        sb.append(allegato.toJsonBody());

        return sb.toString();
    }

    @Override
    protected String getTipo() {
        return CONTENT_INTERVENTO;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String getUuid() {
        return this.uuid;
    }


    @Override
    public String toString() {
        return "ContentInterventoRequestBean{" +
                "uuid='" + uuid + '\'' +
                ", title='" + title + '\'' +
                ", intervento='" + intervento + '\'' +
                ", posizione='" + posizione + '\'' +
                ", dataIntervento='" + dataIntervento + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", fk='" + fk + '\'' +
                ", allegato=" + allegato +
                '}';
    }

    @Override
    public String toJsonBodyRelationship() {
        StringBuilder body = new StringBuilder();

        if(getUuid() != null && !getUuid().trim().isEmpty()){
            body.append("{");
            body.append("\"type\": \"node--").append(getTipo()).append("\",");
            body.append("\"id\":\"").append(getUuid()).append("\"");
            //body.append("\"meta\":{\"description\": \"").append(getDescrizione()).append("\"}");
            body.append("}");
        }else{
            body.append("null");
        }

        System.out.println(body.toString());
        return body.toString();    }
}
