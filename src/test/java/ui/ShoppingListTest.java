package ui;

import org.junit.jupiter.api.Test;
import ui.steps.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingListTest extends BaseUiTest {
    private final AuthorizationSteps authorizationSteps = new AuthorizationSteps(AUTHORIZATION);
    private final ExplorePageSteps explorePageSteps = new ExplorePageSteps();
    private final ShoppingPageSteps shoppingPageSteps = new ShoppingPageSteps();

    @Test
    public void testShopListAddingProducts(){
        List<String> expectedProducts = List.of("Bread", "Milk", "Eggs", "Cheese", "Meat");

        createShoppingList();
        shoppingPageSteps.addItemsByNames(expectedProducts);
        List<String> actualProducts = shoppingPageSteps.getSelectedProducts();

        assertThat(actualProducts).containsExactlyInAnyOrderElementsOf(expectedProducts);
    }

    @Test
    public void testShopListDeletion(){
        String defaultNonDeletableShoppingListName = "Shopping List";

        createShoppingList();
        shoppingPageSteps.deleteLastCreatedShoppingList();
        List<String> shoppingListNames = shoppingPageSteps.getShoppingListNames();

        soft.assertThat(shoppingListNames).hasSize(1);
        soft.assertThat(shoppingListNames).contains(defaultNonDeletableShoppingListName);
        soft.assertAll();
    }

    private void createShoppingList(){
        authorizationSteps.authorizeByEmail();
        explorePageSteps.navigateToShoppingPage();
        shoppingPageSteps.createShoppingListWithDefaultName();
    }
}
