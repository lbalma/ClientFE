package it.almaviva.cgsse.drupal.jsonapi;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class ReletedObjectTest {
    @Test
    public void jsonToObject(){
        //INPUT
        String href = "http://jsonapi.org/format/1.0/";

        String jsonString = "{"
                    +"\"href\": \""+href+"\""
         +"}";

        //CAST
        Gson g = new Gson();
        ReletedObject obj = g.fromJson(jsonString,ReletedObject.class);

        //PRINT
        System.out.println(jsonString);
        System.out.println(obj.toString());

        //ASSERTS
        Assert.assertTrue(href.equals(obj.getHref()));

    }
}
