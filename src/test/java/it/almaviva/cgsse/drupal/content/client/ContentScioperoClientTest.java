package it.almaviva.cgsse.drupal.content.client;

import it.almaviva.cgsse.drupal.common.bean.AJsonapiRequestBean;
import it.almaviva.cgsse.drupal.content.bean.intervento.ContentInterventoRequestBean;
import it.almaviva.cgsse.drupal.content.bean.sciopero.ContentScioperoRequestBean;
import it.almaviva.cgsse.drupal.content.bean.sciopero.ScioperoWorkableBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.azienda.TaxonomyAziendaRequestBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.rilevanza.TaxonomyRilevanzaRequestBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.settore.TaxonomySettoreRequestBean;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ContentScioperoClientTest {

    @Test
    public void test(){
        System.out.println("START - TEST");
        ScioperoWorkableBean workableBean = new ScioperoWorkableBean();
        ScioperoWorkableBean workableBean2 = new ScioperoWorkableBean();

        try {
            testGetAll();
        }catch(Exception ex){
            System.out.println(ex);
        }

        try {
            workableBean = testPost();
        }catch(Exception ex){
            System.out.println(ex);
        }

        try {
            workableBean2= testGetByFk(workableBean.getFk());
        }catch(Exception ex){
            System.out.println(ex);
        }

        Assert.assertTrue(workableBean.getControparte().equals(workableBean2.getControparte()));;
        Assert.assertTrue(workableBean.getFine().equals(workableBean2.getFine()));;
        Assert.assertTrue(workableBean.getInizio().equals(workableBean2.getInizio()));;
        Assert.assertTrue(workableBean.getRevocato().equals(workableBean2.getRevocato()));;
        Assert.assertTrue(workableBean.getDifferito().equals(workableBean2.getDifferito()));;
        Assert.assertTrue(workableBean.getPosizione().equals(workableBean2.getPosizione()));
        Assert.assertTrue(workableBean.getFk().equals(workableBean2.getFk()));
        Assert.assertTrue(workableBean.getUuid().equals(workableBean2.getUuid()));
        Assert.assertTrue(workableBean.getTitle().equals(workableBean2.getTitle()));


        Assert.assertTrue(workableBean.getAzienda() == workableBean2.getAzienda() || workableBean.getAzienda().equals(workableBean2.getAzienda()));;
        Assert.assertTrue(workableBean.getSettore() == workableBean2.getSettore() ||workableBean.getSettore().equals(workableBean2.getSettore()));;
        Assert.assertTrue(workableBean.getRilevanza() == workableBean2.getRilevanza() || workableBean.getRilevanza().equals(workableBean2.getRilevanza()));;
        Assert.assertTrue(workableBean.getInterventi() == workableBean2.getInterventi() || workableBean.getInterventi().equals(workableBean2.getInterventi()));

        try {
            workableBean = testUpdate(workableBean);
        }catch(Exception ex){
            System.out.println(ex);
        }

        try {
            workableBean2= testGetByFk(workableBean.getFk());
        }catch(Exception ex){
            System.out.println(ex);
        }

        Assert.assertTrue(workableBean.getControparte().equals(workableBean2.getControparte()));;
        Assert.assertTrue(workableBean.getFine().equals(workableBean2.getFine()));;
        Assert.assertTrue(workableBean.getInizio().equals(workableBean2.getInizio()));;
        Assert.assertTrue(workableBean.getRevocato().equals(workableBean2.getRevocato()));;
        Assert.assertTrue(workableBean.getDifferito().equals(workableBean2.getDifferito()));;
        Assert.assertTrue(workableBean.getPosizione().equals(workableBean2.getPosizione()));
        Assert.assertTrue(workableBean.getFk().equals(workableBean2.getFk()));
        Assert.assertTrue(workableBean.getUuid().equals(workableBean2.getUuid()));
        Assert.assertTrue(workableBean.getTitle().equals(workableBean2.getTitle()));


        Assert.assertTrue(workableBean2.getAzienda().equals("2f08b977-8623-4bf7-9c5f-fa6193aa42eb"));;
        Assert.assertTrue(workableBean2.getSettore().equals("9ae63cf1-fb02-43c1-b596-f07e7c7b9392"));;
        Assert.assertTrue(workableBean2.getRilevanza().equals("95283655-ccbe-4586-aad9-259cc8a35d7b"));;
        Assert.assertTrue(workableBean2.getInterventi().get(0).equals("0e28a082-669f-470c-954d-a4176f8c9282"));

        try {
            testDel(workableBean2.getUuid());
        }catch(Exception ex){
            System.out.println(ex);
        }

        try {
            workableBean = testPostComplete();
        }catch(Exception ex){
            System.out.println(ex);
        }

        try {
            workableBean2= testGetByFk(workableBean.getFk());
        }catch(Exception ex){
            System.out.println(ex);
        }

        Assert.assertTrue(workableBean.getControparte().equals(workableBean2.getControparte()));;
        Assert.assertTrue(workableBean.getFine().equals(workableBean2.getFine()));;
        Assert.assertTrue(workableBean.getInizio().equals(workableBean2.getInizio()));;
        Assert.assertTrue(workableBean.getRevocato().equals(workableBean2.getRevocato()));;
        Assert.assertTrue(workableBean.getDifferito().equals(workableBean2.getDifferito()));;
        Assert.assertTrue(workableBean.getPosizione().equals(workableBean2.getPosizione()));
        Assert.assertTrue(workableBean.getFk().equals(workableBean2.getFk()));
        Assert.assertTrue(workableBean.getUuid().equals(workableBean2.getUuid()));
        Assert.assertTrue(workableBean.getTitle().equals(workableBean2.getTitle()));


        Assert.assertTrue(workableBean2.getAzienda().equals(workableBean.getAzienda()));
        Assert.assertTrue(workableBean2.getSettore().equals(workableBean.getSettore()));
        Assert.assertTrue(workableBean2.getRilevanza().equals(workableBean.getRilevanza()));
        Assert.assertTrue(workableBean2.getInterventi().get(0).equals(workableBean.getInterventi().get(0)));

        try {
            testDel(workableBean2.getUuid());
        }catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println("END - TEST");
    }

    public void testGetAll() throws Exception {
        System.out.println("-------------------->TEST - testGetAll");
        Boolean check = true;

        try{
            ScioperoClient client = new ScioperoClient(new ContentScioperoRequestBean());
            client.getAll();
        }catch (Exception e){
            System.out.println(e);
            check = false;
        }
        Assert.assertTrue(check);
        System.out.println("-------------------->TEST - GetAll - Result: "+ check);
    }

    public ScioperoWorkableBean testGetByFk(String fk) throws Exception {
        Boolean check = true;
        System.out.println("-------------------->TEST - GetFk");

        ContentScioperoRequestBean req = new ContentScioperoRequestBean();
        req.setFk(fk);
        ScioperoClient client = new ScioperoClient(req);
        try{
            client.getByFk();
        }catch (Exception e){
            System.out.println(e);
            check = false;
        }
        Assert.assertTrue(check);
        System.out.println("-------------------->TEST - GetFk - Result: "+ check);
        return client.getResList().get(0);
    }

    public ScioperoWorkableBean testPost() throws Exception {
        Boolean check = true;
        System.out.println("-------------------->TEST - testPost");

        ContentScioperoRequestBean req = new ContentScioperoRequestBean();
        req.setPosizione("12");
        req.setTitle("Titolo Sciopero");
        req.setControparte("Cotnro parte");
        req.setInizio("2019-10-01");
        req.setFine("2019-10-01");
        req.setDifferito(false);
        req.setRevocato(false);
        req.setFk("65");

        ScioperoClient client = new ScioperoClient(req);
        try{
            client.post();
        }catch (Exception e){
            System.out.println(e);
            check = false;
        }

        Assert.assertTrue(check);
        System.out.println("-------------------->TEST - testPost - Result: "+ check);
        return client.getRes();
    }


    public ScioperoWorkableBean testPostComplete() throws Exception {
        Boolean check = true;
        System.out.println("-------------------->TEST - testPostComplete");

        ContentScioperoRequestBean req = new ContentScioperoRequestBean();
        req.setPosizione("12");
        req.setTitle("Titolo Sciopero");
        req.setControparte("Cotnro parte");
        req.setInizio("2019-10-01");
        req.setFine("2019-10-01");
        req.setDifferito(false);
        req.setRevocato(false);
        req.setFk("65");

        TaxonomyAziendaRequestBean azienda = new TaxonomyAziendaRequestBean();
        azienda.setUuid("2f08b977-8623-4bf7-9c5f-fa6193aa42eb");
        TaxonomySettoreRequestBean settore = new TaxonomySettoreRequestBean();
        settore.setUuid("9ae63cf1-fb02-43c1-b596-f07e7c7b9392");
        TaxonomyRilevanzaRequestBean rilevanza = new TaxonomyRilevanzaRequestBean();
        rilevanza.setUuid("95283655-ccbe-4586-aad9-259cc8a35d7b");
        List<AJsonapiRequestBean> interventi = new ArrayList<>();
        List<ContentInterventoRequestBean> interventiCast = new ArrayList<>();
        ContentInterventoRequestBean intervento = new ContentInterventoRequestBean();
        intervento.setUuid("0e28a082-669f-470c-954d-a4176f8c9282");
        interventi.add(intervento);
        interventiCast.add(intervento);

        req.setAzienda(azienda);
        req.setSettore(settore);
        req.setRilevanza(rilevanza);
        req.setInterventi(interventiCast);

        ScioperoClient client = new ScioperoClient(req);
        try{
            client.post();
        }catch (Exception e){
            System.out.println(e);
            check = false;
        }

        Assert.assertTrue(check);
        System.out.println("-------------------->TEST - testPostComplete - Result: "+ check);
        return client.getRes();
    }

    public void testDel(String uuid) throws Exception {
        Boolean check = true;
        System.out.println("-------------------->TEST - testDel");
        ContentScioperoRequestBean req = new ContentScioperoRequestBean();
        req.setUuid(uuid);
        ScioperoClient client = new ScioperoClient(req);
        try{
            client.del();
        }catch (Exception e){
            System.out.println(e);
            check = false;
        }
        Assert.assertTrue(check);
        System.out.println("-------------------->TEST - testDel - Result: "+ check);
    }

    public ScioperoWorkableBean testUpdate(ScioperoWorkableBean workableBean) throws Exception {
        Boolean check = true;
        System.out.println("-------------------->TEST - testUpdate");

        ContentScioperoRequestBean req = new ContentScioperoRequestBean();
        req.setFk(workableBean.getFk());
        req.setTitle(workableBean.getTitle());
        req.setControparte(workableBean.getControparte());
        req.setPosizione(workableBean.getPosizione());
        req.setFine(workableBean.getFine());
        req.setInizio(workableBean.getInizio());
        req.setUuid(workableBean.getUuid());
        req.setRevocato(workableBean.getRevocato());
        req.setDifferito(workableBean.getDifferito());

        TaxonomyAziendaRequestBean azienda = new TaxonomyAziendaRequestBean();
        azienda.setUuid("2f08b977-8623-4bf7-9c5f-fa6193aa42eb");
        TaxonomySettoreRequestBean settore = new TaxonomySettoreRequestBean();
        settore.setUuid("9ae63cf1-fb02-43c1-b596-f07e7c7b9392");
        TaxonomyRilevanzaRequestBean rilevanza = new TaxonomyRilevanzaRequestBean();
        rilevanza.setUuid("95283655-ccbe-4586-aad9-259cc8a35d7b");
        List<AJsonapiRequestBean> interventi = new ArrayList<>();
        List<ContentInterventoRequestBean> interventiCast = new ArrayList<>();
        ContentInterventoRequestBean intervento = new ContentInterventoRequestBean();
        intervento.setUuid("0e28a082-669f-470c-954d-a4176f8c9282");
        interventi.add(intervento);
        interventiCast.add(intervento);

        req.setAzienda(azienda);
        req.setSettore(settore);
        req.setRilevanza(rilevanza);
        req.setInterventi(interventiCast);

        ScioperoClient client = new ScioperoClient(req);
        try{
            client.patchUpdateContentRelationship("field_azienda",azienda);
            client.patchUpdateContentRelationship("field_settore",settore);
            client.patchUpdateContentRelationship("field_rilevanza",rilevanza);
            client.patchUpdateContentRelationshipList("field_interventi",interventi);

            client.patch();
        }catch (Exception e){
            System.out.println(e);
            check = false;
        }
        Assert.assertTrue(check);
        System.out.println("-------------------->TEST - testUpdate - Result: "+ check);
        return client.getResList().get(0);
    }
}
