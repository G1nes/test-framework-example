package com.example.ui.pages.home;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class UnauthorizedHomePage {
    private final SelenideElement logInButton;

    public UnauthorizedHomePage() {
        logInButton = $x("//div[contains(text(), 'Log In')]");
    }

    public SelectAuthorizationOptionWindow clickLogin(){
        logInButton.click();
        return new SelectAuthorizationOptionWindow();
    }
}
