package ui.pages.shopping.elements;

import com.codeborne.selenide.SelenideElement;

public class ProductsDropdown {
    private final SelenideElement dropdown;
    private final ProductDropdownElements productDropdownElements;

    public ProductsDropdown(SelenideElement element) {
        dropdown = element;
        productDropdownElements = new ProductDropdownElements(dropdown.$$x(".//div[@class='s12363']"));
    }

    public void selectProductByName(String productName) {
        productDropdownElements.selectProductByName(productName);
    }
}
