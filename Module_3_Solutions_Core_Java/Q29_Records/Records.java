import java.util.*;
import java.util.stream.*;

public class Records {
    record Person(String name, int age) {}

    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("Alice", 30),
            new Person("Bob", 17),
            new Person("Charlie", 25)
        );
        people.forEach(System.out::println);
        System.out.println("Adults:");
        people.stream().filter(p -> p.age() >= 18).forEach(System.out::println);
    }
}
