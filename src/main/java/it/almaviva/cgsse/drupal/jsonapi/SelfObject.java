package it.almaviva.cgsse.drupal.jsonapi;

public class SelfObject {

    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }


    @Override
    public String toString() {
        return "SelfObject{" +
                "href='" + href + '\'' +
                '}';
    }
}
