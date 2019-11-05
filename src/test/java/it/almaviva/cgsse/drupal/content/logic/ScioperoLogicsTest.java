package it.almaviva.cgsse.drupal.content.logic;

import it.almaviva.cgsse.bo.bean.content.ContentInterventoBOBean;
import it.almaviva.cgsse.bo.bean.content.ContentScioperoBOBean;
import it.almaviva.cgsse.drupal.content.bean.GenericFile;
import it.almaviva.cgsse.drupal.content.bean.intervento.ContentInterventoRequestBean;
import it.almaviva.cgsse.drupal.content.bean.sciopero.ContentScioperoRequestBean;
import it.almaviva.cgsse.utils.Tools;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

public class ScioperoLogicsTest {
    @Test
    public void test() throws Exception {
        //INIT
        ScioperoLogics logics = new ScioperoLogics();

        ContentScioperoRequestBean insert = new ContentScioperoRequestBean();
        insert.setFk("4");
        insert.setPosizione("12");
        insert.setTitle("Titolo Sciopero");
        insert.setControparte("Cotnro parte");
        insert.setInizio("2019-10-01");
        insert.setFine("2019-10-01");
        insert.setDifferito(false);
        insert.setRevocato(false);

        List<ContentInterventoRequestBean> interventi = new LinkedList<>();
        File f = new File("/home/luca/Scaricati/Scioperi.pdf");
        ContentInterventoRequestBean intervento = new ContentInterventoRequestBean();
        intervento.setIntervento("Logic Intrevento");
        intervento.setPosizione("POS");
        intervento.setTitle("Logic Title");
        intervento.setDataIntervento("2019-10-01");
        intervento.setDescrizione("From logic");
        intervento.setFk("98");
        GenericFile allegato = new GenericFile();
        allegato.setFile(Files.readAllBytes(f.toPath()));
        allegato.setName("Prova.pdf");
        allegato.setDescription("Descrizione del pdf");
        intervento.setAllegato(allegato);
        interventi.add(intervento);
        insert.setInterventi(interventi);


        //GET ALL
        System.out.println("=== RUN GetAll ===");
        List<ContentScioperoBOBean> resList =  logics.execGetAll();
        System.out.println(resList);

        //INSERT - Complete
        System.out.println("=== RUN Insert - Complete ===");
        Boolean status= logics.execInsert(insert);
        System.out.println(status);

        //GET BY FK
        System.out.println("=== RUN GetByFk: fk: "+ insert.getFk()+ " ===");
        resList =  logics.execGetByFK(insert.getFk());
        System.out.println(resList);
        Assert.assertTrue(insert.getFk().equals(resList.get(0).getFk()));
        Assert.assertTrue(insert.getPosizione().equals(resList.get(0).getPosizione()));
        Assert.assertTrue(insert.getTitle().equals(resList.get(0).getTitle()));
        Assert.assertTrue(insert.getControparte().equals(resList.get(0).getControparte()));
        Assert.assertTrue(Tools.drupalStringDateToDate(insert.getInizio()).equals(resList.get(0).getInizio()));
        Assert.assertTrue(Tools.drupalStringDateToDate(insert.getFine()).equals(resList.get(0).getFine()));
        Assert.assertTrue(insert.getDifferito().equals(resList.get(0).getDifferito()));
        Assert.assertTrue(insert.getRevocato().equals(resList.get(0).getRevocato()));
        Assert.assertTrue(insert.getInterventi().get(0).getIntervento().equals(resList.get(0).getInterventi().get(0).getIntervento()));
        Assert.assertTrue(insert.getInterventi().get(0).getPosizione().equals(resList.get(0).getInterventi().get(0).getPosizione()));
        Assert.assertTrue(insert.getInterventi().get(0).getTitle().equals(resList.get(0).getInterventi().get(0).getTitle()));
        Assert.assertTrue(Tools.drupalStringDateToDate(insert.getInterventi().get(0).getDataIntervento()).equals(resList.get(0).getInterventi().get(0).getDataIntervento()));
        Assert.assertTrue(insert.getInterventi().get(0).getDescrizione().equals(resList.get(0).getInterventi().get(0).getDescrizione()));
        Assert.assertTrue(insert.getInterventi().get(0).getFk().equals(resList.get(0).getInterventi().get(0).getFk()));


        //EDIT - Complte
        insert.setPosizione("12-EDIT");
        insert.setTitle("Titolo Sciopero-EDIT");
        insert.setControparte("Cotnro parte-EDIT");
        insert.setInizio("2019-10-02");
        insert.setFine("2019-10-02");
        insert.setDifferito(true);
        insert.setRevocato(true);
        interventi = new LinkedList<>();
        intervento.setIntervento("Logic Intrevento - EDIT");
        intervento.setPosizione("POS - EDIT");
        intervento.setTitle("Logic Title - EDIT");
        f = new File("/home/luca/Scaricati/pdf-test.pdf");
        allegato = new GenericFile();
        allegato.setFile(Files.readAllBytes(f.toPath()));
        allegato.setName("pdf-test.pdf");
        allegato.setDescription("Descrizione del pdf");
        intervento.setAllegato(allegato);
        interventi.add(intervento);
        insert.setInterventi(interventi);

        System.out.println("=== RUN edit - Complete ===");
        status =  logics.execEdit(insert);
        System.out.println(status);

        //GET BY FK -EDITED
        System.out.println("=== RUN GetByFk -EDITED: fk: "+ insert.getFk()+ " ===");
        resList =  logics.execGetByFK(insert.getFk());
        System.out.println(resList);
        Assert.assertTrue(insert.getFk().equals(resList.get(0).getFk()));
        Assert.assertTrue(insert.getPosizione().equals(resList.get(0).getPosizione()));
        Assert.assertTrue(insert.getTitle().equals(resList.get(0).getTitle()));
        Assert.assertTrue(insert.getControparte().equals(resList.get(0).getControparte()));
        Assert.assertTrue(Tools.drupalStringDateToDate(insert.getInizio()).equals(resList.get(0).getInizio()));
        Assert.assertTrue(Tools.drupalStringDateToDate(insert.getFine()).equals(resList.get(0).getFine()));
        Assert.assertTrue(insert.getDifferito().equals(resList.get(0).getDifferito()));
        Assert.assertTrue(insert.getRevocato().equals(resList.get(0).getRevocato()));
        Assert.assertTrue(insert.getInterventi().get(0).getIntervento().equals(resList.get(0).getInterventi().get(0).getIntervento()));
        Assert.assertTrue(insert.getInterventi().get(0).getPosizione().equals(resList.get(0).getInterventi().get(0).getPosizione()));
        Assert.assertTrue(insert.getInterventi().get(0).getTitle().equals(resList.get(0).getInterventi().get(0).getTitle()));
        Assert.assertTrue(Tools.drupalStringDateToDate(insert.getInterventi().get(0).getDataIntervento()).equals(resList.get(0).getInterventi().get(0).getDataIntervento()));
        Assert.assertTrue(insert.getInterventi().get(0).getDescrizione().equals(resList.get(0).getInterventi().get(0).getDescrizione()));
        Assert.assertTrue(insert.getInterventi().get(0).getFk().equals(resList.get(0).getInterventi().get(0).getFk()));

        //DEL
        System.out.println("=== RUN Del ===");
        status =  logics.execDeleteByFK(insert.getFk());
        System.out.println(status);

        //INSERT - No Interventi
        System.out.println("=== RUN Insert - No Interventi ===");
        insert.setUuid(null);
        insert.setInterventi(new LinkedList<>());
        status = logics.execInsert(insert);
        System.out.println(status);


        //GET BY FK - No Interventi
        System.out.println("=== RUN GetByFk - No Interventi : fk: "+ insert.getFk()+ " ===");
        resList =  logics.execGetByFK(insert.getFk());
        System.out.println(resList);
        Assert.assertTrue(insert.getFk().equals(resList.get(0).getFk()));
        Assert.assertTrue(insert.getPosizione().equals(resList.get(0).getPosizione()));
        Assert.assertTrue(insert.getTitle().equals(resList.get(0).getTitle()));
        Assert.assertTrue(insert.getControparte().equals(resList.get(0).getControparte()));
        Assert.assertTrue(Tools.drupalStringDateToDate(insert.getInizio()).equals(resList.get(0).getInizio()));
        Assert.assertTrue(Tools.drupalStringDateToDate(insert.getFine()).equals(resList.get(0).getFine()));
        Assert.assertTrue(insert.getDifferito().equals(resList.get(0).getDifferito()));
        Assert.assertTrue(insert.getRevocato().equals(resList.get(0).getRevocato()));


        //EDIT - No Interventi
        insert.setPosizione("12-EDIT2");
        insert.setTitle("Titolo Sciopero-EDIT2");
        insert.setControparte("Cotnro parte-EDIT2");
        insert.setInizio("2019-10-03");
        insert.setFine("2019-10-03");
        insert.setDifferito(true);
        insert.setRevocato(false);
        intervento.setIntervento("Logic Intrevento - EDIT2");
        intervento.setPosizione("POS - EDIT2");
        intervento.setTitle("Logic Title - EDIT2");

        System.out.println("=== RUN edit - No Interventi ===");
        status =  logics.execEdit(insert);
        System.out.println(status);


        //GET BY FK -EDITED - No Interventi
        System.out.println("=== RUN GetByFk -EDITED - No Interventi: fk: "+ insert.getFk()+ " ===");
        resList =  logics.execGetByFK(insert.getFk());
        System.out.println(resList);
        Assert.assertTrue(insert.getFk().equals(resList.get(0).getFk()));
        Assert.assertTrue(insert.getPosizione().equals(resList.get(0).getPosizione()));
        Assert.assertTrue(insert.getTitle().equals(resList.get(0).getTitle()));
        Assert.assertTrue(insert.getControparte().equals(resList.get(0).getControparte()));
        Assert.assertTrue(Tools.drupalStringDateToDate(insert.getInizio()).equals(resList.get(0).getInizio()));
        Assert.assertTrue(Tools.drupalStringDateToDate(insert.getFine()).equals(resList.get(0).getFine()));
        Assert.assertTrue(insert.getDifferito().equals(resList.get(0).getDifferito()));
        Assert.assertTrue(insert.getRevocato().equals(resList.get(0).getRevocato()));

        //DEL
        System.out.println("=== RUN Del ===");
        status =  logics.execDeleteByFK(insert.getFk());
        System.out.println(status);
    }
}
