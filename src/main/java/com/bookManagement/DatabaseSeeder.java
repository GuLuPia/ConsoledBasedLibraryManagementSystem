package com.bookManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * mysql数据测试类,启动可插入数据
 */
public class DatabaseSeeder {

    //TODO    修改your_database_name
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name?serverTimezone=UTC";
    //TODO    修改your_database_user
    private static final String USER = "your_database_user";
    //TODO    修改your_database_password
    private static final String PASSWORD = "your_database_password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // 插入用户
            PreparedStatement insertUser = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
            insertUser.setString(1, "user1");
            insertUser.setString(2, "pass1");
            insertUser.executeUpdate();

            insertUser.setString(1, "user2");
            insertUser.setString(2, "pass2");
            insertUser.executeUpdate();

            // 插入书籍
            PreparedStatement insertBook = conn.prepareStatement("INSERT INTO books (name, author, doi, location, publisher, isAvailable) VALUES (?, ?, ?, ?, ?, ?)");
            insertBook.setString(1, "Book 1");
            insertBook.setString(2, "Author 1");
            insertBook.setString(3, "DOI1");
            insertBook.setString(4, "Location 1");
            insertBook.setString(5, "Publisher 1");
            insertBook.setBoolean(6, true);
            insertBook.executeUpdate();

            insertBook.setString(1, "Book 2");
            insertBook.setString(2, "Author 2");
            insertBook.setString(3, "DOI2");
            insertBook.setString(4, "Location 2");
            insertBook.setString(5, "Publisher 2");
            insertBook.setBoolean(6, true);
            insertBook.executeUpdate();

            insertBook.setString(1, "Book 3");
            insertBook.setString(2, "Author 3");
            insertBook.setString(3, "DOI3");
            insertBook.setString(4, "Location 3");
            insertBook.setString(5, "Publisher 3");
            insertBook.setBoolean(6, false);
            insertBook.executeUpdate();

            // 插入借书记录
            PreparedStatement insertBorrowRecord = conn.prepareStatement("INSERT INTO borrow_records (book_id, user_id, borrow_date) VALUES (?, ?, ?)");
            insertBorrowRecord.setInt(1, 1);
            insertBorrowRecord.setInt(2, 1);
            insertBorrowRecord.setDate(3, java.sql.Date.valueOf("2023-01-01"));
            insertBorrowRecord.executeUpdate();

            System.out.println("Data inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
