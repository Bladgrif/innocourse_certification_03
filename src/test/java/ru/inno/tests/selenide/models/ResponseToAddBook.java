package ru.inno.tests.selenide.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseToAddBook {

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("collectionOfIsbns")
    private List<CollectionOfIsbnsItem> collectionOfIsbns;

    public void setCollectionOfIsbns(List<CollectionOfIsbnsItem> collectionOfIsbns) {
        this.collectionOfIsbns = collectionOfIsbns;
    }

    public List<CollectionOfIsbnsItem> getCollectionOfIsbns() {
        return collectionOfIsbns;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }


    @Override
    public String toString() {
        return "{" +
                "\"userId\":" + "\"" + userId + "\"" +
                ", \"collectionOfIsbns\":" + collectionOfIsbns +
                '}';
    }
}