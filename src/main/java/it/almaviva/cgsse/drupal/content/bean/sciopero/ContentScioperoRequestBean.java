package it.almaviva.cgsse.drupal.content.bean.sciopero;

import it.almaviva.cgsse.drupal.content.bean.AContent;
import it.almaviva.cgsse.drupal.content.bean.intervento.ContentInterventoRequestBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.azienda.TaxonomyAziendaRequestBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.rilevanza.TaxonomyRilevanzaRequestBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.settore.TaxonomySettoreRequestBean;
import it.almaviva.cgsse.utils.Tools;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static it.almaviva.cgsse.drupal.content.utils.Costants.CONTENT_SCIOPERO;

public class ContentScioperoRequestBean extends AContent {

    private String title;
    private String controparte;
    private String posizione;
    private Date fine;
    private Date inizio;
    private String uuid;
    private Boolean revocato;
    private Boolean differito;
    private String fk;

    private TaxonomyAziendaRequestBean azienda = new TaxonomyAziendaRequestBean();
    private TaxonomySettoreRequestBean settore = new TaxonomySettoreRequestBean();
    private TaxonomyRilevanzaRequestBean rilevanza = new TaxonomyRilevanzaRequestBean();

    private List<ContentInterventoRequestBean> interventi = new ArrayList<>();

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

    public Boolean getDifferito() {
        return differito;
    }

    public void setDifferito(Boolean differito) {
        this.differito = differito;
    }

    public String getPosizione() {
        return posizione;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }

    public Boolean getRevocato() {
        return revocato;
    }

    public void setRevocato(Boolean revocato) {
        this.revocato = revocato;
    }

    public Date getFine() {
        return (Date)fine.clone();
    }

    public void setFine(Date fine) {
        this.fine = fine != null ? new Date(fine.getTime()): null;
    }

    public Date getInizio() {
        return (Date)inizio.clone();    }

    public void setInizio(Date inizio) {
        this.inizio = inizio != null ? new Date(inizio.getTime()): null;
    }

    @Override
    public String getFk() {
        return fk;
    }

    @Override
    public byte[] getBinaryFile() {
        return new byte[0];
    }

    public void setFk(String fk) {
        this.fk = fk;
    }

    public TaxonomyAziendaRequestBean getAzienda() {
        return azienda;
    }

    public void setAzienda(TaxonomyAziendaRequestBean azienda) {
        this.azienda = azienda;
    }

    public TaxonomySettoreRequestBean getSettore() {
        return settore;
    }

    public void setSettore(TaxonomySettoreRequestBean settore) {
        this.settore = settore;
    }

    public TaxonomyRilevanzaRequestBean getRilevanza() {
        return rilevanza;
    }

    public void setRilevanza(TaxonomyRilevanzaRequestBean rilevanza) {
        this.rilevanza = rilevanza;
    }


    public List<ContentInterventoRequestBean> getInterventi() {
        return interventi;
    }

    public void setInterventi(List<ContentInterventoRequestBean> interventi) {
        this.interventi = interventi;
    }

    @Override
    protected String attributeToJson() {
        StringBuilder sb = new StringBuilder();
        sb.append("\"title\":\"").append(getTitle()).append("\",");
        sb.append("\"field_controparte\":\"").append(getControparte()).append("\",");
        sb.append("\"field_differito\":").append(getDifferito()).append(",");
        sb.append("\"field_posizione\":\"").append(getPosizione()).append("\",");
        sb.append("\"field_revocato\":").append(getRevocato()).append(",");
        sb.append("\"field_fine\":\"").append(Tools.dateToDrupalStringDate(getFine())).append("\",");
        sb.append("\"field_inizio\":\"").append(Tools.dateToDrupalStringDate(getInizio())).append("\",");
        sb.append("\"field_fk\":\"").append(getFk()).append("\"");

        return sb.toString();
    }

    @Override
    protected String relationshipToJson() {
        StringBuilder sb = new StringBuilder();
        sb.append("\"field_interventi\": {\"data\" :[");
        for(int i =0; i < interventi.size(); i++){
            ContentInterventoRequestBean intervento = interventi.get(i);
            sb.append(intervento.toJsonBodyRelationship());
            if(!(i == interventi.size()-1)){
                sb.append(",");
            }
        }
        sb.append("]}");
        sb.append(",\"field_azienda\":").append(azienda.toJsonBodyInject());
        sb.append(",\"field_settore\":").append(settore.toJsonBodyInject());
        sb.append(",\"field_rilevanza\":").append(rilevanza.toJsonBodyInject());
        return sb.toString();
    }

   // @Override
    protected String taxonomyToJson() {
        StringBuilder sb = new StringBuilder();
        sb.append("\"field_azienda\":").append(azienda.toJsonBodyInject()).append(",");
        sb.append("\"field_settore\":").append(settore.toJsonBodyInject()).append(",");
        sb.append("\"field_rilevanza\":").append(rilevanza.toJsonBodyInject()).append("");

        return sb.toString();
    }

    @Override
    protected String getTipo() {
        return CONTENT_SCIOPERO;
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
        return "ContentScioperoRequestBean{" +
                "title='" + title + '\'' +
                ", controparte='" + controparte + '\'' +
                ", posizione='" + posizione + '\'' +
                ", fine='" + fine + '\'' +
                ", inizio='" + inizio + '\'' +
                ", uuid='" + uuid + '\'' +
                ", revocato=" + revocato +
                ", differito=" + differito +
                ", fk='" + fk + '\'' +
                ", azienda=" + azienda +
                '}';
    }
}
