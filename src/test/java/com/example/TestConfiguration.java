package com.example;

import com.example.util.PropertiesLoader;

import java.util.Properties;

public abstract class TestConfiguration {
    protected final Properties PROPS = new Properties();

    {
        loadProperties();
    }

    protected abstract void configure();

    protected abstract String getConfigurationFilePath();

    private void loadProperties() {
        String pathToProperties = getConfigurationFilePath();
        PropertiesLoader loader = new PropertiesLoader(PROPS,
                                                       pathToProperties);
        loader.load();
    }
}
