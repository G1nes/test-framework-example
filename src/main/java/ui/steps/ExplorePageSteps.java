package ui.steps;

import ui.pages.explore.ExplorePage;
import ui.pages.shopping.ShoppingPage;

public class ExplorePageSteps {

    public void navigateToShoppingPage() {
        new ExplorePage().navigateToPage(ShoppingPage.class);
    }
}
