package ru.inno.tests.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import ru.inno.tests.selenide.models.User;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.inno.tests.selenide.utils.Config.getUrl;

public class LoginPage {

    public static final String LOGIN_PATH = "login";

    private final SelenideElement usernameField = $("#userName");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement loginButton = $("#login");

    private static void openLoginPage() {
        open(getUrl() + LOGIN_PATH);
    }

    private void setUsernameField(String value) {
        usernameField.setValue(value);
    }

    private void setPasswordField(String value) {
        passwordField.setValue(value);
    }

    public void loginAs(User user) {
        openLoginPage();
        setUsernameField(user.getName());
        setPasswordField(user.getPassword());
        clickLoginButton();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

}
