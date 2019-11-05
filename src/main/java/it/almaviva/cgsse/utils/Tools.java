package it.almaviva.cgsse.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {
    private static DateFormat drupalDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static String dateToDrupalStringDate(Date date) throws NullPointerException{
        if(date != null){
            return drupalDateFormat.format(date);
        }else{
            return "";
        }
    }

    public static Date drupalStringDateToDate(String drupalDate) throws ParseException {
        if(drupalDate != null){
            try{
                return drupalDateFormat.parse(drupalDate);
            }catch(ParseException exc){
                System.out.println("Format accpet: "+ drupalDateFormat.toString());
                throw exc;
            }
        }else{
            throw new NullPointerException();
        }
    }
}
