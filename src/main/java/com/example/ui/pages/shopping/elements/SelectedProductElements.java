package com.example.ui.pages.shopping.elements;

import com.codeborne.selenide.ElementsCollection;
import org.awaitility.Awaitility;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SelectedProductElements {

    private final static int TIMEOUT_PRODUCT_IN_LIST_SECONDS = 3;
    private final ElementsCollection selectedProducts;

    public SelectedProductElements(ElementsCollection elements) {
        selectedProducts = elements;
    }

    public List<String> getSelectedProductNames() {
        return selectedProducts.asDynamicIterable()
                .stream()
                .map(product -> product.$x(".//span[@data-testid='shopping-list-item-name']").getText())
                .collect(Collectors.toList());
    }

    public void waitUntilProductWithNameAppears(String productName) {
        Awaitility.await()
                .pollInSameThread()
                .atMost(TIMEOUT_PRODUCT_IN_LIST_SECONDS, TimeUnit.SECONDS)
                .until(() -> getSelectedProductNames().contains(productName));
    }
}
