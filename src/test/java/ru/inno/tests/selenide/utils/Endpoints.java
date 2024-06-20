package ru.inno.tests.selenide.utils;

public enum Endpoints {
    LOGIN("login"),
    BOOKS("books"),
    PROFILE("profile"),
    BOOKSTORE("BookStore/v1/Books");

    private final String path;

    private Endpoints(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}