package it.almaviva.cgsse.drupal.jsonapi;

/**
 * Classe per conversione jsonapi to object, della struttura ResponseObject, gestione con generics per scalabilità su taxonomy
 */
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
        StringBuilder s = new StringBuilder(ResponseObject.class.getName())
                .append("{" )
                .append("jsonapi="  ).append(jsonapi )
                .append(", data="  ).append(data )
                .append(", links="  ).append(links )
                .append('}');
        return s.toString();
    }
}
