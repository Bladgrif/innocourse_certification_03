package ru.inno.tests.selenide.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.inno.tests.selenide.extensions.ClearBookCollectionExtension;
import ru.inno.tests.selenide.pages.BooStoreApplications;
import ru.inno.tests.selenide.pages.LoginPage;
import ru.inno.tests.selenide.pages.ProfilePage;
import ru.inno.tests.selenide.utils.BaseTest;
import ru.inno.tests.selenide.utils.BooksApi;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Demoqa Tests Selenide")
@Feature("Book Store Application Tests")
@ExtendWith(ClearBookCollectionExtension.class)
public class DemoqaTests extends BaseTest {

    //добавляем книги в коллекцию через API, т.к. не работает на сайте
    //После апи запроса на добавление книг, происходит выход из акааунта, поэтому приходится авторизоваться заного

    private LoginPage loginPage = new LoginPage();
    private ProfilePage profilePage = new ProfilePage();
    private BooksApi api = new BooksApi();
    private BooStoreApplications applications = new BooStoreApplications();

    @Test
    @Tag("Demoqa")
    @Story("User checks the empty book table")
    @Owner("Grigoriev Roman")
    @Severity(SeverityLevel.NORMAL)
    @Description("Этот тест проверяет, что таблица книг пуста после входа в систему.")
    void checkEmptyTable() {
        step("Авторизация на странице пользователя", () -> {
            loginPage.loginAs(USER);
        });
        step("Проверка, что таблица содержит  0 книг после входа в систему", () -> {
            assertEquals(0, profilePage.countBooksWithImages(5));
        });
    }

    @Test
    @Tag("Demoqa")
    @Story("User adds 6 books to the collection and checks the table")
    @Owner("Grigoriev Roman")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Этот тест проверяет, что таблица содержит 6 книг после добавления через API.")
    void CheckingTheTableAfterAdding6Books() {
        step("Авторизация на странице пользователя", () -> {
            loginPage.loginAs(USER);
        });
        step("Добавление 6 книг в коллекцию", () -> {
            applications.GoToBookStore();
            api.addBookInCollection(6);
        });
        step("Возврат на страницу профиля", () -> {
            applications.GoToProfilePage();
            loginPage.loginAs(USER);
        });
        step("Проверка, что таблица содержит 6 книг после добавления", () -> {
            assertEquals(6, profilePage.countBooksWithImages(10));
        });
    }

    @Test
    @Tag("Demoqa")
    @Story("User adds and deletes books from the collection")
    @Owner("Grigoriev Roman")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Этот тест проверяет, что таблица пуста после добавления 2 книг и удаления всех книг.")
    void CheckingTheTableAfterAdding2BooksAndDeleting2Book() {
        step("Авторизация на странице пользователя", () -> {
            loginPage.loginAs(USER);
        });
        step("Добавление 2 книги в коллекцию", () -> {
            applications.GoToBookStore();
            api.addBookInCollection(2);
        });
        step("Возврат на страницу профиля", () -> {
            applications.GoToProfilePage();
            loginPage.loginAs(USER);
        });
        step("Проверка, что таблица содержит 2 книги после добавления", () -> {
            assertEquals(2, profilePage.countBooksWithImages(5));
        });
        step("Удаление всех книг из коллекции", () -> {
            profilePage.deleteAllBooks();
        });
        step("Проверка, что таблица содержит 0 книг после удаления", () -> {
            assertEquals(0, profilePage.countBooksWithImages(5));
        });
    }
}
