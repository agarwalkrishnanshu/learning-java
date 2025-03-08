package Collections.ComparatorAndComparable;

import java.util.Comparator;

public class CarTypeComparator implements Comparator<Car> {

    // This is a Car Type Comparator- can be used to sort collection of cars based on their type

    @Override
    public int compare(Car o1, Car o2) {
        return o1.type.compareTo(o2.type);
    }
}
