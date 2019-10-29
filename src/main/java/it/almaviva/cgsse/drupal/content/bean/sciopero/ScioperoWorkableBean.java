package it.almaviva.cgsse.drupal.content.bean.sciopero;

import java.util.List;

public class ScioperoWorkableBean  {

     private String title;
     private String controparte;
     private String posizione;
     private String fine;
     private String inizio;
     private String uuid;
     private Boolean revocato;
     private Boolean differito;
     private String fk;

     private String azienda;
     private String settore;
     private String rilevanza;

     private List<String> interventi;

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

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    public String getInizio() {
        return inizio;
    }

    public void setInizio(String inizio) {
        this.inizio = inizio;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getFk() {
        return fk;
    }

    public void setFk(String fk) {
        this.fk = fk;
    }

    public String getAzienda() {
        return azienda;
    }

    public void setAzienda(String azienda) {
        this.azienda = azienda;
    }

    public String getSettore() {
        return settore;
    }

    public void setSettore(String settore) {
        this.settore = settore;
    }

    public String getRilevanza() {
        return rilevanza;
    }

    public void setRilevanza(String rilevanza) {
        this.rilevanza = rilevanza;
    }

    public List<String> getInterventi() {
        return interventi;
    }

    public void setInterventi(List<String> interventi) {
        this.interventi = interventi;
    }

    @Override
    public String toString() {
        return "ScioperoWorkableBean{" +
                "title='" + title + '\'' +
                ", controparte='" + controparte + '\'' +
                ", posizione='" + posizione + '\'' +
                ", fine='" + fine + '\'' +
                ", inizio='" + inizio + '\'' +
                ", uuid='" + uuid + '\'' +
                ", revocato=" + revocato +
                ", differito=" + differito +
                ", fk='" + fk + '\'' +
                ", azienda='" + azienda + '\'' +
                ", settore='" + settore + '\'' +
                ", rilevanza='" + rilevanza + '\'' +
                ", interventi=" + interventi +
                '}';
    }
}

