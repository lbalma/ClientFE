package it.almaviva.cgsse.drupal.jsonapi;

import com.google.gson.Gson;
import it.almaviva.cgsse.drupal.taxonomy.bean.TaxonomyAziendaResponseAttributes;
import it.almaviva.cgsse.drupal.taxonomy.bean.TaxonomyAziendaResponseBean;
import org.junit.Assert;
import org.junit.Test;


public class TaxonomyAziendaResponseBeanTest {

    @Test
    public void jsonToObject(){
        String jsonapi_version = "1.0";
        String jsonapi_meta_links_self_href = "http://jsonapi.org/format/1.0/";
        String data_type = "taxonomy_term--azienda";
        String data_id = "17669f7c-1283-43c0-aa0d-e89d96d116ae";
        String data_attributes_drupal_internal__tid= "1";
        String data_attributes_drupal_internal__revision_id = "1";
        String data_attributes_langcode = "it";
        String data_revision_created = "2019-10-17T07:55:20+00:00";
        String data_revision_log_message = null;
        Boolean data_staus = true;
        String data_name = "Azienda1";
        String data_description = null;
        Integer data_weight = 0;
        String data_changed = "2019-10-17T07:55:20+00:00";
        Boolean data_default_langcode = true;
        Boolean data_revision_translation_affected = true;
        String data_path_alias = null;
        String data_path_pid =null;
        String data_path_langcode = "it";
        String data_relationships_vid_data_type= "taxonomy_vocabulary--taxonomy_vocabulary";
        String data_relationships_vid_data_id = "924a6a75-632b-477d-a9a7-506001596e7b";
        String data_relationships_vid_links_self_href = "http://localhost/protocgsse/jsonapi/taxonomy_term/azienda/17669f7c-1283-43c0-aa0d-e89d96d116ae/relationships/vid";
        String data_relationships_vid_links_related_href = "http://localhost/protocgsse/jsonapi/taxonomy_term/azienda/17669f7c-1283-43c0-aa0d-e89d96d116ae/vid";
        String data_relationships_revision_user_inks_self_href = "http://localhost/protocgsse/jsonapi/taxonomy_term/azienda/17669f7c-1283-43c0-aa0d-e89d96d116ae/relationships/revision_user";
        String data_relationships_revision_user_inks_related_href = "http://localhost/protocgsse/jsonapi/taxonomy_term/azienda/17669f7c-1283-43c0-aa0d-e89d96d116ae/revision_user";
        String data_relationships_parent_data_type = "taxonomy_term--azienda";
        String data_relationships_parent_data_id = "virtual";
        String data_relationships_parent_data_meta_links_self_href = "https://www.drupal.org/docs/8/modules/json-api/core-concepts#virtual";
        String data_relationships_parent_data_meta_links_self_meta_about = "Usage and meaning of the 'virtual' resource identifier.";
        String data_relationships_parent_links_self_href = "http://localhost/protocgsse/jsonapi/taxonomy_term/azienda/17669f7c-1283-43c0-aa0d-e89d96d116ae/relationships/parent";
        String data_relationships_parent_links_related_href = "http://localhost/protocgsse/jsonapi/taxonomy_term/azienda/17669f7c-1283-43c0-aa0d-e89d96d116ae/parent";
        String data_links_self_href = "http://localhost/protocgsse/jsonapi/taxonomy_term/azienda/17669f7c-1283-43c0-aa0d-e89d96d116ae";
        String links_self_href = "http://localhost/protocgsse/jsonapi/taxonomy_term/azienda/17669f7c-1283-43c0-aa0d-e89d96d116ae";


        //INPUT
        String jsonString = "{\n" +
                "    \"jsonapi\": {\n" +
                "        \"version\": \""+jsonapi_version+"\",\n" +
                "        \"meta\": {\n" +
                "            \"links\": {\n" +
                "                \"self\": {\n" +
                "                    \"href\": \""+jsonapi_meta_links_self_href+"\"\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    },\n" +
                "    \"data\": {\n" +
                "        \"type\": \""+data_type+"\",\n" +
                "        \"id\": \""+data_id+"\",\n" +
                "        \"attributes\": {\n" +
                "            \"drupal_internal__tid\": "+data_attributes_drupal_internal__tid+",\n" +
                "            \"drupal_internal__revision_id\": "+data_attributes_drupal_internal__revision_id+",\n" +
                "            \"langcode\": \""+data_attributes_langcode+"\",\n" +
                "            \"revision_created\": \""+data_revision_created+"\",\n" +
                "            \"revision_log_message\": "+data_revision_log_message+",\n" +
                "            \"status\": "+data_staus+",\n" +
                "            \"name\": \""+data_name+"\",\n" +
                "            \"description\": "+data_description+",\n" +
                "            \"weight\": "+data_weight+",\n" +
                "            \"changed\": \""+data_changed+"\",\n" +
                "            \"default_langcode\": "+data_default_langcode+",\n" +
                "            \"revision_translation_affected\": "+data_revision_translation_affected+",\n" +
                "            \"path\": {\n" +
                "                \"alias\": "+data_path_alias+",\n" +
                "                \"pid\": "+data_path_pid+",\n" +
                "                \"langcode\": \""+data_path_langcode+"\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"relationships\": {\n" +
                "            \"vid\": {\n" +
                "                \"data\": {\n" +
                "                    \"type\": \""+data_relationships_vid_data_type+"\",\n" +
                "                    \"id\": \""+data_relationships_vid_data_id+"\"\n" +
                "                },\n" +
                "                \"links\": {\n" +
                "                    \"self\": {\n" +
                "                        \"href\": \""+data_relationships_vid_links_self_href+"\"\n" +
                "                    },\n" +
                "                    \"related\": {\n" +
                "                        \"href\": \""+data_relationships_vid_links_related_href+"\"\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"revision_user\": {\n" +
                "                \"data\": null,\n" +
                "                \"links\": {\n" +
                "                    \"self\": {\n" +
                "                        \"href\": \""+data_relationships_revision_user_inks_self_href+"\"\n" +
                "                    },\n" +
                "                    \"related\": {\n" +
                "                        \"href\": \""+data_relationships_revision_user_inks_related_href+"\"\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"parent\": {\n" +
                "                \"data\": [\n" +
                "                    {\n" +
                "                        \"type\": \""+data_relationships_parent_data_type+"\",\n" +
                "                        \"id\": \""+data_relationships_parent_data_id+"\",\n" +
                "                        \"meta\": {\n" +
                "                            \"links\": {\n" +
                "                                \"help\": {\n" +
                "                                    \"href\": \""+data_relationships_parent_data_meta_links_self_href+"\",\n" +
                "                                    \"meta\": {\n" +
                "                                        \"about\": \""+data_relationships_parent_data_meta_links_self_meta_about+"\"\n" +
                "                                    }\n" +
                "                                }\n" +
                "                            }\n" +
                "                        }\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"links\": {\n" +
                "                    \"self\": {\n" +
                "                        \"href\": \""+data_relationships_parent_links_self_href+"\"\n" +
                "                    },\n" +
                "                    \"related\": {\n" +
                "                        \"href\": \""+data_relationships_parent_links_related_href+"\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        \"links\": {\n" +
                "            \"self\": {\n" +
                "                \"href\": \""+data_links_self_href+"\"\n" +
                "            }\n" +
                "        }\n" +
                "    },\n" +
                "    \"links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \""+links_self_href+"\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        Gson g = new Gson();
        TaxonomyAziendaResponseBean obj = g.fromJson(jsonString, TaxonomyAziendaResponseBean.class);

        //PRINT
        System.out.println(jsonString);
        System.out.println(obj.toString());

        //ASSERTS
        Assert.assertTrue(jsonapi_version.equals(obj.getJsonapi().getVersion()));
        Assert.assertTrue(jsonapi_meta_links_self_href.equals(obj.getJsonapi().getMeta().getLinks().getSelf().getHref()));
        Assert.assertTrue(data_type.equals(obj.getdata().getType()));
        Assert.assertTrue(data_id.equals(obj.getdata().getId()));
        Assert.assertTrue(data_attributes_drupal_internal__tid.equals(obj.getdata().getAttributes().getDrupal_internal__tid()));
        Assert.assertTrue(data_attributes_drupal_internal__revision_id.equals(obj.getdata().getAttributes().getDrupal_internal__revision_id()));
        Assert.assertTrue(data_attributes_langcode.equals(obj.getdata().getAttributes().getLangcode()));
        Assert.assertTrue(data_revision_created.equals(obj.getdata().getAttributes().getRevision_created()));
        Assert.assertTrue(obj.getdata().getAttributes().getRevision_log_message() == null);
        Assert.assertTrue(data_staus.equals(obj.getdata().getAttributes().getStatus()));
        Assert.assertTrue(data_name.equals(((TaxonomyAziendaResponseAttributes) obj.getdata().getAttributes()).getName()));
        Assert.assertTrue(obj.getdata().getAttributes().getDescription() == null);
        Assert.assertTrue(data_weight.equals(obj.getdata().getAttributes().getWeight()));
        Assert.assertTrue(data_changed.equals(obj.getdata().getAttributes().getChanged()));
        Assert.assertTrue(data_default_langcode.equals(obj.getdata().getAttributes().getDefault_langcode()));
        Assert.assertTrue(data_revision_translation_affected.equals(obj.getdata().getAttributes().getRevision_translation_affected()));
        Assert.assertTrue(obj.getdata().getAttributes().getPath().getAlias() == null);
        Assert.assertTrue(obj.getdata().getAttributes().getPath().getPid() == null);
        Assert.assertTrue(data_path_langcode.equals(obj.getdata().getAttributes().getPath().getLangcode()));
        Assert.assertTrue(data_relationships_vid_data_type.equals(obj.getdata().getRelationships().getVid().getData().getType()));
        Assert.assertTrue(data_relationships_vid_data_id.equals(obj.getdata().getRelationships().getVid().getData().getId()));
        Assert.assertTrue(data_relationships_vid_links_self_href.equals(obj.getdata().getRelationships().getVid().getLinks().getSelf().getHref()));
        Assert.assertTrue(data_relationships_vid_links_related_href.equals(obj.getdata().getRelationships().getVid().getLinks().getRelated().getHref()));
        Assert.assertTrue(data_relationships_revision_user_inks_self_href.equals(obj.getdata().getRelationships().getRevision_user().getLinks().getSelf().getHref()));
        Assert.assertTrue(data_relationships_revision_user_inks_related_href.equals(obj.getdata().getRelationships().getRevision_user().getLinks().getRelated().getHref()));
        Assert.assertTrue(data_relationships_parent_data_type.equals(obj.getdata().getRelationships().getParent().getData().get(0).getType()));
        Assert.assertTrue(data_relationships_parent_data_id.equals(obj.getdata().getRelationships().getParent().getData().get(0).getId()));
        Assert.assertTrue(data_relationships_parent_data_meta_links_self_href.equals(obj.getdata().getRelationships().getParent().getData().get(0).getMeta().getLinks().getHelp().getHref()));
        Assert.assertTrue(data_relationships_parent_data_meta_links_self_meta_about.equals(obj.getdata().getRelationships().getParent().getData().get(0).getMeta().getLinks().getHelp().getMeta().getAbout()));
        Assert.assertTrue(data_relationships_parent_links_self_href.equals(obj.getdata().getRelationships().getParent().getLinks().getSelf().getHref()));
        Assert.assertTrue(data_relationships_parent_links_related_href.equals(obj.getdata().getRelationships().getParent().getLinks().getRelated().getHref()));
        Assert.assertTrue(data_links_self_href.equals(obj.getdata().getLinks().getSelf().getHref()));
        Assert.assertTrue(links_self_href.equals(obj.getLinks().getSelf().getHref()));

    }
}
