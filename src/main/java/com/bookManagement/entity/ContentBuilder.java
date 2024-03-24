package com.bookManagement.entity;

public abstract class ContentBuilder {
        protected int id;
        protected String contentType;
        protected String name;
        protected String author;
        protected String doi;
        protected String location;
        protected String publisher;
        protected boolean isAvailable;

        public ContentBuilder id(int id) {
        this.id = id;
        return this;
        }
        public ContentBuilder contentType(String contentType) {
            this.contentType = contentType;
            return this;
        }

        public ContentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ContentBuilder author(String author) {
            this.author = author;
            return this;
        }

        public ContentBuilder doi(String doi) {
            this.doi = doi;
            return this;
        }

        public ContentBuilder location(String location) {
            this.location = location;
            return this;
        }

        public ContentBuilder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public ContentBuilder isAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
            return this;
        }

        public abstract Content build();
}
