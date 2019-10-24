package it.almaviva.cgsse.drupal.jsonapi;

/**
 * Classe per conversione jsonapi to object, della struttura RelationshipsObjcet
 */
public class RelationshipsForContentObjcet {

    private DataObject node_type;
    private DataObject revision_uid;
    private DataObject uid;

    public DataObject getNode_type() {
        return node_type;
    }

    public void setNode_type(DataObject node_type) {
        this.node_type = node_type;
    }

    public DataObject getRevision_uid() {
        return revision_uid;
    }

    public void setRevision_uid(DataObject revision_uid) {
        this.revision_uid = revision_uid;
    }

    public DataObject getUid() {
        return uid;
    }

    public void setUid(DataObject uid) {
        this.uid = uid;
    }

    //TODO
    @Override
    public String toString() {
        return "RelationshipsForContentObjcet{" +
                "node_type=" + node_type +
                ", revision_uid=" + revision_uid +
                ", uid=" + uid +
                '}';
    }
}
