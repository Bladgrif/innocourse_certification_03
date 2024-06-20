package ru.inno.tests.selenide.pageobjects;

import com.codeborne.selenide.SelenideElement;
import ru.inno.tests.selenide.models.Book;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static ru.inno.tests.selenide.utils.Config.getUrl;
import static ru.inno.tests.selenide.utils.Endpoints.LOGIN;
import static ru.inno.tests.selenide.utils.Endpoints.PROFILE;

public class ProfilePage {

    private BooksPage booksPage = new BooksPage();

    private SelenideElement
            userTable = $(".profile-wrapper .ReactTable .rt-noData");

    private List<SelenideElement> profileTableRows = $$("div.rt-tr-group img");

    public String getUserTableStatus() {
        return userTable.getText();
    }

    public ProfilePage openProfilePage() {
        open(getUrl() + PROFILE.getPath());
        return this;
    }

    public ProfilePage refresh() {
        refresh();
        return this;
    }

    public int countBooksWithImages() {
        return profileTableRows.size();
    }

}
