package it.almaviva.cgsse.drupal.content.bean;

import java.io.File;

import static it.almaviva.cgsse.drupal.content.Costants.CONTENT_FILE;

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
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
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
