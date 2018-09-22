package mva.api.taller.bodega.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UtilsProperties {
    public static Properties getDatabaseProperties() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("resources/properties/config.properties");
        Properties properties = new Properties();
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }



}
