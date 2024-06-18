package ru.inno.tests.selenide.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final String CONFIG_FILE = "src/test/resources/config.properties";
    private static Properties properties = new Properties();

    static {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}