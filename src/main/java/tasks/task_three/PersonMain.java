package tasks.task_three;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonMain {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Peter", "Patterson", 21));
        personList.add(new Person("Paul", "Walker", 31));
        personList.add(new Person("Steve", "Runner", 17));
        personList.add(new Person("Arnold", "", -1));
        personList.add(new Person(" ", "Stevenson", 19));
        personList.add(new Person("   ", "Stevenson", 19));
        personList.add(new Person("      ", "Stevenson", 19));
        personList.add(new Person(" Arnold", "Stevenson", 19));
        personList.add(null);
        personList.add(new Person("Aaron", "Bortnicker", 18));

        //Print all unique names from the list for adults.
        //Result should be in upper case and without any special character (e.g., whitespace).
        System.out.println("Unique names from the list for adults:");
        personList.stream()
                .distinct()
                .filter(Objects::nonNull)
                .filter(x -> x.getAge() >= 18 && StringUtils.isNoneBlank(x.getFirstName()))
                .map(x -> x.getFirstName().replace(" ", "").toUpperCase())
                .forEach(System.out::println);
    }
}
