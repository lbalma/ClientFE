package it.almaviva.cgsse.utils;

import org.junit.Test;

import java.io.IOException;

public class PropertiesManagerTest {

    @Test
    public void loadFile() throws IOException {
       PropertiesManager.getInstance();
    }

    @Test
    public void getProperties() throws IOException {
        String value = PropertiesManager.getInstance().getValue(PropertiesManager.FE_IP);
    }

    @Test
    public void getUrlFEService() throws IOException {

        String FE_PROTOCOL = PropertiesManager.getInstance().getValue(PropertiesManager.FE_PROTOCOL);
        String FE_IP = PropertiesManager.getInstance().getValue(PropertiesManager.FE_IP);
        String FE_PORT = PropertiesManager.getInstance().getValue(PropertiesManager.FE_PORT);
        String FE_DOMAIN = PropertiesManager.getInstance().getValue(PropertiesManager.FE_DOMAIN);
        String FE_TAXONOMY_SERVICE = PropertiesManager.getInstance().getValue(PropertiesManager.FE_TAXONOMY_SERVICE);

        System.out.println(FE_PROTOCOL + " " + FE_IP+ " " + FE_PORT + " "+ FE_DOMAIN + " "+ FE_TAXONOMY_SERVICE);
    }
}
