//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Book book = new Book.BookBuilder()
                .name("book")
                .author("Xinyuan Zhang")
                .doi("http")
                .location("sd")
                .publisher("zxy")
                .isAvailable(true)
                .build();
        System.out.println(book);
    }
}