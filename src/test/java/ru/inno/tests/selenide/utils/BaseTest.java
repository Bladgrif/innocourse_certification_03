package ru.inno.tests.selenide.utils;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.inno.tests.selenide.models.User;

public class BaseTest {

    private BooksApi booksApi = new BooksApi();

    protected static final User USER = new User(Config.getUsername(), Config.getPassword());

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "edge";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

    }

    @BeforeEach
    void beforeEach() {
        booksApi.deleteBooksFromCollection();
    }

    @AfterEach
    void afterEach() {
        booksApi.deleteBooksFromCollection();
    }


}
