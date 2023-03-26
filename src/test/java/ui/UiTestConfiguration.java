package ui;

import ui.configuration.PropertiesLoader;
import ui.configuration.SelenideConfiguration;

import java.util.Properties;

public class UiTestConfiguration {

    private final static Properties PROPS = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        String pathToProperties = "src/test/resources/ui_tests.properties";
        PropertiesLoader loader = new PropertiesLoader(PROPS,
                                                       pathToProperties);
        loader.load();
    }

    static void configure() {
        new SelenideConfiguration(PROPS).configure();
    }
}
