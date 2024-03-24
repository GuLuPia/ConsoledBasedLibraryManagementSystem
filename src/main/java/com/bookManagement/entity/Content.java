package com.bookManagement.entity;

public interface Content {
    int getId();
    String getContentType();
    String getName();
    String getAuthor();
    String getDoi();
    String getLocation();
    String getPublisher();
    boolean isAvailable();
}
