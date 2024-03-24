package com.bookManagement.dao;

import com.bookManagement.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("SELECT * FROM books WHERE id = #{id}")
    Book selectBookById(int id);

    @Select("SELECT * FROM books WHERE name = #{name}")
    Book selectBookByName(@Param("name") String name);

    @Select("SELECT * FROM books WHERE author = #{author}")
    List<Book> selectBooksByAuthor(@Param("author") String author);

    @Update("UPDATE books SET available = #{available} WHERE id = #{id}")
    void updateBookAvailability(@Param("id") int id, @Param("available") boolean available);

    @Select("SELECT * FROM books")
    List<Book> selectAllBooks();
    @Select("SELECT * FROM books WHERE doi = #{doi}")
    Book selectBookByDOI(@Param("doi") String doi);



}
