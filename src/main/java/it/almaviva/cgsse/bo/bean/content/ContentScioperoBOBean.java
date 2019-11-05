package it.almaviva.cgsse.bo.bean.content;

import it.almaviva.cgsse.bo.bean.BOBean;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class ContentScioperoBOBean extends BOBean {

    private String title;
    private String controparte;
    private String posizione;
    private String fk;
    private Date fine;
    private Date inizio;
    private Boolean revocato;
    private Boolean differito;

    private List<ContentInterventoBOBean> interventi = new LinkedList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getControparte() {
        return controparte;
    }

    public void setControparte(String controparte) {
        this.controparte = controparte;
    }

    public String getPosizione() {
        return posizione;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }

    public String getFk() {
        return fk;
    }

    public void setFk(String fk) {
        this.fk = fk;
    }

    public Date getFine() {
        return fine;
    }

    public void setFine(Date fine) {
        this.fine = fine;
    }

    public Date getInizio() {
        return inizio;
    }

    public void setInizio(Date inizio) {
        this.inizio = inizio;
    }

    public Boolean getRevocato() {
        return revocato;
    }

    public void setRevocato(Boolean revocato) {
        this.revocato = revocato;
    }

    public Boolean getDifferito() {
        return differito;
    }

    public void setDifferito(Boolean differito) {
        this.differito = differito;
    }

    public List<ContentInterventoBOBean> getInterventi() {
        return interventi;
    }

    public void setInterventi(List<ContentInterventoBOBean> interventi) {
        this.interventi = interventi;
    }

    @Override
    public String toString() {
        return "ContentScioperoBOBean{" +
                "title='" + title + '\'' +
                ", controparte='" + controparte + '\'' +
                ", posizione='" + posizione + '\'' +
                ", fk='" + fk + '\'' +
                ", fine=" + fine +
                ", inizio=" + inizio +
                ", revocato=" + revocato +
                ", differito=" + differito +
                ", interventi=" + interventi +
                '}';
    }
}
