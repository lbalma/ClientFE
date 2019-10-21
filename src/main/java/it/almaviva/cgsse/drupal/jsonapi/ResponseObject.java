package it.almaviva.cgsse.drupal.jsonapi;

public class ResponseObject<R extends  AttributesObject> {

    private JsonapiObject jsonapi;
    private DataObject<R> data;
    private LinksObject links;

    public JsonapiObject getJsonapi() {
        return jsonapi;
    }

    public void setJsonapi(JsonapiObject jsonapi) {
        this.jsonapi = jsonapi;
    }

    public DataObject getdata() {
        return data;
    }

    public void setdata(DataObject data) {
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
        return "ResponseObject{" +
                "jsonapi=" + jsonapi +
                ", data=" + data +
                ", links=" + links +
                '}';
    }
}
