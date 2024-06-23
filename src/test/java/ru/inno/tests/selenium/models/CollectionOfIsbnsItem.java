package ru.inno.tests.selenium.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CollectionOfIsbnsItem {

    @JsonProperty("isbn")
    private String isbn;

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return
                "{" +
                        "\"isbn\": " + "\"" + isbn + "\"" +
                        "}";
    }
}