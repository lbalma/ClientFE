package it.almaviva.cgsse.drupal.jsonapi;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class ParentObjectTest {
    @Test
    public void jsonToObject(){
        //INPUT
        String id = "virtual";
        String type = "taxonomy_term--azienda";
        String meta_links_help_href = "http://jsonapi.org/format/1.0/";
        String meta_links_help_meta_about = "http://jsonapi.org/format/1.0/";

        String jsonString = "{"
            +"\"data\": [{"
                 +"\"id\": \""+id+"\","
                 +"\"type\": \""+type+"\","
                 +"\"meta\": {"
                    +"\"links\": {"
                        +"\"help\": {"
                            +"\"href\": \""+meta_links_help_href+"\","
                            +"\"meta\": {"
                                 +"\"about\":\""+meta_links_help_meta_about+"\""
                            +"}"
                        +"}"
                     +"}"
                 +"}"
             +"}]"
         +"}";

        //CAST
        Gson g = new Gson();
        ParentObject obj = g.fromJson(jsonString,ParentObject.class);

        //PRINT
        System.out.println(jsonString);
        System.out.println(obj.toString());

        //ASSERTS
        Assert.assertTrue(id.equals(obj.getData().get(0).getId()));
        Assert.assertTrue(type.equals(obj.getData().get(0).getType()));
        Assert.assertTrue(meta_links_help_href.equals(obj.getData().get(0).getMeta().getLinks().getHelp().getHref()));
        Assert.assertTrue(meta_links_help_meta_about.equals(obj.getData().get(0).getMeta().getLinks().getHelp().getMeta().getAbout()));

    }
}
