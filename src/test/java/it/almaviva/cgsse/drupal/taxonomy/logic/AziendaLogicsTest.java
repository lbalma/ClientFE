package it.almaviva.cgsse.drupal.taxonomy.logic;

import it.almaviva.cgsse.bo.bean.content.ContentInterventoBOBean;
import it.almaviva.cgsse.bo.bean.taxonomy.TaxonomyAziendaBOBean;
import it.almaviva.cgsse.drupal.content.bean.GenericFile;
import it.almaviva.cgsse.drupal.content.bean.intervento.ContentInterventoRequestBean;
import it.almaviva.cgsse.drupal.content.logic.InterventoLogics;
import it.almaviva.cgsse.drupal.taxonomy.bean.azienda.TaxonomyAziendaRequestBean;
import it.almaviva.cgsse.utils.Tools;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class AziendaLogicsTest {
    @Test
    public void test() throws Exception {
        //INIT
        AziendaLogics logics = new AziendaLogics();

        TaxonomyAziendaRequestBean insert = new TaxonomyAziendaRequestBean();
        insert.setName("Logic Azienda");
        insert.setFk("98");

        //GET ALL
        System.out.println("=== RUN GetAll ===");
        List<TaxonomyAziendaBOBean> resList =  logics.execGetAll();
        System.out.println(resList);

        //INSERT - Complete
        System.out.println("=== RUN Insert - Complete ===");
        Boolean status= logics.execInsert(insert);
        System.out.println(status);

        //GET BY FK
        System.out.println("=== RUN GetByFk: fk: "+ insert.getFk()+ " ===");
        resList =  logics.execGetByFK(insert.getFk());
        System.out.println(resList);
        Assert.assertTrue(insert.getName().equals(resList.get(0).getName()));
        Assert.assertTrue(insert.getFk().equals(resList.get(0).getFk()));

        //EDIT - Complte
        System.out.println("=== RUN edit - Complete ===");
        insert.setName("Logic Azienda - EDIT");

        status =  logics.execEdit(insert);
        System.out.println(status);

        //GET BY FK -EDITED
        System.out.println("=== RUN GetByFk -EDITED: fk: "+ insert.getFk()+ " ===");
        resList =  logics.execGetByFK(insert.getFk());
        System.out.println(resList);
        Assert.assertTrue(insert.getName().equals(resList.get(0).getName()));
        Assert.assertTrue(insert.getFk().equals(resList.get(0).getFk()));

        //DEL
        System.out.println("=== RUN Del ===");
        status =  logics.execDeleteByFK(insert.getFk());
        System.out.println(status);

    }
}
