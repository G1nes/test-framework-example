package com.example.ui.pages.shopping.elements;

import com.codeborne.selenide.SelenideElement;

public class DataPopper {

    private final SelenideElement element;

    private final SelenideElement deleteButton;
    public DataPopper(SelenideElement element) {
        this.element = element;
        deleteButton = element.$x(".//button[@data-testid='shopping-list-delete-menu-button']");
    }

    public DeleteShoppingListConfirmationModalWindow deleteList() {
        deleteButton.click();
        return new DeleteShoppingListConfirmationModalWindow();
    }
}
