package it.almaviva.cgsse.drupal.jsonapi;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class MetaObjectTest {
    @Test
    public void jsonToObject(){
        //INPUT
        String links_self_href = "http://jsonapi.org/format/1.0/";

        String jsonString = "{"
            +"\"links\": {"
                +"\"self\": {"
                    +"\"href\": \""+links_self_href+"\""
                +"}"
             +"}"
         +"}";

        //CAST
        Gson g = new Gson();
        MetaObject obj = g.fromJson(jsonString,MetaObject.class);


        //PRINT
        System.out.println(jsonString);
        System.out.println(obj.toString());

        //ASSERTS
        Assert.assertTrue(links_self_href.equals(obj.getLinks().getSelf().getHref()));
    }

    @Test
    public void jsonToObject2(){
        //INPUT
        String links_self_href = "http://jsonapi.org/format/1.0/";
        String about_value = "Usage and meaning of the 'virtual' resource identifier.";

        String jsonString = "{"
                +"\"about\":\""+about_value+"\","
                +"\"links\": {"
                        +"\"self\": {"
                            +"\"href\": \""+links_self_href+"\""
                        +"}"
                    +"}"
                +"}";

        //CAST
        Gson g = new Gson();
        MetaObject obj = g.fromJson(jsonString,MetaObject.class);


        //PRINT
        System.out.println(jsonString);
        System.out.println(obj.toString());

        //ASSERTS
        Assert.assertTrue(links_self_href.equals(obj.getLinks().getSelf().getHref()));
        Assert.assertTrue(about_value.equals(obj.getAbout()));

    }
}
