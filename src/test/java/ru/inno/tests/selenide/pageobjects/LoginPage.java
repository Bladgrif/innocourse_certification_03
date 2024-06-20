package ru.inno.tests.selenide.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.Select;
import ru.inno.tests.selenide.models.User;
import ru.inno.tests.selenide.utils.Config;
import ru.inno.tests.selenide.utils.Endpoints;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.inno.tests.selenide.utils.Config.*;
import static ru.inno.tests.selenide.utils.Endpoints.*;

public class LoginPage {

    public static final String URL = "login";

    private final SelenideElement usernameField = $("#userName");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement loginButton = $("#login");

    public LoginPage openLoginPage() {
        open(getUrl() + URL);
        return this;
    }

    public LoginPage setUsernameField(String value) {
        usernameField.setValue(value);
        return this;
    }

    public LoginPage setPasswordField(String value) {
        passwordField.setValue(value);
        return this;
    }

    public LoginPage loginAs(User user)  {
        setUsernameField(user.getName());
        setPasswordField(user.getPassword());
        clickLoginButton();
        return this;
    }

    public LoginPage loginAs(String username, String password)   {
        setUsernameField(username);
        setPasswordField(password);
        clickLoginButton();
        return this;
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }

}
