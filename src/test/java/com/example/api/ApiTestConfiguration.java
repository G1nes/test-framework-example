package com.example.api;

import com.example.TestConfiguration;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;

public class ApiTestConfiguration extends TestConfiguration {

    @Override
    protected String getConfigurationFilePath() {
        return "src/test/resources/api_tests.properties";
    }

    @Override
    public void configure() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.config = RestAssuredConfig.config().objectMapperConfig(getMapperConfig());
        RestAssured.baseURI = PROPS.getProperty("url");
    }

    private static ObjectMapperConfig getMapperConfig() {
        return new ObjectMapperConfig().jackson2ObjectMapperFactory((cls, charset) -> new ObjectMapper()
                .findAndRegisterModules()
                .configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true));
    }
}
