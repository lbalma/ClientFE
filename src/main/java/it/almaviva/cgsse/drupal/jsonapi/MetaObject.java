package it.almaviva.cgsse.drupal.jsonapi;

public class MetaObject {

    private String about;
    private LinksObject links;

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public LinksObject getLinks() {
        return links;
    }

    public void setLinks(LinksObject links) {
        this.links = links;
    }


    @Override
    public String toString() {
        return "MetaObject{" +
                "about='" + about + '\'' +
                ", links=" + links +
                '}';
    }
}
