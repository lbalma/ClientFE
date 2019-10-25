package it.almaviva.cgsse.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesManager extends KeyProperties {


    private static String fileName = "prop.properties";

    private static PropertiesManager istance = null;
    private Properties prop;

    private PropertiesManager() throws IOException {
        ClassLoader cLoader = getClass().getClassLoader();
        prop = new Properties();
        prop.load(cLoader.getResourceAsStream(fileName));
    }

    public static PropertiesManager getInstance() throws IOException {
        if (istance == null) {
            istance = new PropertiesManager();
        }
        return istance;
    }

    public String getValue(String key) {
        return prop.getProperty(key);
    }

    public Boolean getBooleanValue(String key) {
        return Boolean.valueOf(getValue(key));
    }
}