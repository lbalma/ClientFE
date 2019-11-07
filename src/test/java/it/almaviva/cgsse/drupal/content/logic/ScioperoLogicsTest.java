package it.almaviva.cgsse.drupal.content.logic;

import it.almaviva.cgsse.bo.bean.content.ContentScioperoBOBean;
import it.almaviva.cgsse.drupal.content.bean.GenericFile;
import it.almaviva.cgsse.drupal.content.bean.intervento.ContentInterventoRequestBean;
import it.almaviva.cgsse.drupal.content.bean.sciopero.ContentScioperoRequestBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.azienda.TaxonomyAziendaRequestBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.rilevanza.TaxonomyRilevanzaRequestBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.settore.TaxonomySettoreRequestBean;
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
        insert.setFk("44");
        insert.setPosizione("12");
        insert.setTitle("Titolo Sciopero H ");
        insert.setControparte("Cotnro parte");
        insert.setInizio(Tools.drupalStringDateToDate("2019-10-01"));
        insert.setFine(Tools.drupalStringDateToDate("2019-10-01"));
        insert.setDifferito(false);
        insert.setRevocato(false);

        TaxonomyRilevanzaRequestBean rilvanza = new TaxonomyRilevanzaRequestBean();
        rilvanza.setFk("1");
        insert.setRilevanza(rilvanza);
        TaxonomySettoreRequestBean settore = new TaxonomySettoreRequestBean();
        settore.setFk("1");
        insert.setSettore(settore);
        TaxonomyAziendaRequestBean azienda = new TaxonomyAziendaRequestBean();
        azienda.setFk("1");
        insert.setAzienda(azienda);

        List<ContentInterventoRequestBean> interventi = new LinkedList<>();
        File f = new File("/home/luca/Scaricati/Scioperi.pdf");
        ContentInterventoRequestBean intervento = new ContentInterventoRequestBean();
        intervento.setIntervento("Logic Intrevento");
        intervento.setPosizione("POS");
        intervento.setTitle("Logic Title");
        intervento.setDataIntervento(Tools.drupalStringDateToDate("2019-10-01"));
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
        Assert.assertTrue(insert.getInizio().equals(resList.get(0).getInizio()));
        Assert.assertTrue(insert.getFine().equals(resList.get(0).getFine()));
        Assert.assertTrue(insert.getDifferito().equals(resList.get(0).getDifferito()));
        Assert.assertTrue(insert.getRevocato().equals(resList.get(0).getRevocato()));
        Assert.assertTrue(insert.getInterventi().get(0).getIntervento().equals(resList.get(0).getInterventi().get(0).getIntervento()));
        Assert.assertTrue(insert.getInterventi().get(0).getPosizione().equals(resList.get(0).getInterventi().get(0).getPosizione()));
        Assert.assertTrue(insert.getInterventi().get(0).getTitle().equals(resList.get(0).getInterventi().get(0).getTitle()));
        Assert.assertTrue(insert.getInterventi().get(0).getDataIntervento().equals(resList.get(0).getInterventi().get(0).getDataIntervento()));
        Assert.assertTrue(insert.getInterventi().get(0).getDescrizione().equals(resList.get(0).getInterventi().get(0).getDescrizione()));
        Assert.assertTrue(insert.getInterventi().get(0).getFk().equals(resList.get(0).getInterventi().get(0).getFk()));

        Assert.assertTrue(insert.getAzienda().getFk().equals(resList.get(0).getAzienda().getFk()));
        Assert.assertTrue(insert.getSettore().getFk().equals(resList.get(0).getSettore().getFk()));
        Assert.assertTrue(insert.getRilevanza().getFk().equals(resList.get(0).getRilevanza().getFk()));

        //EDIT - Complte
        insert.setPosizione("12-EDIT");
        insert.setTitle("Titolo Sciopero H -EDIT");
        insert.setControparte("Cotnro parte-EDIT");
        insert.setInizio(Tools.drupalStringDateToDate("2019-10-02"));
        insert.setFine(Tools.drupalStringDateToDate("2019-10-02"));
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

        rilvanza = new TaxonomyRilevanzaRequestBean();
        rilvanza.setFk("6");
        insert.setRilevanza(rilvanza);
        settore = new TaxonomySettoreRequestBean();
        settore.setFk("3");
        insert.setSettore(settore);
        azienda = new TaxonomyAziendaRequestBean();
        azienda.setFk("4");
        insert.setAzienda(azienda);

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
        Assert.assertTrue(insert.getInizio().equals(resList.get(0).getInizio()));
        Assert.assertTrue(insert.getFine().equals(resList.get(0).getFine()));
        Assert.assertTrue(insert.getDifferito().equals(resList.get(0).getDifferito()));
        Assert.assertTrue(insert.getRevocato().equals(resList.get(0).getRevocato()));
        Assert.assertTrue(insert.getInterventi().get(0).getIntervento().equals(resList.get(0).getInterventi().get(0).getIntervento()));
        Assert.assertTrue(insert.getInterventi().get(0).getPosizione().equals(resList.get(0).getInterventi().get(0).getPosizione()));
        Assert.assertTrue(insert.getInterventi().get(0).getTitle().equals(resList.get(0).getInterventi().get(0).getTitle()));
        Assert.assertTrue(insert.getInterventi().get(0).getDataIntervento().equals(resList.get(0).getInterventi().get(0).getDataIntervento()));
        Assert.assertTrue(insert.getInterventi().get(0).getDescrizione().equals(resList.get(0).getInterventi().get(0).getDescrizione()));
        Assert.assertTrue(insert.getInterventi().get(0).getFk().equals(resList.get(0).getInterventi().get(0).getFk()));

        Assert.assertTrue(insert.getAzienda().getFk().equals(resList.get(0).getAzienda().getFk()));
        Assert.assertTrue(insert.getSettore().getFk().equals(resList.get(0).getSettore().getFk()));
        Assert.assertTrue(insert.getRilevanza().getFk().equals(resList.get(0).getRilevanza().getFk()));

        //DEL
        System.out.println("=== RUN Del ===");
        status =  logics.execDeleteByFK(insert.getFk());
        System.out.println(status);

        //INSERT - No Interventi
        System.out.println("=== RUN Insert - No Interventi ===");
        insert.setUuid(null);
        insert.setInterventi(new LinkedList<>());
        rilvanza = new TaxonomyRilevanzaRequestBean();
        rilvanza.setFk("1");
        insert.setRilevanza(rilvanza);
        settore = new TaxonomySettoreRequestBean();
        settore.setFk("1");
        insert.setSettore(settore);
        azienda = new TaxonomyAziendaRequestBean();
        azienda.setFk("1");
        insert.setAzienda(azienda);
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
        Assert.assertTrue(insert.getInizio().equals(resList.get(0).getInizio()));
        Assert.assertTrue(insert.getFine().equals(resList.get(0).getFine()));
        Assert.assertTrue(insert.getDifferito().equals(resList.get(0).getDifferito()));
        Assert.assertTrue(insert.getRevocato().equals(resList.get(0).getRevocato()));
        Assert.assertTrue(insert.getAzienda().getFk().equals(resList.get(0).getAzienda().getFk()));
        Assert.assertTrue(insert.getSettore().getFk().equals(resList.get(0).getSettore().getFk()));
        Assert.assertTrue(insert.getRilevanza().getFk().equals(resList.get(0).getRilevanza().getFk()));


        //EDIT - No Interventi
        insert.setPosizione("12-EDIT2");
        insert.setTitle("Titolo Sciopero-EDIT2");
        insert.setControparte("Cotnro parte-EDIT2");
        insert.setInizio(Tools.drupalStringDateToDate("2019-10-03"));
        insert.setFine(Tools.drupalStringDateToDate("2019-10-03"));
        insert.setDifferito(true);
        insert.setRevocato(false);
        intervento.setIntervento("Logic Intrevento - EDIT2");
        intervento.setPosizione("POS - EDIT2");
        intervento.setTitle("Logic Title - EDIT2");
        settore = new TaxonomySettoreRequestBean();
        settore.setFk("3");
        insert.setSettore(settore);
        azienda = new TaxonomyAziendaRequestBean();
        azienda.setFk("4");
        insert.setAzienda(azienda);

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
        Assert.assertTrue(insert.getInizio().equals(resList.get(0).getInizio()));
        Assert.assertTrue(insert.getFine().equals(resList.get(0).getFine()));
        Assert.assertTrue(insert.getDifferito().equals(resList.get(0).getDifferito()));
        Assert.assertTrue(insert.getRevocato().equals(resList.get(0).getRevocato()));
        Assert.assertTrue(insert.getAzienda().getFk().equals(resList.get(0).getAzienda().getFk()));
        Assert.assertTrue(insert.getSettore().getFk().equals(resList.get(0).getSettore().getFk()));
        Assert.assertTrue(insert.getRilevanza().getFk().equals(resList.get(0).getRilevanza().getFk()));

        //DEL
        System.out.println("=== RUN Del ===");
        status =  logics.execDeleteByFK(insert.getFk());
        System.out.println(status);
    }
}
