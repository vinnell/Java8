import printable.Book;
import printable.Magazine;
import printable.Printable;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List< User> users = Arrays.asList(
                new User("Alla", "Kostenko", 15),
                new User("Oleg", "Aroma", 25),
                new User("Dmytro", "Furman", 44),
                new User("Sergiy","Drovenko", 28),
                new User("Alya", "Osnova", 33),
                new User("Anna", "Perova", 17),
                new User("Maya", "Stezhko", 23),
                new User("Olga", "Yurko", 29),
                new User("Katya", "Revchina",28),
                new User("Ganna", "Markova", 59));

        System.out.println("a. Before sort: ");
        for (User user : users){
            System.out.println(user);
        }

        Comparator<User> comporatorOfUser = (o1, o2) -> o1.getAge() - o2.getAge();
          users.sort(comporatorOfUser);
        System.out.println("\nb. After sort by age: ");
        for (User user : users){
            System.out.println(user);
        }
       Comparator<User> comporatorOfUser2 = (o1, o2) -> {
            if (o1.getAge() == o2.getAge()){
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
            return o1.getAge() - o2.getAge();
       };
       users.sort(comporatorOfUser2);

        Double average = users.stream().collect(Collectors.averagingInt(User :: getAge));
        System.out.println("\nc. Average age of users = " + average);

        System.out.println("\nd. After sort by age and name: ");
        for (User user : users){
            System.out.println(user);
        }

        List<User> userFound = users.stream()
                .filter(user -> user.getSecondName()
                .contains("S") || user.getSecondName()
                .contains("A")).toList();

       System.out.println("\ne. Users with second name, where first letter S or A:\n " + userFound );

       System.out.println("\nf. Only users > 18 years: " );
                users.stream().filter(user -> user.getAge() > 18)
                .forEach(System.out::println);
        System.out.println("\n");

        Book b1 = new Book("Children's book");
        Book b2 = new Book("The little astronaut");
        Magazine m1 = new Magazine("Travel journal");
        Magazine m2 = new Magazine("Children's journal");
        Book b3 = new Book("When I grow up");
        Book b4 = new Book("Charlie can do it");

        Printable[] printables = {b1, b2, b3, b4, m1, m2};

        Arrays.stream(printables).forEach(printable -> printable.print());

        List<Printable> bookAndMag = Arrays.asList(
                new Book("Winter"),
                new Book("Spring"),
                new Magazine("Summer"),
                new Magazine("Autumn"));
        bookAndMag.forEach(Printable::print);
          }
}