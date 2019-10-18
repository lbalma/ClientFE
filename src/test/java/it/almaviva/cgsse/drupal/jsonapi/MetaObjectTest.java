package it.almaviva.cgsse.drupal.jsonapi;

import com.google.gson.Gson;
import org.junit.Test;

public class MetaObjectTest {
    @Test
    public void jsonToObject(){
        String jsonString = "{"

            +"\"links\": {"
                +"\"self\": {"
                    +"\"href\": \"http://jsonapi.org/format/1.0/\""
                    +"}"
                +"}"
         +"}";

        Gson g = new Gson();
        MetaObject obj = g.fromJson(jsonString,MetaObject.class);
        System.out.println("Links:Self:Href: "+obj.getLinks().getSelf().getHref());

    }
}
