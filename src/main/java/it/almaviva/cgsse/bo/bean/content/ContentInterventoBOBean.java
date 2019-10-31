package it.almaviva.cgsse.bo.bean.content;

import it.almaviva.cgsse.bo.bean.BOBean;


public class ContentInterventoBOBean extends BOBean {

    private String intervento;
    private String posizione;
    private String dataIntervento;
    private String desctizione;
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

    public String getDataIntervento() {
        return dataIntervento;
    }

    public void setDataIntervento(String dataIntervento) {
        this.dataIntervento = dataIntervento;
    }

    public String getDesctizione() {
        return desctizione;
    }

    public void setDesctizione(String desctizione) {
        this.desctizione = desctizione;
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
                ", desctizione='" + desctizione + '\'' +
                ", fk='" + fk + '\'' +
                ", allegato='" + allegato + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
