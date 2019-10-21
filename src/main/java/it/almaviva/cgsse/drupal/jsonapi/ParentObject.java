package it.almaviva.cgsse.drupal.jsonapi;

import java.util.List;

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
        return "ParentObject{" +
                "data=" + data +
                ", links=" + links +
                '}';
    }
}
