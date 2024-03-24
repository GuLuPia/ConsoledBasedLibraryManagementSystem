package com.bookManagement;


import com.bookManagement.entity.Book;

public class BookTest {
    public static void main(String[] args) {
        Book book = Book.builder().name("book")
                .author("Xinyuan Zhang")
                .doi("http")
                .location("sd")
                .publisher("zxy")
                .isAvailable(true)
                .build();
        System.out.println(book);
    }
}
