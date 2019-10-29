package it.almaviva.cgsse.drupal.content.bean.intervento;

public class InterventoWorkableBean {

    private String uuid;
    private String intervento;
    private String posizione;
    private String dataIntervento;
    private String descrizione;
    private String fk;
    private String title;

    private String allegato;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getDataIntervento() {
        return dataIntervento;
    }

    public void setDataIntervento(String dataIntervento) {
        this.dataIntervento = dataIntervento;
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
        return "InterventoWorkableBean{" +
                "uuid='" + uuid + '\'' +
                ", intervento='" + intervento + '\'' +
                ", posizione='" + posizione + '\'' +
                ", dataIntervento='" + dataIntervento + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", fk='" + fk + '\'' +
                ", title='" + title + '\'' +
                ", allegato='" + allegato + '\'' +
                '}';
    }
}

