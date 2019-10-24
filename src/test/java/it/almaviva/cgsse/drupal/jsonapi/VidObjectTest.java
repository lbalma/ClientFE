package it.almaviva.cgsse.drupal.jsonapi;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class VidObjectTest {
    @Test
    public void jsonToObject(){
        //INPUT
        String type = "taxonomy_vocabulary--taxonomy_vocabulary";
        String id = "924a6a75-632b-477d-a9a7-506001596e7b";
        String links_self_href = "http://localhost/protocgsse/jsonapi/taxonomy_term/azienda/17669f7c-1283-43c0-aa0d-e89d96d116ae/relationships/vid";
        String links_releted_href = "http://localhost/protocgsse/jsonapi/taxonomy_term/azienda/17669f7c-1283-43c0-aa0d-e89d96d116ae/vid";


        String jsonString = "{\n" +
                "                \"data\": {\n" +
                "                    \"type\": \""+type+"\",\n" +
                "                    \"id\": \""+id+"\"\n" +
                "                },\n" +
                "                \"links\": {\n" +
                "                    \"self\": {\n" +
                "                        \"href\": \""+links_self_href+"\"\n" +
                "                    },\n" +
                "                    \"related\": {\n" +
                "                        \"href\": \""+links_releted_href+"\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }";
        Gson g = new Gson();
        DataAndLinksObject obj = g.fromJson(jsonString,DataAndLinksObject.class);

        //PRINT
        System.out.println(jsonString);
        System.out.println(obj.toString());

        //ASSERTS
        Assert.assertTrue(type.equals(obj.getData().getType()));
        Assert.assertTrue(id.equals(obj.getData().getId()));
        Assert.assertTrue(links_self_href.equals(obj.getLinks().getSelf().getHref()));
        Assert.assertTrue(links_releted_href.equals(obj.getLinks().getRelated().getHref()));



    }
}
