package ru.inno.tests.selenide.tests;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.asynchttpclient.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.inno.tests.selenide.models.AuthRequest;
import ru.inno.tests.selenide.models.Book;
import ru.inno.tests.selenide.pageobjects.BooksPage;
import ru.inno.tests.selenide.pageobjects.LoginPage;
import ru.inno.tests.selenide.pageobjects.ProfilePage;
import ru.inno.tests.selenide.utils.BaseTest;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static ru.inno.tests.selenide.utils.Config.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoqaTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();
    BooksPage booksPage = new BooksPage();

    @Test
    void checkEmptyTable() {
//        loginPage.openLoginPage()
//                .setUsernameField(getUsername())
//                .setPasswordField(getPassword())
//                .clickLoginButton();

        loginPage.openLoginPage()
                .loginAs(USER);

        assertEquals("No rows found", profilePage.getUserTableStatus(), "Table is not empty");
    }

    @Test
    void scenarioTwo() {
//        loginPage.openLoginPage()
//                .setUsernameField(getUsername())
//                .setPasswordField(getPassword())
//                .clickLoginButton();

        loginPage.openLoginPage()
                .loginAs(USER);

        booksPage.openBooksPage()
                .addBookInCollection(6);

        profilePage.openProfilePage();

        assertEquals(6, profilePage.countBooksWithImages());

    }

    @Test
    void sceanrioThree() {
    }

    @Test
    void getToken() {
        AuthRequest authRequest = new AuthRequest()
                .setUserName("qwer1234")
                .setPassword("qwer1234Q!");

        String token = given()
                .contentType(ContentType.JSON)
                .body(authRequest)
                .when()
                .post("https://demoqa.com/Account/v1/GenerateToken")
                .then()
                .statusCode(200)
//                .extract().body().jsonPath().getString("token");
                .extract().path("token");

        System.out.println(token);
    }

    @Test
    void getBook() {
        List<Book> books = given()
                .when()
                .get("https://demoqa.com/BookStore/v1/Books")
                .then()
                .extract().body().jsonPath().getList("books", Book.class);
    }

    @Test
    void addBook() {
        String c = """
                    {
                    "userId": "2dba319c-c474-4688-8ec3-b70a3baf0124",
                    "collectionOfIsbns": [
                        {
                            "isbn": "9781449325862"
                        }
                    ]
                }""";

        given()
                .auth()
                .preemptive()
                .basic("qwer1234", "qwer1234Q!")
                .contentType(ContentType.JSON)
                .body(c)
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .post("https://demoqa.com/BookStore/v1/Books")
                .then()
                .log().all()
                .statusCode(201);
    }


}
