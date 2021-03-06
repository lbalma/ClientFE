package it.almaviva.cgsse.bo.bean.content;

import it.almaviva.cgsse.bo.bean.BOBean;
import it.almaviva.cgsse.bo.bean.taxonomy.TaxonomyAziendaBOBean;
import it.almaviva.cgsse.bo.bean.taxonomy.TaxonomyRilevanzaBOBean;
import it.almaviva.cgsse.bo.bean.taxonomy.TaxonomySettoreBOBean;

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
    private TaxonomyAziendaBOBean azienda;
    private TaxonomyRilevanzaBOBean rilevanza;
    private TaxonomySettoreBOBean settore;


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
        return (Date)fine.clone();
    }

    public void setFine(Date fine) {
        this.fine = fine != null ? new Date(fine.getTime()): null;
    }

    public Date getInizio() {
        return (Date)inizio.clone();
    }

    public void setInizio(Date inizio) {
        this.inizio = inizio != null ? new Date(inizio.getTime()): null;
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

    public TaxonomyAziendaBOBean getAzienda() {
        return azienda;
    }

    public void setAzienda(TaxonomyAziendaBOBean azienda) {
        this.azienda = azienda;
    }

    public TaxonomyRilevanzaBOBean getRilevanza() {
        return rilevanza;
    }

    public void setRilevanza(TaxonomyRilevanzaBOBean rilevanza) {
        this.rilevanza = rilevanza;
    }

    public TaxonomySettoreBOBean getSettore() {
        return settore;
    }

    public void setSettore(TaxonomySettoreBOBean settore) {
        this.settore = settore;
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
                ", azienda=" + azienda +
                ", rilevanza=" + rilevanza +
                ", settore=" + settore +
                '}';
    }
}
