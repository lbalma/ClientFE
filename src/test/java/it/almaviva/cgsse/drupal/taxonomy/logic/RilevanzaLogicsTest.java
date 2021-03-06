package it.almaviva.cgsse.drupal.taxonomy.logic;

import it.almaviva.cgsse.bo.bean.taxonomy.TaxonomyRilevanzaBOBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.rilevanza.TaxonomyRilevanzaRequestBean;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class RilevanzaLogicsTest {
    @Test
    public void test() throws Exception {
        //INIT
        RilevanzaLogics logics = new RilevanzaLogics();

        TaxonomyRilevanzaRequestBean insert = new TaxonomyRilevanzaRequestBean();
        insert.setName("Logic Rilevanza");
        insert.setFk("98");

        //GET ALL
        System.out.println("=== RUN GetAll ===");
        List<TaxonomyRilevanzaBOBean> resList =  logics.execGetAll();
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
        insert.setName("Logic Rilevanza - EDIT");

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
