package it.almaviva.cgsse.drupal.jsonapi;

/**
 * Classe per conversione jsonapi to object, della struttura Attributes
 */
public class AttributesObject {

    private String drupal_internal__tid;
    private String drupal_internal__revision_id;
    private String  langcode;
    private String  revision_created;
    private String  revision_log_message;
    private Boolean status;
    private String description;
    private Integer weight;
    private String changed;
    private Boolean default_langcode;
    private Boolean revision_translation_affected;
    private PathObject path;


    public String getDrupal_internal__tid() {
        return drupal_internal__tid;
    }

    public void setDrupal_internal__tid(String drupal_internal__tid) {
        this.drupal_internal__tid = drupal_internal__tid;
    }

    public String getDrupal_internal__revision_id() {
        return drupal_internal__revision_id;
    }

    public void setDrupal_internal__revision_id(String drupal_internal__revision_id) {
        this.drupal_internal__revision_id = drupal_internal__revision_id;
    }

    public String getLangcode() {
        return langcode;
    }

    public void setLangcode(String langcode) {
        this.langcode = langcode;
    }

    public String getRevision_created() {
        return revision_created;
    }

    public void setRevision_created(String revision_created) {
        this.revision_created = revision_created;
    }

    public String getRevision_log_message() {
        return revision_log_message;
    }

    public void setRevision_log_message(String revision_log_message) {
        this.revision_log_message = revision_log_message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getChanged() {
        return changed;
    }

    public void setChanged(String changed) {
        this.changed = changed;
    }

    public Boolean getDefault_langcode() {
        return default_langcode;
    }

    public void setDefault_langcode(Boolean default_langcode) {
        this.default_langcode = default_langcode;
    }

    public Boolean getRevision_translation_affected() {
        return revision_translation_affected;
    }

    public void setRevision_translation_affected(Boolean revision_translation_affected) {
        this.revision_translation_affected = revision_translation_affected;
    }

    public PathObject getPath() {
        return path;
    }

    public void setPath(PathObject path) {
        this.path = path;
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(AttributesObject.class.getName())
                .append("{")
                .append("drupal_internal__tid='").append(  drupal_internal__tid ).append( '\'' )
                .append(", drupal_internal__revision_id='").append(  drupal_internal__revision_id ).append( '\'' )
                .append(", langcode='").append(  langcode ).append('\'' )
                .append(", revision_created='").append(  revision_created ).append( '\'' )
                .append(", revision_log_message='").append(  revision_log_message ).append( '\'' )
                .append(", status=").append( status )
                .append(", description='").append(  description ).append('\'' )
                .append(", weight=").append( weight )
                .append(", changed='").append( changed ).append( '\'' )
                .append(", default_langcode=").append( default_langcode )
                .append(", revision_translation_affected=").append(  revision_translation_affected )
                .append(", path=").append( path )
                .append('}');
        return s.toString();
    }
}
