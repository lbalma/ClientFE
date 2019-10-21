package it.almaviva.cgsse.drupal.jsonapi;

/**
 * Classe per conversione jsonapi to object, della struttura DataObject, gestione con Genercis per scalabilità su più taxonomy
 */
public class DataObject <R extends AttributesObject>{

    private String type;
    private String id;
    private RelationshipsObjcet relationships;
    private R attributes;
    private LinksObject links;
    private MetaObject meta;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RelationshipsObjcet getRelationships() {
        return relationships;
    }

    public void setRelationships(RelationshipsObjcet relationships) {
        this.relationships = relationships;
    }

    public LinksObject getLinks() {
        return links;
    }

    public void setLinks(LinksObject links) {
        this.links = links;
    }

    public MetaObject getMeta() {
        return meta;
    }

    public void setMeta(MetaObject meta) {
        this.meta = meta;
    }


    public R getAttributes() {
        return attributes;
    }

    public void setAttributes(R attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(DataObject.class.getName())
                .append("{" )
                .append("type='" ).append( type ).append( '\'' )
                .append(", id='" ).append( id ).append( '\'' )
                .append(", relationships=" ).append( relationships )
                .append(", attributes=" ).append( attributes )
                .append(", links=" ).append( links )
                .append(", meta=" ).append( meta )
                .append('}');
        return s.toString();
    }

}
