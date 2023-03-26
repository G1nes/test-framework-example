package com.example.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.example.BaseTest;
import org.junit.jupiter.api.*;
import com.example.ui.dto.AuthorizationDto;

public abstract class BaseUiTest extends BaseTest {

    protected static AuthorizationDto AUTHORIZATION;
    @BeforeAll
    public static void init() {
        new UiTestConfiguration().configure();
        AUTHORIZATION = buildDefaultAuthorization();
    }

    @BeforeEach
    public void runBrowser() {
        Selenide.open(Configuration.baseUrl);
    }

    @AfterEach
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

    private static AuthorizationDto buildDefaultAuthorization() {
        return AuthorizationDto.builder()
                .email(System.getenv("USER_EMAIL"))
                .password(System.getenv("USER_PASSWORD"))
                .build();
    }
}
