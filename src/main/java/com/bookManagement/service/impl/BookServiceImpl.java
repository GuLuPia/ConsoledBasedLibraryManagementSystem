package com.bookManagement.service.impl;


import com.bookManagement.dao.BookMapper;
import com.bookManagement.entity.Book;
import com.bookManagement.service.BookService;
import com.bookManagement.service.exception.BookNotFoundException;
import com.bookManagement.service.exception.NoBooksFoundException;
import com.bookManagement.tool.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookServiceImpl implements BookService {

    @Override
    public void listBooksByDOI(String doi) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            Book book = mapper.selectBookByDOI(doi);
            if (book != null) {
                System.out.println("Book Found: Id:"+book.getId() +", BookName:"+ book.getName() + ", Author: " + book.getAuthor() + ", Location: " + book.getLocation());
            } else {
                throw new BookNotFoundException("No book found with DOI: " + doi);
            }
        }
    }



    @Override
    public void listAllBooks() {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            List<Book> books = mapper.selectAllBooks();
            if (books.isEmpty()) {
                throw new NoBooksFoundException("No books available.");
            } else {
                books.forEach(book -> {
                    System.out.println("Id: "+book.getId()+"Name: " + book.getName() +
                            ", Author: " + book.getAuthor() +
                            ", DOI: " + book.getDoi() +
                            ", Location: " + book.getLocation() +
                            ", Publisher: " + book.getPublisher() +
                            ", Available: " + (book.isAvailable() ? "Yes" : "No"));
                });
            }
        }
    }

    @Override
    public void listBooksByName(String name) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            Book book = mapper.selectBookByName(name);
            if (book != null) {
                System.out.println("Book Found: Id: "+book.getId()+", BookName: " + book.getName() + ", Author: " + book.getAuthor() + ", Location: " + book.getLocation());
            } else {
                throw new BookNotFoundException("No book found with name: " + name);
            }
        }
    }

    @Override
    public void listBooksByAuthor(String author) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            List<Book> books = mapper.selectBooksByAuthor(author);
            if (!books.isEmpty()) {
                books.forEach(book -> System.out.println("Id: "+book.getId()+", Name: " + book.getName() + ", Author: " + book.getAuthor() + ", Location: " + book.getLocation()));
            } else {
                throw new NoBooksFoundException("No books found by author: " + author);
            }
        }
    }



}
