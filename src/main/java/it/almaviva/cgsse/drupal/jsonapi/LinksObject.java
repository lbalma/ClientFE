package it.almaviva.cgsse.drupal.jsonapi;

public class LinksObject {

    private SelfObject self;
    private ReletedObject related;
    private HelpObject help;

    public SelfObject getSelf() {
        return self;
    }

    public ReletedObject getRelated() {
        return related;
    }

    public void setRelated(ReletedObject related) {
        this.related = related;
    }

    public HelpObject getHelp() {
        return help;
    }

    public void setHelp(HelpObject help) {
        this.help = help;
    }

    public void setSelf(SelfObject self) {
        this.self = self;
    }


    @Override
    public String toString() {
        return "LinksObject{" +
                "self=" + self +
                ", related=" + related +
                ", help=" + help +
                '}';
    }
}
