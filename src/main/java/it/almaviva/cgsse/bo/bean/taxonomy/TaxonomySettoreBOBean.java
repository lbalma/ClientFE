package it.almaviva.cgsse.bo.bean.taxonomy;

import it.almaviva.cgsse.bo.bean.BOBean;

    public class TaxonomySettoreBOBean extends BOBean {

    private String name;
    private String fk;
    private String uuid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFk() {
        return fk;
    }

    public void setFk(String fk) {
        this.fk = fk;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    //TODO
    @Override
    public String toString() {
        return "TaxonomySettoreBOBean{" +
                "name='" + name + '\'' +
                ", fk='" + fk + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
