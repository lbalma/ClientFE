package it.almaviva.cgsse.bo.bean;

public class TaxonomyAziendaBOBean extends BOBean{

    private String name;
    private String uuid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "TaxonomyAziendaBOBean{" +
                "name='" + name + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
