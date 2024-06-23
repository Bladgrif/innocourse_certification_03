package ru.inno.tests.selenide.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.inno.tests.selenide.pages.BooStoreApplications;
import ru.inno.tests.selenide.pages.BooksPage;
import ru.inno.tests.selenide.pages.LoginPage;
import ru.inno.tests.selenide.pages.ProfilePage;
import ru.inno.tests.selenide.utils.BaseTest;
import ru.inno.tests.selenide.utils.BooksApi;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoqaTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();
    BooksPage booksPage = new BooksPage();
    BooksApi api = new BooksApi();
    BooStoreApplications applications = new BooStoreApplications();

    @Test
    @Tag("Demoqa")
    void checkEmptyTable() {
        loginPage.openLoginPage(); // открываем страницу входа
        loginPage.loginAs(USER); // вводим логин и пароль, а затем жмем кнопку входа

        assertEquals(0, profilePage.countBooksWithImages(5)); // проверяем, что в таблице нет книг
    }

    @Test
    @Tag("Demoqa")
    void CheckingTheTableAfterAdding6Books() {
        loginPage.openLoginPage(); // открываем страницу входа
        loginPage.loginAs(USER); // вводим логин и пароль, а затем жмем кнопку входа

        applications.GoToBookStore(); // переходим на страницу книг
        api.addBookInCollection(6); // добавляем книги в коллекцию через API, т.к. не работает на сайте

        applications.GoToProfilePage(); // возвращаемся на страницу профиля
        loginPage.openLoginPage(); //После апи запроса на добавление книг,происходит выход из акааунта, входим заного
        loginPage.loginAs(USER);

        assertEquals(6, profilePage.countBooksWithImages(10)); // проверяем, что в таблице есть книги
        // передаем количество добавленных книг "6", раскрытие таблицы на нужное количество полей "10"
    }

    @Test
    @Tag("Demoqa")
    void CheckingTheTableAfterAdding2BooksAndDeleting2Book() {
        loginPage.openLoginPage(); // открываем страницу входа
        loginPage.loginAs(USER); // вводим логин и пароль, а затем жмем кнопку входа

        applications.GoToBookStore(); // переходим на страницу книг
        api.addBookInCollection(2); // добавляем книги в коллекцию через API, т.к. не работает на сайте

        applications.GoToProfilePage(); // возвращаемся на страницу профиля
        loginPage.openLoginPage(); //После апи запроса на добавление книг,происходит выход из акааунта, входим заного
        loginPage.loginAs(USER);
        profilePage.deleteAllBooks();  // удаляем 2 книги из коллекции

        assertEquals(0, profilePage.countBooksWithImages(5)); // проверяем, что в таблице нет книг
    }
}
