package it.almaviva.cgsse.drupal.jsonapi;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class JsonapiObjectTest {
    @Test
    public void jsonToObject(){
        //INPUT
        String version="1.0";
        String meta_links_self_href = "http://jsonapi.org/format/1.0/";

        String jsonString = "{"
                +"\"version\": \""+version+"\","
                +"\"meta\": {"
                    +"\"links\": {"
                        +"\"self\": {"
                            +"\"href\": \""+meta_links_self_href+"\""
                        +"}"
                    +"}"
                +"}"
         +"}";

        //CAST
        Gson g = new Gson();
        JsonapiObject obj = g.fromJson(jsonString,JsonapiObject.class);

        //PRINT
        System.out.println(jsonString);
        System.out.println(obj.toString());

        //ASSERTS
        Assert.assertTrue(version.equals(obj.getVersion()));
        Assert.assertTrue(meta_links_self_href.equals(obj.getMeta().getLinks().getSelf().getHref()));

    }
}
