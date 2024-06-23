package ru.inno.tests.selenide.extensions;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import ru.inno.tests.selenide.utils.BooksApi;

public class ClearBookCollectionExtension implements AfterEachCallback, BeforeEachCallback {

    private BooksApi booksApi = new BooksApi();

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        booksApi.deleteBooksFromCollection();
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        booksApi.deleteBooksFromCollection();
        WebDriverRunner.closeWebDriver();
    }
}