package ui.steps;

import ui.pages.shopping.ShoppingPage;

import java.util.List;

public class ShoppingPageSteps {

    private final ShoppingPage shoppingPage = new ShoppingPage();

    public void createShoppingListWithDefaultName() {
        shoppingPage.createShoppingList()
                .createList();
    }

    public void deleteLastCreatedShoppingList() {
        shoppingPage.deleteLastCreatedShoppingList();
    }

    public void addItemsByNames(List<String> names) {
        names.forEach(name ->
                              shoppingPage.fillProductName(name)
                                      .pickProductByName(name)
                     );
    }

    public List<String> getShoppingListNames() {
        return shoppingPage.getShoppingListNames();
    }

    public List<String> getSelectedProducts() {
        return shoppingPage.getSelectedProductNames();
    }
}
