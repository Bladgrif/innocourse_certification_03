package ru.inno.tests.selenide.pages;

import static com.codeborne.selenide.Selenide.open;
import static ru.inno.tests.selenide.utils.Config.getUrl;

public class BooksPage {

    public static final String BOOKS_STORE_PATH = "books";


    public void openBooksPage() {
        open(getUrl() + BOOKS_STORE_PATH);
    }

    public void deleteAllBooks() {

    }
}
