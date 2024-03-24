package com.bookManagement.entity;

public class JournalArticle implements Content {
    private int id;
    private String contentType;
    private String name;
    private String author;
    private String doi;
    private String location;
    private String publisher;
    private boolean isAvailable;

    // constructor
    @Override
    public String toString() {
        return "Journal{" +
                "id ="+id+
                ",contentType =" + contentType +
                ", name = " + name +
                ", author = " + author +
                ", doi = " + doi +
                ", location = " + location +
                ", publisher = " + publisher +
                ", author = " + author +
                ", isAvailable = " + isAvailable +
                "}";
    }

    private JournalArticle(JournalArticleBuilder builder) {
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
    public static class JournalArticleBuilder extends ContentBuilder {
        public JournalArticleBuilder() {
            super.contentType("JournalArticle");
        }
        public JournalArticle build() {
            return new JournalArticle(this);
        }
    }
}

