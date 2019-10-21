package it.almaviva.cgsse.drupal.jsonapi;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class LinksObjectTest {

    @Test
    public void jsonToObject(){
        //INPUT
        String self_href = "http://jsonapi.org/format/1.0/";

        String jsonString = "{"
                +"\"self\": {"
                    +"\"href\": \""+self_href+"\""
                +"}"
         +"}";

        //CAST
        Gson g = new Gson();
        LinksObject obj = g.fromJson(jsonString,LinksObject.class);

        //PRINT
        System.out.println(jsonString);
        System.out.println(obj.toString());

        //ASSERTS
        Assert.assertTrue(self_href.equals(obj.getSelf().getHref()));
    }


    @Test
    public void jsonToObject2(){
        //INPUT
        String self_href = "http://jsonapi.org/format/1.0/";
        String related_href = "http://jsonapi.org/format/1.0/";

        String jsonString = "{"
                +"\"self\": {"
                    +"\"href\": \""+self_href+"\""
                +"},"
                +"\"related\": {"
                    +"\"href\": \""+self_href+"\""
                +"}"
           +"}";

        //CAST
        Gson g = new Gson();
        LinksObject obj = g.fromJson(jsonString,LinksObject.class);

        //PRINT
        System.out.println(jsonString);
        System.out.println(obj.toString());

        //ASSERTS
        Assert.assertTrue(self_href.equals(obj.getSelf().getHref()));
        Assert.assertTrue(related_href.equals(obj.getRelated().getHref()));


    }
}
