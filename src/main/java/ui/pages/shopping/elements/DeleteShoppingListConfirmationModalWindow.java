package ui.pages.shopping.elements;

import com.codeborne.selenide.SelenideElement;
import ui.DriverContext;
import ui.pages.shopping.ShoppingPage;

import static com.codeborne.selenide.Selenide.$x;

public class DeleteShoppingListConfirmationModalWindow {

    private final SelenideElement deleteButton;

    public DeleteShoppingListConfirmationModalWindow() {
        deleteButton = $x("//button[@data-testid='confirm-delete-button']");
    }

    public ShoppingPage delete() {
        deleteButton.click();
        DriverContext.waitUntilRequestComplete("DeleteList");
        return new ShoppingPage();
    }
}
