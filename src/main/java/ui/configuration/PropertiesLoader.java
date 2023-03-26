package ui.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    private final Properties properties;
    private final String propertiesPath;

    public PropertiesLoader(Properties properties, String propertiesPath){
        this.properties = properties;
        this.propertiesPath = propertiesPath;
    }

    public void load() {
        try (FileInputStream fis = new FileInputStream(propertiesPath)) {
            properties.load(fis);
        } catch (IOException exception) {
            throw new RuntimeException("Failed to load test properties");
        }
    }
}
