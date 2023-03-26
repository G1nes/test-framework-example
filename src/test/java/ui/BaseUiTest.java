package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;
import ui.dto.AuthorizationDto;

public abstract class BaseUiTest {

    protected static AuthorizationDto AUTHORIZATION;
    protected SoftAssertions soft = new SoftAssertions();

    @BeforeAll
    public static void init() {
        UiTestConfiguration.configure();
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
