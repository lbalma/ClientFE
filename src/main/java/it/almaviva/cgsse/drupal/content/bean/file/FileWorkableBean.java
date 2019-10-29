package it.almaviva.cgsse.drupal.content.bean.file;

public class FileWorkableBean {

     private String uuid;
    private String description;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "FileWorkableBean{" +
                "uuid='" + uuid + '\'' +
                "description='" + description + '\'' +
                '}';
    }
}

