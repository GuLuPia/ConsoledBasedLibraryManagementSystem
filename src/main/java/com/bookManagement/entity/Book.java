package com.bookManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 自动生成 getter、setter、toString、equals 和 hashCode 方法
@Builder // 使用建造者模式
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int id;
    private String name;
    private String author;
    private String doi;
    private String location;
    private String publisher;
    private boolean isAvailable;
}
