package ru.inno.tests.selenium.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class BooStoreApplications {

    private final WebDriver driver;

    public BooStoreApplications(WebDriver driver) {
        this.driver = driver;
    }

    private final SelenideElement BooStoreApplicationsPanel = $(".left-pannel .accordion");

    private final SelenideElement login = BooStoreApplicationsPanel.$(byText("Login"));
    private final SelenideElement bookStore = BooStoreApplicationsPanel.$(byText("Book Store"));
    private final SelenideElement profile = BooStoreApplicationsPanel.$(byText("Profile"));
    private final SelenideElement bookStoreAPI = BooStoreApplicationsPanel.$(byText("Book Store API"));
    private final SelenideElement ban = $("$('#fixedban').remove()");
    private final SelenideElement footer = $("$('footer').remove()");

    public void GoToLoginPage() {
        login.click();
    }

    public void GoToBookStore() {
        bookStore.click();
    }

    public void GoToProfilePage() {
        profile.click();
    }

    public void GoToBookStoreAPI() {
        bookStoreAPI.click();
    }

    public void deleteFooter() {
        executeJavaScript(String.valueOf(ban));
        executeJavaScript(String.valueOf(footer));
    }
}
