package Collections.ComparatorAndComparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("cng", "hatchback"));
        carList.add(new Car("electric", "suv"));
        carList.add(new Car("petrol", "sedan"));

        /*
        Comparable
        Using a Comparable interface we can implement only one compareTo() and use it while sorting.
        Comparable can give us a default sorting implementation of the object

        Comparators
        If we want different sorting functionalities like sorting based on car type and fuel or descending order.
        Then we can use Comparators and have custom implementations of compare().
        We can also use multiple fields to sort using comparators

         */

        // Sorting using the default sorting implementation using comparable interface - compareTo()
        Collections.sort(carList);
        System.out.println("Sorting using comparable..");
        carList.forEach(System.out::println);

        // Sorting using the comparator based on car type
        System.out.println("Sorting using comparator based on car type..");
        Collections.sort(carList, new CarTypeComparator());
        carList.forEach(System.out::println);

        System.out.println("Sorting using comparator based on car fuel..");
        Collections.sort(carList, new CarFeulComparator());
        carList.forEach(System.out::println);

    }



}
