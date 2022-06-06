package tasks.task_two;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Book {

    private String name;
    private Integer price;

    public Book(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public Book() {
    }

    public List<Book> makeBooks(Integer quantity) {
        List<Book> result = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            result.add(new Book(RandomStringUtils.randomAlphabetic(ThreadLocalRandom.current().nextInt(3, 11)), ThreadLocalRandom.current().nextInt(1, 99)));
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(name, book.name) && Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
