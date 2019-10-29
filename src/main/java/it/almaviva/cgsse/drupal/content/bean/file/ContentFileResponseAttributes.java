package it.almaviva.cgsse.drupal.content.bean.file;

import it.almaviva.cgsse.drupal.jsonapi.AttributesObject;
import it.almaviva.cgsse.drupal.jsonapi.UriObject;

/**
 * Classe contenente gli attributi specifici per la tassonomia Azienda.
 * Questa classe è usata per castare l'attributo 'attributes' del jsonapi di risposta tornato dai servizzi esposti del FE
 */
public class ContentFileResponseAttributes extends AttributesObject {

    private String filemime;
    private String filesize;
    private String filename;
    private String created;
    private UriObject uri;

    public String getFilemime() {
        return filemime;
    }

    public void setFilemime(String filemime) {
        this.filemime = filemime;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public UriObject getUri() {
        return uri;
    }

    public void setUri(UriObject uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "ContentFileResponseAttributes{" +
                "filemime='" + filemime + '\'' +
                ", filesize='" + filesize + '\'' +
                ", filename='" + filename + '\'' +
                ", created='" + created + '\'' +
                ", uri=" + uri +
                '}';
    }
}
