package it.almaviva.cgsse.drupal.jsonapi;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class RevisionUserObjectTest {
    @Test
    public void jsonToObject(){
        //INPUT
        String data = null;
        String links_self_href = "http://jsonapi.org/format/1.0/";
        String links_related_href = "http://jsonapi.org/format/1.0/";

        String jsonString = "{\n" +
                "                \"data\": "+data+",\n" +
                "                \"links\": {\n" +
                "                    \"self\": {\n" +
                "                        \"href\": \""+links_self_href+"\"\n" +
                "                    },\n" +
                "                    \"related\": {\n" +
                "                        \"href\": \""+links_related_href+"\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }";

        //CAST
        Gson g = new Gson();
        RevisionUserObject obj = g.fromJson(jsonString,RevisionUserObject.class);

        //PRINT
        System.out.println(jsonString);
        System.out.println(obj.toString());

        //ASSERTS
        Assert.assertTrue(obj.getData() == null);
        Assert.assertTrue(links_self_href.equals(obj.getLinks().getSelf().getHref()));
        Assert.assertTrue(links_related_href.equals(obj.getLinks().getRelated().getHref()));

    }
}
