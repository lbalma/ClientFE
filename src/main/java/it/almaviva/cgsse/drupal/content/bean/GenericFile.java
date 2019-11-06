package it.almaviva.cgsse.drupal.content.bean;

import static it.almaviva.cgsse.drupal.content.utils.Costants.CONTENT_FILE;

public class GenericFile extends AFile {

    private String uuid;
    private byte[] file;
    private String name;
    private String description;

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    protected String getTipo() {
        return CONTENT_FILE;
    }

    @Override
    public String getUuid() {
        return uuid;
    }

    public byte[] getFile() {
        return file!= null ? file.clone(): null;
    }

    public void setFile(byte[] file) {
        this.file = file!= null ? file.clone(): null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
