package it.almaviva.cgsse.drupal.jsonapi;

import java.util.List;

/**
 * Classe per conversione jsonapi to object, della struttura ParentObject
 */
public class ParentObject {

    private List<DataObject> data;
    private LinksObject links;

    public LinksObject getLinks() {
        return links;
    }

    public void setLinks(LinksObject links) {
        this.links = links;
    }

    public List<DataObject> getData() {
        return data;
    }

    public void setData(List<DataObject> data) {
        this.data = data;
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(ParentObject.class.getName())
             .append("{" )
                .append("data=" ).append(data )
                .append(", links=" ).append(links )
                .append('}');
        return s.toString();
    }
}
