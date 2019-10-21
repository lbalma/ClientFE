package it.almaviva.cgsse.drupal.jsonapi;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class DataObjectTest {
    @Test
    public void jsonToObject(){
        //INPUT
        String id_value = "virtual";
        String type_value = "taxonomy_term--azienda";
        String help_href_value = "http://jsonapi.org/format/1.0/";
        String help_meta_about_value = "Usage and meaning of the 'virtual' resource identifier.";

        String jsonString = "{"
             +"\"id\": \""+id_value+"\","
             +"\"type\": \""+type_value+"\","
             +"\"meta\": {"
                +"\"links\": {"
                    +"\"help\": {"
                        +"\"href\":  \""+help_href_value+"\","
                        +"\"meta\": {"
                             +"\"about\":\""+help_meta_about_value+"\""
                        +"}"
                    +"}"
                 +"}"
             +"}"
         +"}";

        //CAST
        Gson g = new Gson();
        DataObject obj = g.fromJson(jsonString,DataObject.class);

        //PRINT
        System.out.println(jsonString);
        System.out.println(obj.toString());

        //ASSERTS
        Assert.assertTrue(id_value.equals(obj.getId()));
        Assert.assertTrue(type_value.equals(obj.getType()));
        Assert.assertTrue(help_href_value.equals(obj.getMeta().getLinks().getHelp().getHref()));
        Assert.assertTrue(help_meta_about_value.equals(obj.getMeta().getLinks().getHelp().getMeta().getAbout()));


    }
}
