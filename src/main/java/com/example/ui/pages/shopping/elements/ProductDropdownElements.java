package com.example.ui.pages.shopping.elements;

import com.codeborne.selenide.*;

public class ProductDropdownElements {

    private final ElementsCollection elements;

    public ProductDropdownElements(ElementsCollection elements) {
        this.elements = elements;
    }

    public void selectProductByName(String productName) {
        findProductElementByName(productName).click();
    }

    private SelenideElement findProductElementByName(String productName) {
        return elements.asDynamicIterable()
                .stream()
                .filter(element -> productName.equals(element.$x(".//span").getText()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Can't find product with name " + productName));
    }
}
