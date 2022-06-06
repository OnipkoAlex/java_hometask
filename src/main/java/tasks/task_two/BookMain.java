package tasks.task_two;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookMain {

    public static void main(String[] args) {
        List<Book> books = new Book().makeBooks(10);
        System.out.println("All books:");
        //print all books using method toString (information should be consistent, e.g. “name: Book1, price: 10”)
        books.stream().forEach(System.out::println);
        System.out.println();

        System.out.println("All book names:");
        //get List<String> of all book names and print them
        books.stream().map(x -> x.getName()).forEach(System.out::println);
        System.out.println();

        //get total price of all books and print it
        System.out.println("Total sum:");
        System.out.println(books.stream().mapToInt(Book::getPrice).sum());
        System.out.println();

        System.out.println("Books with 'a' or 'A' in name:");
        //get any book with “A” or “a” character in name and print its name
        books.stream().filter(x -> x.getName().contains("a") || x.getName().contains("A")).forEach(System.out::println);
        System.out.println();

        System.out.println("Book with highest price:");
        //print book name with highest price
        System.out.println(books.stream().max(Comparator.comparing(Book::getPrice)).get().getName());
        System.out.println();

        System.out.println("Number of books, where name consists of 5 letters:");
        //get number of books where name consists of 5 letters
        System.out.println(books.stream().filter(x -> x.getName().length() == 5).count());
        System.out.println();

        System.out.println("All books with price > 30");
        //get all books except books with price higher then 30
        books.stream().filter(x -> x.getPrice() <= 30).forEach(System.out::println);
        System.out.println();

        System.out.println("Books sorted by name in desc order:");
        //sort books by name in desc order, if name equals then sort by price
        books.stream().sorted(Comparator.comparing(Book::getName).reversed()).forEach(System.out::println);
        System.out.println();

        System.out.println("Library name:");
        /*
        create object Book book1(name myBook, price 5)
        create object Book book2(name myBook, price 5)
        add Book1 to map Map<Book, String> mapWithBook -> key = Book1, value - some library name
        get library name using book2 object
         */
        Book book1 = new Book("myBook", 5);
        Book book2 = new Book("myBook", 5);
        Map<Book, String> mapWithBook = new HashMap<>();
        mapWithBook.put(book1, "Saint Glory Library");
        System.out.println(mapWithBook.get(book2));
    }
}
