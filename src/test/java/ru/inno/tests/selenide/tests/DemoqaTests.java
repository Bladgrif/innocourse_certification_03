package ru.inno.tests.selenide.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.inno.tests.selenide.pages.Book;
import ru.inno.tests.selenide.utils.Config;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;

public class DemoqaTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "edge";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void scenarioOne() {
        open("https://demoqa.com/login");
        $("#userName").setValue("VanHelsing");
        $("#password").setValue("Dracula3000!");
        $("#login").click();
        $(".profile-wrapper .ReactTable .rt-noData").shouldHave(text("No rows found"), Duration.ofSeconds(10));
    }

    @Test
    void sceanrioTwo() {
//        open("https://demoqa.com/login");
//        $("#userName").setValue("VanHelsing");
//        $("#password").setValue("Dracula3000!");

        List<Book> books = given()
                .when()
                .get("https://demoqa.com/BookStore/v1/Books")
                .then()
                .extract().body().jsonPath().getList("books", Book.class);

        for (Book book : books) {
            System.out.println(book.getTitle());
        }

//        Response response = RestAssured
//                .given()
//                .when()
//                .get("https://demoqa.com/BookStore/v1/Books")
//                .then()
//                .statusCode(200)
//                .extract()
//                .response();
//
//        String jsonResponse = response.getBody().asString();
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        List<Book> books = null;
//        try {
//            // Извлечение массива "books" из корневого объекта JSON
//            JsonPath jsonPath = new JsonPath(jsonResponse);
//            List<Map<String, Object>> booksList = jsonPath.getList("books");
//
//            // Преобразование списка карт в список объектов Book
//            CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, Book.class);
//            books = objectMapper.convertValue(booksList, listType);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        for (Book book : books) {
//            System.out.println(book.getTitle());
//        }

    }
}
