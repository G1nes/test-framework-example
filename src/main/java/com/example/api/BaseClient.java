package com.example.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public abstract class BaseClient {

    protected <T> T get(String endpoint,
                        Class<T> responseClass) {
        return createDefaultSpec()
                .get(endpoint)
                .as(responseClass);
    }

    protected Response get(String endpoint) {
        return createDefaultSpec().get(endpoint);
    }

    protected <T> T post(String endpoint,
                         Object body,
                         Class<T> responseClass) {
        return createDefaultSpec()
                .body(body)
                .post(endpoint)
                .as(responseClass);
    }

    protected void delete(String endpoint) {
        createDefaultSpec().delete(endpoint);
    }

    private RequestSpecification createDefaultSpec() {
        return given()
                .contentType(ContentType.JSON)
                .headers(Map.of("Authorization", System.getenv("TOKEN")));
    }
}
