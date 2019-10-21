package it.almaviva.cgsse.drupal.jsonapi;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class RelationshipsObjectTest {
    @Test
    public void jsonToObject(){
        //INPUT
        String vid_data_id = "924a6a75-632b-477d-a9a7-506001596e7b";
        String vid_data_type = "taxonomy_vocabulary--taxonomy_vocabulary";
        String vid_data_links_self_href = "http://localhost/protocgsse/jsonapi/taxonomy_term/azienda/17669f7c-1283-43c0-aa0d-e89d96d116ae/relationships/vid";
        String vid_data_links_related_href = "http://localhost/protocgsse/jsonapi/taxonomy_term/azienda/17669f7c-1283-43c0-aa0d-e89d96d116ae/vid";
        String revision_user_data = null;
        String revision_user_lins_self_href = "http://localhost/protocgsse/jsonapi/taxonomy_term/azienda/17669f7c-1283-43c0-aa0d-e89d96d116ae/relationships/revision_user";
        String revision_user_lins_releted_href = "http://localhost/protocgsse/jsonapi/taxonomy_term/azienda/17669f7c-1283-43c0-aa0d-e89d96d116ae/revision_user";
        String parent_data_type = "taxonomy_term--azienda";
        String parent_data_id = "virtual";
        String parent_data_meta_links_help_href = "https://www.drupal.org/docs/8/modules/json-api/core-concepts#virtual";
        String parent_data_meta_links_help_meta_about = "Usage and meaning of the 'virtual' resource identifier.";
        String parent_links_self_href = "http://localhost/protocgsse/jsonapi/taxonomy_term/azienda/17669f7c-1283-43c0-aa0d-e89d96d116ae/relationships/parent";
        String parent_links_releted_href = "http://localhost/protocgsse/jsonapi/taxonomy_term/azienda/17669f7c-1283-43c0-aa0d-e89d96d116ae/parent";

        String jsonString = "{\n" +
                "            \"vid\": {\n" +
                "                \"data\": {\n" +
                "                    \"type\": \""+vid_data_type+"\",\n" +
                "                    \"id\": \""+vid_data_id+"\"\n" +
                "                },\n" +
                "                \"links\": {\n" +
                "                    \"self\": {\n" +
                "                        \"href\": \""+vid_data_links_self_href+"\"\n" +
                "                    },\n" +
                "                    \"related\": {\n" +
                "                        \"href\": \""+vid_data_links_related_href+"\"\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"revision_user\": {\n" +
                "                \"data\": "+revision_user_data+",\n" +
                "                \"links\": {\n" +
                "                    \"self\": {\n" +
                "                        \"href\": \""+revision_user_lins_self_href+"\"\n" +
                "                    },\n" +
                "                    \"related\": {\n" +
                "                        \"href\": \""+revision_user_lins_releted_href+"\"\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"parent\": {\n" +
                "                \"data\": [\n" +
                "                    {\n" +
                "                        \"type\": \""+parent_data_type+"\",\n" +
                "                        \"id\": \""+parent_data_id+"\",\n" +
                "                        \"meta\": {\n" +
                "                            \"links\": {\n" +
                "                                \"help\": {\n" +
                "                                    \"href\": \""+parent_data_meta_links_help_href+"\",\n" +
                "                                    \"meta\": {\n" +
                "                                        \"about\": \""+parent_data_meta_links_help_meta_about+"\"\n" +
                "                                    }\n" +
                "                                }\n" +
                "                            }\n" +
                "                        }\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"links\": {\n" +
                "                    \"self\": {\n" +
                "                        \"href\": \""+parent_links_self_href+"\"\n" +
                "                    },\n" +
                "                    \"related\": {\n" +
                "                        \"href\": \""+parent_links_releted_href+"\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        }";

        //CAST
        Gson g = new Gson();
        RelationshipsObjcet obj = g.fromJson(jsonString,RelationshipsObjcet.class);

        //PRINT
        System.out.println(jsonString);
        System.out.println(obj.toString());

        //ASSERTS
        Assert.assertTrue(vid_data_id.equals(obj.getVid().getData().getId()));
        Assert.assertTrue(vid_data_type.equals(obj.getVid().getData().getType()));
        Assert.assertTrue(vid_data_links_self_href.equals(obj.getVid().getLinks().getSelf().getHref()));
        Assert.assertTrue(vid_data_links_related_href.equals(obj.getVid().getLinks().getRelated().getHref()));
        Assert.assertTrue(obj.getRevision_user().getData() == null);
        Assert.assertTrue(revision_user_lins_self_href.equals(obj.getRevision_user().getLinks().getSelf().getHref()));
        Assert.assertTrue(revision_user_lins_releted_href.equals(obj.getRevision_user().getLinks().getRelated().getHref()));
        Assert.assertTrue(parent_data_type.equals(obj.getParent().getData().get(0).getType()));
        Assert.assertTrue(parent_data_id.equals(obj.getParent().getData().get(0).getId()));
        Assert.assertTrue(parent_data_meta_links_help_href.equals(obj.getParent().getData().get(0).getMeta().getLinks().getHelp().getHref()));
        Assert.assertTrue(parent_data_meta_links_help_meta_about.equals(obj.getParent().getData().get(0).getMeta().getLinks().getHelp().getMeta().getAbout()));
        Assert.assertTrue(parent_links_self_href.equals(obj.getParent().getLinks().getSelf().getHref()));
        Assert.assertTrue(parent_links_releted_href.equals(obj.getParent().getLinks().getRelated().getHref()));

    }
}
