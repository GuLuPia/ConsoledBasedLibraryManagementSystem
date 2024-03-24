package com.bookManagement.service.impl;

import com.bookManagement.dao.BookMapper;
import com.bookManagement.dao.BorrowRecordMapper;
import com.bookManagement.entity.Book;
import com.bookManagement.entity.BorrowRecord;
import com.bookManagement.service.BorrowService;
import com.bookManagement.service.exception.BookNotAvailableException;
import com.bookManagement.service.exception.BookNotFoundException;
import com.bookManagement.tool.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

public class BorrowServiceImpl implements BorrowService {

    @Override
    public void borrowBookByName(String name, int userId) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            BookMapper bookMapper = session.getMapper(BookMapper.class);
            Book book = bookMapper.selectBookByName(name);
            if (book != null && book.isAvailable()) {
                bookMapper.updateBookAvailability(book.getId(), false);

                BorrowRecord record = new BorrowRecord();
                record.setBookId(book.getId());
                record.setUserId(userId);
                record.setBorrowDate(new Date());

                BorrowRecordMapper recordMapper = session.getMapper(BorrowRecordMapper.class);
                recordMapper.insertBorrowRecord(record);

                session.commit();
                System.out.println("You have successfully borrowed the book: " + book.getName());
                System.out.println("Book Details: Name: " + book.getName() +
                        ", Author: " + book.getAuthor() +
                        ", Location: " + book.getLocation() +
                        ", Publisher: " + book.getPublisher());
            } else {
                throw new BookNotAvailableException("The book '" + name + "' is not available for borrowing.");
            }
        }
    }

    @Override
    public void returnBookByName(String name) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            BookMapper bookMapper = session.getMapper(BookMapper.class);
            Book book = bookMapper.selectBookByName(name);
            if (book != null) {
                bookMapper.updateBookAvailability(book.getId(), true);
                session.commit();
                System.out.println("You have successfully returned the book: " + book.getName());
            } else {
                throw new BookNotFoundException("Book not found with name: " + name);
            }
        }
    }

    @Override
    public void returnBookById(int bookId) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            BookMapper bookMapper = session.getMapper(BookMapper.class);
            Book book = bookMapper.selectBookById(bookId);
            if (book != null) {
                bookMapper.updateBookAvailability(book.getId(), true);
                session.commit();
                System.out.println("You have successfully returned the book: " + book.getName());
            } else {
                throw new BookNotFoundException("Book not found with ID: " + bookId);
            }
        }
    }

    @Override
    public void borrowBookById(int bookId, int userId) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            BookMapper bookMapper = session.getMapper(BookMapper.class);
            BorrowRecordMapper recordMapper = session.getMapper(BorrowRecordMapper.class);

            Book book = bookMapper.selectBookById(bookId);
            if (book != null && book.isAvailable()) {
                bookMapper.updateBookAvailability(book.getId(), false);

                BorrowRecord record = new BorrowRecord();
                record.setBookId(book.getId());
                record.setUserId(userId);
                record.setBorrowDate(new Date());
                recordMapper.insertBorrowRecord(record);

                session.commit();
                System.out.println("You have successfully borrowed the book: " + book.getName());
                System.out.println("Book Details: Name: " + book.getName() +
                        ", Author: " + book.getAuthor() +
                        ", Location: " + book.getLocation() +
                        ", Publisher: " + book.getPublisher());
            } else {
                throw new BookNotAvailableException("The book with ID " + bookId + " is either not available or not found.");
            }
        }
    }


}
