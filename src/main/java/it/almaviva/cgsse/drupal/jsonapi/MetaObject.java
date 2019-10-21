package it.almaviva.cgsse.drupal.jsonapi;

/**
 * Classe per conversione jsonapi to object, della struttura MetaObject
 */
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
        StringBuilder s = new StringBuilder(MetaObject.class.getName())
            .append("{" )
                .append("about='" ).append(about ).append('\'' )
                .append(", links=" ).append(links )
                .append('}');
        return s.toString();
    }
}
