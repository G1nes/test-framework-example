package com.example.ui.pages.shopping.elements;

import com.codeborne.selenide.SelenideElement;
import com.example.ui.pages.shopping.ShoppingPage;

import static com.codeborne.selenide.Selenide.$x;

public class CreateListWindow {

    private final SelenideElement createButton;

    public CreateListWindow() {
        createButton = $x("//div[@class='s11197' and contains(text(), 'Create')]");
    }

    public ShoppingPage createList() {
        createButton.click();
        return new ShoppingPage();
    }
}
