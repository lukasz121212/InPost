package pl.inpost.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Properties;

public class ConfigReader {

    private ConfigReader() {
    }
    private static final Properties properties;

    static {
        try {
            properties = new Properties();
            FileInputStream file = new FileInputStream("src/main/resources/config.properties");
            properties.load(file);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to load config file", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static String getBaseUrl() {
        String env = System.getProperty("env", properties.getProperty("env"));
        return properties.getProperty(env + ".url");
    }
}
