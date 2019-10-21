package it.almaviva.cgsse.drupal.taxonomy.client;

import it.almaviva.cgsse.bo.bean.TaxonomyAziendaBOBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.TaxonomyAziendaRequestBean;
import it.almaviva.cgsse.drupal.exception.NotValideRequestException;
import org.junit.Test;

public class TaxonomyAziendaClientTest {

    @Test
    public void test(){
        System.out.println("START - TEST");
        String newUuid = "";
        try {
            testGetAll();
        }catch(Exception ex){

        }

        try {
            newUuid = testPost().getUuid();
        }catch(Exception ex){

        }

        try {
            testGet(newUuid);
        }catch(Exception ex){

        }

        try {
            testUpdate(newUuid, "EDITATO");
        }catch(Exception ex){

        }

        try {
            testGet(newUuid);
        }catch(Exception ex){

        }

        try {
            testDel(newUuid);
        }catch(Exception ex){

        }
/*
        try {
            testPostNotValide();
        }catch(Exception ex){

        }
*/
        System.out.println("END - TEST");
    }

    public void testGetAll() throws Exception {
        System.out.println("TEST - GetAll");
        TaxonomyAziendaClient client = new TaxonomyAziendaClient(new TaxonomyAziendaRequestBean());
        client.getAll();
    }

    public void testGet(String uuid) throws Exception {
        System.out.println("TEST - Get");
        TaxonomyAziendaRequestBean req = new TaxonomyAziendaRequestBean();
        req.setUUID(uuid);
        TaxonomyAziendaClient client = new TaxonomyAziendaClient(req);
        client.get();
    }

    public TaxonomyAziendaBOBean testPost() throws Exception {
        System.out.println("TEST - Post");
        TaxonomyAziendaClient client = new TaxonomyAziendaClient(new TaxonomyAziendaRequestBean("fromClient -NEW"));
        client.post();
        return client.getResBO();
    }

    public void testPostNotValide() throws Exception {
        System.out.println("TEST - testPostNotValide");
        TaxonomyAziendaClient client = new TaxonomyAziendaClient(new TaxonomyAziendaRequestBean(null));
        try{
            client.post();
        }catch(NotValideRequestException exc){
            System.out.println("Eccezione gestita");
        }
    }

    public void testDel(String uuid) throws Exception {
        System.out.println("TEST - testDel");
        TaxonomyAziendaRequestBean req = new TaxonomyAziendaRequestBean();
        req.setUUID(uuid);
        TaxonomyAziendaClient client = new TaxonomyAziendaClient(req);
        try{
            client.del();
        }catch(NotValideRequestException exc){
            System.out.println("Eccezione gestita");
        }

    }

    public void testUpdate(String uuid, String newText) throws Exception {
        System.out.println("TEST - testUpdate");
        TaxonomyAziendaRequestBean req = new TaxonomyAziendaRequestBean();
        req.setUUID(uuid);
        req.setName(newText);
        TaxonomyAziendaClient client = new TaxonomyAziendaClient(req);
        try{
            client.patch();
        }catch(NotValideRequestException exc){
            System.out.println("Eccezione gestita");
        }

    }


}
