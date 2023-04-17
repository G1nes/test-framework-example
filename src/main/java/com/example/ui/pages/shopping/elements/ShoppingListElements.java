package com.example.ui.pages.shopping.elements;

import com.codeborne.selenide.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ShoppingListElements {
    private final ElementsCollection elements;

    public ShoppingListElements(ElementsCollection elements) {
        this.elements = elements;
    }

    public DataPopper clickThreeDotsOnLastCreatedShoppingList() {
        SelenideElement shoppingList = elements.asDynamicIterable()
                .stream()
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("There are no shopping lists"));
        shoppingList.$x(".//button[*[@data-testid='3dotsHorizontal']]").click();
        SelenideElement dataPopper = $("[data-popper-placement]");
        dataPopper.shouldBe(Condition.visible);
        return new DataPopper(dataPopper);
    }

    public List<String> getShoppingListNames() {
        return elements.asDynamicIterable()
                .stream()
                .map(element -> element.$x(".//div[@data-testid='shopping-lists-list-name']")
                        .getText())
                .collect(Collectors.toList());
    }
}
