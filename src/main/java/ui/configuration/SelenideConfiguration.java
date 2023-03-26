package ui.configuration;

import com.codeborne.selenide.Configuration;

import java.util.Properties;

public class SelenideConfiguration {

    private final Properties properties;

    public SelenideConfiguration(Properties properties) {
        this.properties = properties;
    }

    public void configure() {
        Configuration.baseUrl = properties.getProperty("browser.url");
        Configuration.browserSize = properties.getProperty("browser.resolution");
        Configuration.timeout = Long.parseLong(properties.getProperty("browser.millis_timeout"));
    }
}
