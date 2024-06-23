package ru.inno.tests.selenide.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class BooStoreApplications {

    private final SelenideElement BooStoreApplicationsPanel = $(".left-pannel .accordion");

    private final SelenideElement login = BooStoreApplicationsPanel.$(byText("Login"));
    private final SelenideElement bookStore = BooStoreApplicationsPanel.$(byText("Book Store"));
    private final SelenideElement profile = BooStoreApplicationsPanel.$(byText("Profile"));
    private final SelenideElement bookStoreAPI = BooStoreApplicationsPanel.$(byText("Book Store API"));

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
}
