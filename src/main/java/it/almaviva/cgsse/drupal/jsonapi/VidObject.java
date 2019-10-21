package it.almaviva.cgsse.drupal.jsonapi;

public class VidObject {

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
        return "VidObject{" +
                "data=" + data +
                ", links=" + links +
                '}';
    }
}
