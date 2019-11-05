package it.almaviva.cgsse.drupal.content.client;

import it.almaviva.cgsse.drupal.content.bean.GenericFile;
import it.almaviva.cgsse.drupal.content.bean.file.FileWorkableBean;
import it.almaviva.cgsse.drupal.content.bean.intervento.ContentInterventoRequestBean;
import it.almaviva.cgsse.drupal.content.bean.intervento.InterventoWorkableBean;
import it.almaviva.cgsse.drupal.exception.NotValideRequestException;
import it.almaviva.cgsse.utils.Tools;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.text.ParseException;

public class ContentInterventoClientTest {

    @Test
    public void test() throws ParseException {
        System.out.println("START - TEST");
        String newUuid = "";
        File allegato = new File("/home/luca/Scaricati/Scioperi.pdf");
        FileWorkableBean workableFile = new FileWorkableBean();
        InterventoWorkableBean workableBean = new InterventoWorkableBean();
        InterventoWorkableBean workableBean2 = new InterventoWorkableBean();

        System.out.println( allegato.isFile());
        System.out.println(allegato.getName());
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
            workableFile = testInsertFile(allegato);
        }catch(Exception ex){
            System.out.println(ex);
        }


        try {
            workableBean2=  testGetByFk(workableBean.getFk());
        }catch(Exception ex){
            System.out.println(ex);
        }

        Assert.assertTrue(workableBean.getIntervento().equals(workableBean2.getIntervento()));
        Assert.assertTrue(workableBean.getDescrizione().equals(workableBean2.getDescrizione()));
        Assert.assertTrue(workableBean.getPosizione().equals(workableBean2.getPosizione()));
        Assert.assertTrue(workableBean.getDataIntervento().equals(workableBean2.getDataIntervento()));
        Assert.assertTrue(workableBean.getFk().equals(workableBean2.getFk()));
        Assert.assertTrue(workableBean.getUuid().equals(workableBean2.getUuid()));
        Assert.assertTrue(workableBean.getTitle().equals(workableBean2.getTitle()));


        try {
            testUpdateFile(workableBean, workableFile);
        }catch(Exception ex){
            System.out.println(ex);

        }


        try {
            workableBean2=  testGetByFk(workableBean.getFk());
        }catch(Exception ex){
            System.out.println(ex);
        }

        Assert.assertTrue(workableBean.getIntervento().equals(workableBean2.getIntervento()));
        Assert.assertTrue(workableBean.getDescrizione().equals(workableBean2.getDescrizione()));
        Assert.assertTrue(workableBean.getPosizione().equals(workableBean2.getPosizione()));
        Assert.assertTrue(workableBean.getDataIntervento().equals(workableBean2.getDataIntervento()));
        Assert.assertTrue(workableBean.getFk().equals(workableBean2.getFk()));
        Assert.assertTrue(workableBean.getUuid().equals(workableBean2.getUuid()));
        Assert.assertTrue(workableBean.getTitle().equals(workableBean2.getTitle()));
        Assert.assertTrue(workableFile.getUuid().equals(workableBean2.getAllegato()));

        try {
            testDel(workableBean.getUuid());
        }catch(Exception ex){
            System.out.println(ex);
        }

        ContentInterventoRequestBean req = new ContentInterventoRequestBean();
        req.setIntervento(workableBean.getIntervento());
        req.setPosizione(workableBean.getPosizione());
        req.setDataIntervento(Tools.drupalStringDateToDate(workableBean.getDataIntervento()));
        req.setDescrizione(workableBean.getDescrizione());
        req.setFk(workableBean.getFk());
        req.setTitle(workableBean.getTitle());

        GenericFile gf = new GenericFile();
        gf.setUuid(workableFile.getUuid());
        gf.setDescription(workableFile.getDescription());
        req.setAllegato(gf);

       try {
            workableBean = testPostWithFile(req);
        }catch(Exception ex){
            System.out.println(ex);
        }

        try {
            testDel(workableBean.getUuid());
        }catch(Exception ex){
            System.out.println(ex);
        }

