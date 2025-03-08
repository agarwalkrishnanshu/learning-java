package Collections.ComparatorAndComparable;

public class Car implements Comparable<Car>{
    String fuel;
    String type;

    Car(String fuel, String type){
        this.fuel = fuel;
        this.type = type;
    }

    // Here we have implemented a compareTo method from the Comparable interface
    // Now when we call sort on a Collection of Cars we will not get an exception and Java will use the below
    // Implementation of compareTo to sort the collection of cars

    @Override
    public int compareTo(Car o) {
        return this.fuel.compareTo(o.fuel);
    }

    @Override
    public String toString(){

        return this.fuel + " "+ this.type;
    }
}
