package it.almaviva.cgsse.drupal.jsonapi;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class SelfObjectTest {
    @Test
    public void jsonToObject(){
        //INPUT
        String href = "http://jsonapi.org/format/1.0/";

        String jsonString = "{"
                    +"\"href\": \""+href+"\""
         +"}";

        Gson g = new Gson();
        SelfObject obj = g.fromJson(jsonString,SelfObject.class);

        //PRINT
        System.out.println(jsonString);
        System.out.println(obj.toString());

        //ASSERTS
        Assert.assertTrue(href.equals(obj.getHref()));


    }
}
