package com.example.ui.pages.home;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SelectAuthorizationOptionWindow {

    private final SelenideElement emailPhoneInput;
    private final SelenideElement continueButton;

    public SelectAuthorizationOptionWindow() {
        emailPhoneInput = $x("//input[@data-testid='UI_KIT_INPUT' and @placeholder='Email or phone number']");
        continueButton = $x("//div[@class='s11197' and contains(text(), 'Continue')]");
    }

    public SelectAuthorizationOptionWindow fillEmailOrPhoneNumber(String phoneNumber) {
        emailPhoneInput.setValue(phoneNumber);
        return this;
    }

    public EnterPasswordWindow pressContinue() {
        continueButton.click();
        return new EnterPasswordWindow();
    }
}
