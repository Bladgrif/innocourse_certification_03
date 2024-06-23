package ru.inno.tests.selenium.pages;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static ru.inno.tests.selenide.utils.Config.getUrl;

public class BooksPage {

    private final WebDriver driver;

    public BooksPage(WebDriver driver) {
        this.driver = driver;
    }

    public static final String BOOKS_STORE_PATH = "books";


    public void openBooksPage() {
        driver.get(getUrl() + BOOKS_STORE_PATH);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
}
