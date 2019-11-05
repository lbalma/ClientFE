package it.almaviva.cgsse.drupal.content.logic;

import it.almaviva.cgsse.bo.bean.content.ContentInterventoBOBean;
import it.almaviva.cgsse.drupal.content.bean.GenericFile;
import it.almaviva.cgsse.drupal.content.bean.intervento.ContentInterventoRequestBean;
import it.almaviva.cgsse.utils.Tools;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class InterventoLogicsTest {
    @Test
    public void test() throws Exception {
        //INIT
        InterventoLogics logics = new InterventoLogics();
        File f = new File("/home/luca/Scaricati/Scioperi.pdf");

        ContentInterventoRequestBean insert = new ContentInterventoRequestBean();
        insert.setIntervento("Logic Intrevento");
        insert.setPosizione("POS");
        insert.setTitle("Logic Title");
        insert.setDataIntervento("2019-10-01");
        insert.setDescrizione("From logic");
        insert.setFk("98");
        GenericFile allegato = new GenericFile();
        allegato.setFile(Files.readAllBytes(f.toPath()));
        allegato.setName("Prova.pdf");
        allegato.setDescription("Descrizione del pdf");

        insert.setAllegato(allegato);


        //GET ALL
        System.out.println("=== RUN GetAll ===");
        List<ContentInterventoBOBean> resList =  logics.execGetAll();
        System.out.println(resList);

        //INSERT - Complete
        System.out.println("=== RUN Insert - Complete ===");
        Boolean status= logics.execInsert(insert);
        System.out.println(status);

        //GET BY FK
        System.out.println("=== RUN GetByFk: fk: "+ insert.getFk()+ " ===");
        resList =  logics.execGetByFK(insert.getFk());
        System.out.println(resList);
        Assert.assertTrue(insert.getIntervento().equals(resList.get(0).getIntervento()));
        Assert.assertTrue(insert.getPosizione().equals(resList.get(0).getPosizione()));
        Assert.assertTrue(insert.getTitle().equals(resList.get(0).getTitle()));
        Assert.assertTrue(Tools.drupalStringDateToDate(insert.getDataIntervento()).equals(resList.get(0).getDataIntervento()));
        Assert.assertTrue(insert.getDescrizione().equals(resList.get(0).getDescrizione()));
        Assert.assertTrue(insert.getFk().equals(resList.get(0).getFk()));

        //EDIT - Complte
        System.out.println("=== RUN edit - Complete ===");
        insert.setIntervento("Logic Intrevento - EDIT");
        insert.setPosizione("POS - EDIT");
        insert.setTitle("Logic Title - EDIT");
        f = new File("/home/luca/Scaricati/pdf-test.pdf");
        allegato = new GenericFile();
        allegato.setFile(Files.readAllBytes(f.toPath()));
        allegato.setName("pdf-test.pdf");
        allegato.setDescription("Descrizione del pdf");
        insert.setAllegato(allegato);

        status =  logics.execEdit(insert);
        System.out.println(status);

        //GET BY FK -EDITED
        System.out.println("=== RUN GetByFk -EDITED: fk: "+ insert.getFk()+ " ===");
        resList =  logics.execGetByFK(insert.getFk());
        System.out.println(resList);
        Assert.assertTrue(insert.getIntervento().equals(resList.get(0).getIntervento()));
        Assert.assertTrue(insert.getPosizione().equals(resList.get(0).getPosizione()));
        Assert.assertTrue(insert.getTitle().equals(resList.get(0).getTitle()));
        Assert.assertTrue(Tools.drupalStringDateToDate(insert.getDataIntervento()).equals(resList.get(0).getDataIntervento()));
        Assert.assertTrue(insert.getDescrizione().equals(resList.get(0).getDescrizione()));
        Assert.assertTrue(insert.getFk().equals(resList.get(0).getFk()));

        //DEL
        System.out.println("=== RUN Del ===");
        status =  logics.execDeleteByFK(insert.getFk());
        System.out.println(status);


        //INSERT - No File
        System.out.println("=== RUN Insert - No File ===");
        insert.setUuid(null);
        insert.setAllegato(new GenericFile());
        status = logics.execInsert(insert);
        System.out.println(status);

        //GET BY FK -Insert No file
        System.out.println("=== RUN GetByFk -INSERT no file: fk: "+ insert.getFk()+ " ===");
        resList =  logics.execGetByFK(insert.getFk());
        System.out.println(resList);
        Assert.assertTrue(insert.getIntervento().equals(resList.get(0).getIntervento()));
        Assert.assertTrue(insert.getPosizione().equals(resList.get(0).getPosizione()));
        Assert.assertTrue(insert.getTitle().equals(resList.get(0).getTitle()));
        Assert.assertTrue(Tools.drupalStringDateToDate(insert.getDataIntervento()).equals(resList.get(0).getDataIntervento()));
        Assert.assertTrue(insert.getDescrizione().equals(resList.get(0).getDescrizione()));
        Assert.assertTrue(insert.getFk().equals(resList.get(0).getFk()));

        //EDIT - NO FIle
        System.out.println("=== RUN Edit - No File ===");
        insert.setIntervento("Logic Intrevento - EDIT2");
        insert.setPosizione("POS - EDIT2");
        insert.setTitle("Logic Title - EDIT2");

        status =  logics.execEdit(insert);
        System.out.println(status);

        //GET BY FK -EDITED No file
        System.out.println("=== RUN GetByFk -EDITED no file: fk: "+ insert.getFk()+ " ===");
        resList =  logics.execGetByFK(insert.getFk());
        System.out.println(resList);
        Assert.assertTrue(insert.getIntervento().equals(resList.get(0).getIntervento()));
        Assert.assertTrue(insert.getPosizione().equals(resList.get(0).getPosizione()));
        Assert.assertTrue(insert.getTitle().equals(resList.get(0).getTitle()));
        Assert.assertTrue(Tools.drupalStringDateToDate(insert.getDataIntervento()).equals(resList.get(0).getDataIntervento()));
        Assert.assertTrue(insert.getDescrizione().equals(resList.get(0).getDescrizione()));
        Assert.assertTrue(insert.getFk().equals(resList.get(0).getFk()));


        //DEL
        System.out.println("=== RUN Del ===");
        status =  logics.execDeleteByFK(insert.getFk());
        System.out.println(status);

    }
}
