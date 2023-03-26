package com.example.ui;

import com.example.TestConfiguration;
import com.example.ui.configuration.SelenideConfiguration;

public class UiTestConfiguration extends TestConfiguration {

    @Override
    public void configure() {
        new SelenideConfiguration(PROPS).configure();
    }

    @Override
    protected String getConfigurationFilePath() {
        return "src/test/resources/ui_tests.properties";
    }
}
