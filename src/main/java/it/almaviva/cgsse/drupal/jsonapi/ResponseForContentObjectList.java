package it.almaviva.cgsse.drupal.jsonapi;

import java.util.List;

/**
 * Classe per conversione jsonapi to object, della struttura ResponseObject, gestione con generics per scalabilità su content
 */
public class ResponseForContentObjectList<R extends  AttributesObject, S extends RelationshipsForContentObjcet> {

    private JsonapiObject jsonapi;
    private List<DataForContentObject<R, S>> data;
    private LinksObject links;

    public JsonapiObject getJsonapi() {
        return jsonapi;
    }

    public void setJsonapi(JsonapiObject jsonapi) {
        this.jsonapi = jsonapi;
    }

    public List<DataForContentObject<R, S>> getData() {
        return data;
    }

    public void setData(List<DataForContentObject<R, S>> data) {
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
        StringBuilder s = new StringBuilder(ResponseForContentObjectList.class.getName())
                .append("{" )
                .append("jsonapi="  ).append(jsonapi )
                .append(", data="  ).append(data )
                .append(", links="  ).append(links )
                .append('}');
        return s.toString();
    }
}
