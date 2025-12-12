package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    // Load only once
    public static void loadProperties() {
        if (properties == null) {
            properties = new Properties();
            try (FileInputStream fis = new FileInputStream("src/test/resources/Config/config.properties")) {
                properties.load(fis);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load config.properties", e);
            }
        }
    }

    // Property fetcher — system property override added
    public static String getProperty(String key) {
        if (properties == null) {
            loadProperties();
        }



        // fallback to config.properties
        return properties.getProperty(key);
    }
}