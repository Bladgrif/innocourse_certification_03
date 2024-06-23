package ru.inno.tests.selenide.utils;

import io.restassured.http.ContentType;
import ru.inno.tests.selenide.models.Book;
import ru.inno.tests.selenide.models.CollectionOfIsbnsItem;
import ru.inno.tests.selenide.models.ResponseToAddBook;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static ru.inno.tests.selenide.utils.Config.*;

public class BooksApi {

    public static final String BOOKS_STORE_API_PATH = "BookStore/v1/Books";
    public static final String BOOKS_STORE_API_DELETE = "BookStore/v1/Books?UserId=" + getUserID();

    private final List<Book> books = given()
            .when()
            .get(getUrl() + BOOKS_STORE_API_PATH)
            .then()
            .extract().body().jsonPath().getList("books", Book.class);

    public void addBookInCollection(int count) {
        String jsonBody = "";
        for (int i = 0; i < count; i++) {
            jsonBody = BooksApi.createBookCollectionJson(books.get(i).getIsbn());

            given()
                    .auth()
                    .preemptive()
                    .basic(getUsername(), getPassword())
                    .contentType(ContentType.JSON)
                    .body(jsonBody)
                    .header("Accept", ContentType.JSON.getAcceptHeader())
                    .post(getUrl() + BOOKS_STORE_API_PATH)
                    .then()
                    .statusCode(201);
        }
    }

    public void deleteBooksFromCollection() {
        given()
                .auth()
                .preemptive()
                .basic(getUsername(), getPassword())
                .contentType(ContentType.JSON)
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .delete(getUrl() + BOOKS_STORE_API_DELETE)
                .then()
                .statusCode(204);
    }

    private static String createBookCollectionJson(String isbn) {
        CollectionOfIsbnsItem collectionOfIsbns = new CollectionOfIsbnsItem();
        collectionOfIsbns.setIsbn(isbn);

        List<CollectionOfIsbnsItem> collectionOfIsbnsItems = new ArrayList<>();
        collectionOfIsbnsItems.add(collectionOfIsbns);

        ResponseToAddBook response = new ResponseToAddBook();
        response.setUserId(getUserID());
        response.setCollectionOfIsbns(collectionOfIsbnsItems);

        return response.toString();
    }
}
