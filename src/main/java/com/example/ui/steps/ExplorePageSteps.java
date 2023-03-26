package com.example.ui.steps;

import com.example.ui.pages.explore.ExplorePage;
import com.example.ui.pages.shopping.ShoppingPage;

public class ExplorePageSteps {

    public void navigateToShoppingPage() {
        new ExplorePage().navigateToPage(ShoppingPage.class);
    }
}
