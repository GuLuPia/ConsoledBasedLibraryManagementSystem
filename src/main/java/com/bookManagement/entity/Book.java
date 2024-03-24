package com.bookManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 自动生成 getter、setter、toString、equals 和 hashCode 方法
@Builder // 使用建造者模式
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Content{
    private String contentType; //根据content新加的property
    private int id;
    private String name;
    private String author;
    private String doi;
    private String location;
    private String publisher;
    private boolean isAvailable;

    @Override
    public String toString() {
        return "Book{" +
                "id ="+id+
                ", contentType ="+contentType+
                ", name = " + name +
                ", author = " + author +
                ", doi = " + doi +
                ", location = " + location +
                ", publisher = " + publisher +
                ", author = " + author +
                ", isAvailable = " + isAvailable +
                "}";
    }
    private Book(BookBuilder builder){
        this.id = builder.id;
        this.contentType = builder.contentType;
        this.name = builder.name;
        this.author = builder.author;
        this.doi = builder.doi;
        this.location = builder.location;
        this.publisher = builder.publisher;
        this.isAvailable = builder.isAvailable;
    }
    @Override
    public int getId(){
        return this.id;
    }
    @Override
    public String getContentType() {
            return this.contentType;
    }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public String getAuthor() {
            return this.author;
        }

        @Override
        public String getDoi() {
            return this.doi;
        }

        @Override
        public String getLocation() {
            return this.location;
        }

        @Override
        public String getPublisher() {
            return this.publisher;
        }

        @Override
        public boolean isAvailable() {
            return this.isAvailable;
        }

        //builder
        public static class BookBuilder extends ContentBuilder {
            public BookBuilder() {
                super.contentType("Book");
            }
            public Book build() {
                return new Book(this);
            }
    }
}
