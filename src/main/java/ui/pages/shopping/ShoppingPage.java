package ui.pages.shopping;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ui.pages.MenuPage;
import ui.pages.shopping.elements.*;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ShoppingPage extends MenuPage {

    private final SelenideElement createShoppingListButton;
    private final SelenideElement addItemInput;
    private final ProductsDropdown productsDropdown;
    private final SelectedProductElements selectedProducts;
    private final ShoppingListElements shoppingLists;
    private final SelenideElement listDeletionNotificationPopup;

    public ShoppingPage() {
        createShoppingListButton = $x("//a[@data-testid='create-new-shopping-list-button']/div[@class='s11251']");
        addItemInput = $x("//input[@data-testid='desktop-add-item-autocomplete']");
        productsDropdown = new ProductsDropdown($x("//div[@data-testid='desktop-add-item-autocomplete']"));
        selectedProducts = new SelectedProductElements($$x("//div[@data-testid='shopping-list-item']"));
        shoppingLists = new ShoppingListElements($$x("//div[@class='s-1bihe2z jtfYez']"));
        listDeletionNotificationPopup = $x("//*[@data-testid='6ba614ad-462f-714f-65b5-5c1f99689c37']");
    }

    public CreateListWindow createShoppingList() {
        createShoppingListButton.click();
        return new CreateListWindow();
    }

    public ShoppingPage deleteLastCreatedShoppingList() {
        shoppingLists.clickThreeDotsOnLastCreatedShoppingList()
                .deleteList()
                .delete();
        listDeletionNotificationPopup.shouldBe(Condition.visible);
        return this;
    }

    public ShoppingPage fillProductName(String productName) {
        addItemInput.setValue(productName);
        return this;
    }

    public ShoppingPage pickProductByName(String productName) {
        productsDropdown.selectProductByName(productName);
        selectedProducts.waitUntilProductWithNameAppears(productName);
        return this;
    }

    public List<String> getShoppingListNames() {
        return shoppingLists.getShoppingListNames();
    }

    public List<String> getSelectedProductNames() {
        return selectedProducts.getSelectedProductNames();
    }
}
