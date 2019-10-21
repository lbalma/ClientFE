package it.almaviva.cgsse.drupal.jsonapi;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class HelpObjectTest {
    @Test
    public void jsonToObject(){
        //INPUT
        String help_href_value = "http://jsonapi.org/format/1.0/";
        String help_meta_about_value = "Usage and meaning of the 'virtual' resource identifier.";

        String jsonString = "{"
                    +"\"href\":  \""+help_href_value+"\","
                    +"\"meta\": {"
                        +"\"about\":\""+help_meta_about_value+"\""
                    +"}"
                +"}";

        //CAST
        Gson g = new Gson();
        HelpObject obj = g.fromJson(jsonString,HelpObject.class);

        //PRINT
        System.out.println(jsonString);
        System.out.println(obj.toString());

        //ASSERTS
        Assert.assertTrue(help_href_value.equals(obj.getHref()));
        Assert.assertTrue(help_meta_about_value.equals(obj.getMeta().getAbout()));
    }
}
