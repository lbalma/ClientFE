package it.almaviva.cgsse.drupal.taxonomy.client;

import it.almaviva.cgsse.drupal.bean.TaxonomyAziendaBean;
import it.almaviva.cgsse.drupal.exception.NotValideRequestException;
import org.junit.Test;

public class TaxonomyAziendaClientTest {

    @Test
    public void testGetAll() throws Exception {
        System.out.println("TEST - GetAll");
        TaxonomyAziendaClient client = new TaxonomyAziendaClient(new TaxonomyAziendaBean());
        String res = client.getAll();
        System.out.println(res);
    }

    @Test
    public void testGet() throws Exception {
        System.out.println("TEST - Get");
        TaxonomyAziendaClient client = new TaxonomyAziendaClient(new TaxonomyAziendaBean());
        String res = client.get("17669f7c-1283-43c0-aa0d-e89d96d116ae");
        System.out.println(res);
    }

    @Test
    public void testPost() throws Exception {
        System.out.println("TEST - Post");
        TaxonomyAziendaClient client = new TaxonomyAziendaClient(new TaxonomyAziendaBean("fromClient -NEW"));
        String res = client.post();
        System.out.println(res);
    }

    @Test
    public void testPostNotValide() throws Exception {
        System.out.println("TEST - testPostNotValide");
        TaxonomyAziendaClient client = new TaxonomyAziendaClient(new TaxonomyAziendaBean(null));
        try{
            String res = client.post();
            System.out.println(res);
        }catch(NotValideRequestException exc){
            System.out.println("Eccezione gestita");
        }

    }


}
