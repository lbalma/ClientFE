package it.almaviva.cgsse.drupal.taxonomy.client;

import it.almaviva.cgsse.bo.bean.taxonomy.TaxonomyAziendaBOBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.azienda.TaxonomyAziendaRequestBean;
import it.almaviva.cgsse.drupal.exception.NotValideRequestException;
import org.junit.Assert;
import org.junit.Test;

public class TaxonomyAziendaClientTest {

    @Test
    public void test(){
        System.out.println("START - TEST");
        String name = "Azienda di prova";
        String fk = "23";

        TaxonomyAziendaBOBean bo = null;
        TaxonomyAziendaBOBean bo2 = null;

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
        System.out.println("-------------------->TEST - GetAll");
        Boolean check = true;

        try{
            TaxonomyAziendaClient client = new TaxonomyAziendaClient(new TaxonomyAziendaRequestBean());
            client.getAll();
        }catch (Exception e){
            System.out.println(e);
            check = false;
        }

        Assert.assertTrue(check);
        System.out.println("-------------------->TEST - GetAll - Result: "+ check);
    }

    public TaxonomyAziendaBOBean testGetByFk(String fk) throws Exception {
        System.out.println("-------------------->TEST - testGetByFk");
        Boolean check = true;

        TaxonomyAziendaRequestBean req = new TaxonomyAziendaRequestBean();
        req.setFk(fk);
        TaxonomyAziendaClient client = new TaxonomyAziendaClient(req);
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

    public TaxonomyAziendaBOBean testGet(String uuid) throws Exception {
        System.out.println("-------------------->TEST - Get");
        Boolean check = true;

        TaxonomyAziendaRequestBean req = new TaxonomyAziendaRequestBean();
        req.setUuid(uuid);
        TaxonomyAziendaClient client = new TaxonomyAziendaClient(req);

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

    public TaxonomyAziendaBOBean testPost(String name, String fk) throws Exception {
        System.out.println("-------------------->TEST - testPost");
        Boolean check = true;

        TaxonomyAziendaRequestBean req =new TaxonomyAziendaRequestBean(name);
        req.setFk(fk);
        TaxonomyAziendaClient client = new TaxonomyAziendaClient(req);

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

        TaxonomyAziendaRequestBean req = new TaxonomyAziendaRequestBean();
        req.setUuid(uuid);
        TaxonomyAziendaClient client = new TaxonomyAziendaClient(req);

        try{
            client.del();
        }catch(NotValideRequestException e){
            System.out.println(e);
            check = false;
        }

        Assert.assertTrue(check);
        System.out.println("-------------------->TEST - testDel - Result: "+ check);
    }

    public TaxonomyAziendaBOBean testUpdate(String uuid, String newText, String fk) throws Exception {
        System.out.println("-------------------->TEST - testUpdate");
        Boolean check = true;

        TaxonomyAziendaRequestBean req = new TaxonomyAziendaRequestBean();
        req.setUuid(uuid);
        req.setName(newText);
        req.setFk(fk);

        TaxonomyAziendaClient client = new TaxonomyAziendaClient(req);
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
