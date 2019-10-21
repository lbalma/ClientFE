package it.almaviva.cgsse.drupal.jsonapi;

public class ReletedObject {

    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }


    @Override
    public String toString() {
        return "ReletedObject{" +
                "href='" + href + '\'' +
                '}';
    }
}
