package it.almaviva.cgsse.bo.bean.content;

import it.almaviva.cgsse.bo.bean.BOBean;


public class ContentInterventoBOBean extends BOBean {

    private String intervento;
    private String posizione;
    private String dataIntervento;
    private String desctizione;

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
}
