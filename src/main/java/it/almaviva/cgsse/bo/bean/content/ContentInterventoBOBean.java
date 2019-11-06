package it.almaviva.cgsse.bo.bean.content;

import it.almaviva.cgsse.bo.bean.BOBean;

import java.util.Date;


public class ContentInterventoBOBean extends BOBean {

    private String intervento;
    private String posizione;
    private Date dataIntervento;
    private String descrizione;
    private String fk;
    private String allegato;
    private String title;

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
        return (Date)dataIntervento.clone();
    }

    public void setDataIntervento(Date dataIntervento) {
        this.dataIntervento = dataIntervento != null ? new Date(dataIntervento.getTime()): null;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getFk() {
        return fk;
    }

    public void setFk(String fk) {
        this.fk = fk;
    }

    public String getAllegato() {
        return allegato;
    }

    public void setAllegato(String allegato) {
        this.allegato = allegato;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ContentInterventoBOBean{" +
                "intervento='" + intervento + '\'' +
                ", posizione='" + posizione + '\'' +
                ", dataIntervento='" + dataIntervento + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", fk='" + fk + '\'' +
                ", allegato='" + allegato + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
