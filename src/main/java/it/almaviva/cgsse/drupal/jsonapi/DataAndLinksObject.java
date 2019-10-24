package it.almaviva.cgsse.drupal.jsonapi;

/**
 * Classe per conversione jsonapi to object, della struttura DataAndLinksObject
 */
public class DataAndLinksObject {

    private DataObject data;
    private LinksObject links;

    public DataObject getData() {
        return data;
    }

    public void setData(DataObject data) {
        this.data = data;
    }

    public LinksObject getLinks() {
        return links;
    }

    public void setLinks(LinksObject links) {
        this.links = links;
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(DataAndLinksObject.class.getName())
                .append("{" )
                .append("data=" ).append(data )
                .append(", links=" ).append(links )
                .append('}');
        return s.toString();
    }
}
