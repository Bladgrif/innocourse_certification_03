package ru.inno.tests.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.inno.tests.selenium.models.User;

import java.time.Duration;

import static ru.inno.tests.selenide.utils.Config.getUrl;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public static final String LOGIN_PATH = "login";

    private void openLoginPage() {
        driver.get(getUrl() + LOGIN_PATH);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    private void setUsernameField(String value) {
        driver.findElement(By.cssSelector("#userName")).sendKeys(value);
    }

    private void setPasswordField(String value) {
        driver.findElement(By.cssSelector("#password")).sendKeys(value);
    }

    public void loginAs(User user) {
        openLoginPage();
        setUsernameField(user.getName());
        setPasswordField(user.getPassword());
        clickLoginButton();
    }

    public void loginAs(String username, String password) {
        openLoginPage();
        setUsernameField(username);
        setPasswordField(password);
        clickLoginButton();
    }

    public void clickLoginButton() {
        driver.findElement(By.cssSelector("#login")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

}
