package it.almaviva.cgsse.utils;

import org.junit.Assert;
import org.junit.Test;

public class AESTest {

    @Test
    public void test1()
    {
        final String secretKey = "ssshhhhhhhhhhh!!!!";

        String originalString = "howtodoinjava.com";
        String encryptedString = AES.encrypt(originalString, secretKey) ;
        String decryptedString = AES.decrypt(encryptedString, secretKey) ;

        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);

        Assert.assertTrue(originalString.equals(decryptedString));
    }

}
