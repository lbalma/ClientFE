package it.almaviva.cgsse.drupal.jsonapi;

public class RelationshipsObjcet {

    private VidObject vid;
    private RevisionUserObject revision_user;
    private ParentObject parent;

    public VidObject getVid() {
        return vid;
    }

    public void setVid(VidObject vid) {
        this.vid = vid;
    }

    public RevisionUserObject getRevision_user() {
        return revision_user;
    }

    public void setRevision_user(RevisionUserObject revision_user) {
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
        return "RelationshipsObjcet{" +
                "vid=" + vid +
                ", revision_user=" + revision_user +
                ", parent=" + parent +
                '}';
    }
}
