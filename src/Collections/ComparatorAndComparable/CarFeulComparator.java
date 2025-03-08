package Collections.ComparatorAndComparable;

import java.util.Comparator;

public class CarFeulComparator implements Comparator<Car> {

    // This is a Car Fuel Comparator can be used to sort collection of cars based on their fuel

    @Override
    public int compare(Car o1, Car o2) {
        return o1.fuel.compareTo(o2.fuel);
    }
}
