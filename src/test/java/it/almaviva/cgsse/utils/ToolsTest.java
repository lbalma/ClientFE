package it.almaviva.cgsse.utils;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class ToolsTest {

    @Test
    public void test1() throws ParseException {
        Date now = new Date();
        String drupalDate = Tools.dateToDrupalStringDate(now);
        Date now2 = Tools.drupalStringDateToDate(drupalDate);

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(now);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(now2);
        cal2.set(Calendar.HOUR_OF_DAY, 0);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.SECOND, 0);
        cal2.set(Calendar.MILLISECOND, 0);

        Assert.assertTrue(cal1.equals(cal2));
    }

}
