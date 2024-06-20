package ru.inno.tests.selenide.pageobjects;

import io.restassured.http.ContentType;
import ru.inno.tests.selenide.models.Book;
import ru.inno.tests.selenide.utils.Config;
import ru.inno.tests.selenide.utils.Endpoints;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;
import static ru.inno.tests.selenide.utils.Config.*;
import static ru.inno.tests.selenide.utils.Endpoints.BOOKS;
import static ru.inno.tests.selenide.utils.Endpoints.BOOKSTORE;

public class BooksPage {

    private final List<Book> books = given()
            .when()
            .get("https://demoqa.com/BookStore/v1/Books")
            .then()
            .extract().body().jsonPath().getList("books", Book.class);

    public BooksPage openBooksPage() {
        open(getUrl() + BOOKS.getPath());
        return this;
    }

    public BooksPage addBookInCollection(int count) {
        String jsonBody = "";
        for (int i = 0; i < count; i++) {
            jsonBody = BooksPage.createBookCollectionJson(books.get(i).getIsbn());

            given()
                    .auth()
                    .preemptive()
                    .basic(getUsername(), getPassword())
                    .contentType(ContentType.JSON)
                    .body(jsonBody)
                    .header("Accept", ContentType.JSON.getAcceptHeader())
                    .log().all()
                    .post(getUrl() + BOOKSTORE.getPath())
                    .then()
                    .log().all()
                    .statusCode(201);
        }
        return this;
    }

    private static String createBookCollectionJson(String isbn) {
//        Response response  = new Response();
//        response.setUserId(Config.getUserID());
//        response.setCollectionOfIsbns();

        return String.format("""
                    {
                        "userId": "%s",
                        "collectionOfIsbns": [
                            {
                                "isbn": "%s"
                            }
                        ]
                    }
                """, Config.getUserID(), isbn);
    }
}
