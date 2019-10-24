package it.almaviva.cgsse.drupal.jsonapi;

/**
 * Classe per conversione jsonapi to object, della struttura RelationshipsObjcet
 */
public class RelationshipsObjcet {

    private DataAndLinksObject vid;
    private DataAndLinksObject revision_user;
    private ParentObject parent;

    public DataAndLinksObject getVid() {
        return vid;
    }

    public void setVid(DataAndLinksObject vid) {
        this.vid = vid;
    }

    public DataAndLinksObject getRevision_user() {
        return revision_user;
    }

    public void setRevision_user(DataAndLinksObject revision_user) {
        this.revision_user = revision_user;
    }

    public ParentObject getParent() {
        return parent;
    }

    public void setParent(ParentObject parent) {
        this.parent = parent;
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(RelationshipsObjcet.class.getName())
                .append("{" )
                .append("vid=" ).append( vid )
                .append(", revision_user=") .append( revision_user )
                .append(", parent=") .append( parent )
                .append('}');
        return s.toString();
    }
}
