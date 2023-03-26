package com.example.ui.pages;

import com.codeborne.selenide.SelenideElement;
import com.example.ui.pages.explore.ExplorePage;
import com.example.ui.pages.shopping.ShoppingPage;

import static com.codeborne.selenide.Selenide.$x;

public abstract class MenuPage {

    private final SelenideElement explorePage;
    private final SelenideElement shoppingPage;

    protected MenuPage() {
        explorePage = $x("//div[@data-testid='explore-nav-link']");
        shoppingPage = $x("//div[@data-testid='shopping-list-nav-link']");
    }

    public  <T> T navigateToPage(Class<T> pageClass) {
        if (pageClass.isAssignableFrom(ExplorePage.class)) {
            explorePage.click();
            return (T) new ExplorePage();
        }
        if (pageClass.isAssignableFrom(ShoppingPage.class)) {
            shoppingPage.click();
            return (T) new ShoppingPage();
        }
        throw new IllegalArgumentException("Wrong page type " + pageClass.getName());
    }
}
