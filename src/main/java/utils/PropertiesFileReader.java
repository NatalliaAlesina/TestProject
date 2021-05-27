package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

    public final static String FILE_PATH = "src/main/resources/hosts/urls.properties";

    private static Properties readUrlsProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read host properties file: " + e.getMessage(), e);
        }
        return properties;
    }

    public static String getRemoteDriverUrl() {
        return readUrlsProperties().getProperty("remoteDriver");
    }

    public static String getWebSiteUrl() {
        return readUrlsProperties().getProperty("website");
    }
}
