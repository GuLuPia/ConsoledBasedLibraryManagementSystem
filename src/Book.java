public class Book {
    private String name;
    private String author;
    private String doi;
    private String location;
    private String publisher;
    private boolean isAvailable;

    @Override
    public String toString() {
        return "Book{" +
                "name = " + name +
                ", author = " + author +
                ", doi = " + doi +
                ", location = " + location +
                ", publisher = " + publisher +
                ", author = " + author +
                ", isAvailable = " + isAvailable +
                "}";
    }

    private Book(BookBuilder builder){
        this.name = builder.name;
        this.author = builder.author;
        this.doi = builder.doi;
        this.location = builder.location;
        this.publisher = builder.publisher;
        this.isAvailable = builder.isAvailable;
    }

//builder
    public static class BookBuilder {
        private String name;
        private String author;
        private String doi;
        private String location;
        private String publisher;
        private boolean isAvailable;

        public BookBuilder() {
        }

        public BookBuilder name(String name) {
            this.name = name;
            return this;
        }

        public BookBuilder author(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder doi(String doi) {
            this.doi = doi;
            return this;
        }

        public BookBuilder location(String location) {
            this.location = location;
            return this;
        }

        public BookBuilder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public BookBuilder isAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

}
