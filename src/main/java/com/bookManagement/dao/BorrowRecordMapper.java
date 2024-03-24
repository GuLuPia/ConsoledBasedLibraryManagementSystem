package com.bookManagement.dao;
import com.bookManagement.entity.BorrowRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BorrowRecordMapper {
    @Insert("INSERT INTO borrow_records(book_id, user_id, borrow_date, return_date) VALUES(#{bookId}, #{userId}, #{borrowDate}, #{returnDate})")
    void insertBorrowRecord(BorrowRecord record);
}
