package ui.pages.home;

import com.codeborne.selenide.SelenideElement;
import ui.pages.explore.ExplorePage;

import static com.codeborne.selenide.Selenide.$x;

public class EnterPasswordWindow {

    private final SelenideElement passwordInput;
    private final SelenideElement loginButton;

    public EnterPasswordWindow() {
        passwordInput = $x("//input[@data-testid='UI_KIT_INPUT' and @placeholder='Password']");
        loginButton = $x("//div[@class='s11197' and contains(text(), 'Log in')]");
    }

    public EnterPasswordWindow fillPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    public ExplorePage pressLogin() {
        loginButton.click();
        return new ExplorePage();
    }
}