        System.out.println("END - TEST");
    }

    private FileWorkableBean testInsertFile(File f) throws Exception {
        Boolean check = true;
        System.out.println("-------------------->TEST - testInsertFile");

        ContentInterventoRequestBean req = new ContentInterventoRequestBean();
        GenericFile gf = new GenericFile();
        gf.setFile(Files.readAllBytes(f.toPath()));
        gf.setName("Prova.pdf");
        gf.setDescription("Descrizione");
        req.setAllegato(gf);
        InterventoClient client = new InterventoClient(req);

        try{
            client.postFile("field_allegato");
        }catch (Exception e){
            System.out.println(e);
            check = false;
        }
        Assert.assertTrue(check);
        System.out.println("-------------------->TEST - testInsertFile - Result: "+ check);

        return client.getResFile();
    }

    public void testGetAll() throws Exception {
        System.out.println("-------------------->TEST - GetAll");
        Boolean check = true;
        try{
            InterventoClient client = new InterventoClient(new ContentInterventoRequestBean());
            client.getAll();
        }catch (Exception e){
            System.out.println(e);
            check = false;
        }
        Assert.assertTrue(check);
        System.out.println("-------------------->TEST - GetAll - Result: "+ check);
    }


    public InterventoWorkableBean testGetByFk(String fk) throws Exception {
        Boolean check = true;
        System.out.println("-------------------->TEST - testGetByFk");

        ContentInterventoRequestBean req = new ContentInterventoRequestBean();
        req.setFk(fk);
        InterventoClient client = new InterventoClient(req);

        try{
            client.getByFk();
        }catch (Exception e){
            System.out.println(e);
            check = false;
        }

        Assert.assertTrue(check);
        System.out.println("-------------------->TEST - testGetByFk - Result: "+ check);
        return client.getResList().get(0);
    }

    public InterventoWorkableBean testPost() throws Exception {
        Boolean check = true;
        System.out.println("-------------------->TEST - testPost");

        ContentInterventoRequestBean req = new ContentInterventoRequestBean();
        req.setIntervento("Intervento");
        req.setPosizione("12");
        req.setDataIntervento(Tools.drupalStringDateToDate("2019-10-01"));
        req.setDescrizione("Desc");
        req.setFk("23");
        req.setTitle("Titolo");
        InterventoClient client = new InterventoClient(req);
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

    public InterventoWorkableBean testPostWithFile(ContentInterventoRequestBean req) throws Exception {
        Boolean check = true;
        System.out.println("-------------------->TEST - testPostWithFile");

        InterventoClient client = new InterventoClient(req);
        try{
            client.post();
        }catch (Exception e){
            System.out.println(e);
            check = false;
        }

        Assert.assertTrue(check);
        System.out.println("-------------------->TEST - testPostWithFile - Result: "+ check);
        return client.getRes();
    }

    public void testDel(String uuid) throws Exception {
        System.out.println("-------------------->TEST - testDel");
        Boolean check = true;

        ContentInterventoRequestBean req = new ContentInterventoRequestBean();
        req.setUuid(uuid);
        InterventoClient client = new InterventoClient(req);
        try{
            client.del();
        }catch(NotValideRequestException exc){
            System.out.println(exc);
            check = false;
        }

        Assert.assertTrue(check);
        System.out.println("-------------------->TEST - testDel - Result: "+ check);
    }

    public void testUpdateFile(InterventoWorkableBean workableBean, FileWorkableBean workableFile) throws Exception {
        Boolean check = true;
        System.out.println("-------------------->TEST - testUpdateFile");

        ContentInterventoRequestBean req = new ContentInterventoRequestBean();
        req.setIntervento(workableBean.getIntervento());
        req.setPosizione(workableBean.getPosizione());
        req.setDataIntervento(Tools.drupalStringDateToDate(workableBean.getDataIntervento()));
        req.setDescrizione(workableBean.getDescrizione());
        req.setFk(workableBean.getFk());
        req.setTitle(workableBean.getTitle());
        req.setUuid(workableBean.getUuid());

        GenericFile gf = new GenericFile();
        gf.setUuid(workableFile.getUuid());
        gf.setDescription(workableFile.getDescription());
        req.setAllegato(gf);

        InterventoClient client = new InterventoClient(req);
        try{
            client.patchUpdateContentFile("field_allegato", gf);
        }catch (Exception e){
            System.out.println(e);
            check = false;
        }

        Assert.assertTrue(check);
        System.out.println("-------------------->TEST - testUpdate - Result: "+ check);
    }


}
