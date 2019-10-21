package it.almaviva.cgsse.drupal.jsonapi;

import java.util.List;

public class ResponseObjectList<R extends  AttributesObject> {

    private JsonapiObject jsonapi;
    private List<DataObject<R>> data;
    private LinksObject links;

    public JsonapiObject getJsonapi() {
        return jsonapi;
    }

    public void setJsonapi(JsonapiObject jsonapi) {
        this.jsonapi = jsonapi;
    }

    public List<DataObject<R>> getData() {
        return data;
    }

    public void setData(List<DataObject<R>> data) {
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
        return "ResponseObjectList{" +
                "jsonapi=" + jsonapi +
                ", data=" + data +
                ", links=" + links +
                '}';
    }
}
