package it.almaviva.cgsse.drupal.taxonomy.client;

import it.almaviva.cgsse.bo.bean.taxonomy.TaxonomyRilevanzaBOBean;
import it.almaviva.cgsse.drupal.exception.NotValideRequestException;
import it.almaviva.cgsse.drupal.taxonomy.bean.rilevanza.TaxonomyRilevanzaRequestBean;
import org.junit.Assert;
import org.junit.Test;

public class TaxonomyRilevanzaClientTest {

    @Test
    public void test(){
        System.out.println("START - TEST");
        String name = "Rilevanza di prova";
        String fk = "23";

        TaxonomyRilevanzaBOBean bo = null;
        TaxonomyRilevanzaBOBean bo2 = null;

        try {
            testGetAll();
        }catch(Exception ex){
            System.out.println(ex);
        }

        try {
             bo =  testPost(name, fk);
        }catch(Exception ex){
            System.out.println(ex);
        }

        try {
            bo2 = testGetByFk(fk);
        }catch(Exception ex){
            System.out.println(ex);
        }

        Assert.assertTrue(bo.getName().equals(bo2.getName()));
        Assert.assertTrue(bo.getFk().equals(bo2.getFk()));
        Assert.assertTrue(bo.getUuid().equals(bo2.getUuid()));

        try {
            bo2 = testGet(bo.getUuid());
        }catch(Exception ex){
            System.out.println(ex);
        }

        Assert.assertTrue(bo.getName().equals(bo2.getName()));
        Assert.assertTrue(bo.getFk().equals(bo2.getFk()));
        Assert.assertTrue(bo.getUuid().equals(bo2.getUuid()));

        try {
            bo2 =  testUpdate(bo.getUuid(), "EDITATO", fk);
        }catch(Exception ex){
            System.out.println(ex);
        }

        Assert.assertTrue("EDITATO".equals(bo2.getName()));
        Assert.assertTrue(bo.getFk().equals(bo2.getFk()));
        Assert.assertTrue(bo.getUuid().equals(bo2.getUuid()));

        try {
            bo2 = testGet(bo.getUuid());
        }catch(Exception ex){
            System.out.println(ex);
        }

        Assert.assertTrue("EDITATO".equals(bo2.getName()));
        Assert.assertTrue(bo.getFk().equals(bo2.getFk()));
        Assert.assertTrue(bo.getUuid().equals(bo2.getUuid()));

        try {
            testDel(bo.getUuid());
        }catch(Exception ex){
            System.out.println(ex);
        }

        System.out.println("END - TEST");
    }

    public void testGetAll(){
        System.out.println("-------------------->TEST - testGetAll");
        Boolean check = true;

        try{
            TaxonomyRilevanzaClient client = new TaxonomyRilevanzaClient(new TaxonomyRilevanzaRequestBean());
            client.getAll();
        }catch (Exception e){
            System.out.println(e);
            check = false;
        }

        Assert.assertTrue(check);
        System.out.println("-------------------->TEST - GetAll - Result: "+ check);
    }

    public TaxonomyRilevanzaBOBean testGetByFk(String fk) throws Exception {
        System.out.println("-------------------->TEST - testGetByFk");
        Boolean check = true;

        TaxonomyRilevanzaRequestBean req = new TaxonomyRilevanzaRequestBean();
        req.setFk(fk);
        TaxonomyRilevanzaClient client = new TaxonomyRilevanzaClient(req);
        client.getByFk();

        try{
            client.getByFk();
        }catch (Exception e){
            System.out.println(e);
            check = false;
        }

        Assert.assertTrue(check);
        System.out.println("-------------------->TEST - testGetByFk - Result: "+ check);
        return client.getResBOList().get(0);
    }

    public TaxonomyRilevanzaBOBean testGet(String uuid) throws Exception {
        System.out.println("-------------------->TEST - testGet");
        Boolean check = true;

        TaxonomyRilevanzaRequestBean req = new TaxonomyRilevanzaRequestBean();
        req.setUuid(uuid);
        TaxonomyRilevanzaClient client = new TaxonomyRilevanzaClient(req);

        try{
            client.get();
        }catch (Exception e){
            System.out.println(e);
            check = false;
        }

        Assert.assertTrue(check);
        System.out.println("-------------------->TEST - Get - Result: "+ check);
        return client.getResBO();
    }

    public TaxonomyRilevanzaBOBean testPost(String name, String fk) throws Exception {
        System.out.println("-------------------->TEST - testPost");
        Boolean check = true;

        TaxonomyRilevanzaRequestBean req =new TaxonomyRilevanzaRequestBean(name);
        req.setFk(fk);
        TaxonomyRilevanzaClient client = new TaxonomyRilevanzaClient(req);

        try{
            client.post();
        }catch (Exception e){
            System.out.println(e);
            check = false;
        }

        Assert.assertTrue(check);
        System.out.println("-------------------->TEST - Post - Result: "+ check);
        return client.getResBO();
    }


    public void testDel(String uuid) throws Exception {
        System.out.println("-------------------->TEST - testDel");
        Boolean check = true;

        TaxonomyRilevanzaRequestBean req = new TaxonomyRilevanzaRequestBean();
        req.setUuid(uuid);
        TaxonomyRilevanzaClient client = new TaxonomyRilevanzaClient(req);

        try{
            client.del();
        }catch(NotValideRequestException exc){
            System.out.println(exc);
            check = false;
        }

        Assert.assertTrue(check);
        System.out.println("-------------------->TEST - testDel - Result: "+ check);
    }

    public TaxonomyRilevanzaBOBean testUpdate(String uuid, String newText, String fk) throws Exception {
        System.out.println("-------------------->TEST - testUpdate");
        Boolean check = true;

        TaxonomyRilevanzaRequestBean req = new TaxonomyRilevanzaRequestBean();
        req.setUuid(uuid);
        req.setName(newText);
        req.setFk(fk);

        TaxonomyRilevanzaClient client = new TaxonomyRilevanzaClient(req);
        try{
            client.patch();
        }catch(NotValideRequestException e){
            System.out.println(e);
            check = false;
        }

        Assert.assertTrue(check);
        System.out.println("-------------------->TEST - testUpdate - Result: "+ check);
        return client.getResBO();
    }


}
