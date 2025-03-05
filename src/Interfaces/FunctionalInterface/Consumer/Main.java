package Interfaces.FunctionalInterface.Consumer;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        /*
         * Consumer Interface
         * Represents an operation, that accepts a single input parameter
         * and returns no results
         * */
        Consumer<Integer> consumerInterface = (Integer val) -> {
            if(val > 10){
                System.out.println("Value: "+ val);
            }
        };
        consumerInterface.accept(100);
        /*
         * Supplier Interface
         * Represents an operation, that accepts a no input parameter
         * and returns results
         * */
        Supplier<String> supplier = () -> "This is the data I am storing";
        System.out.println("isEven: " + supplier.get());

        /*
        * Function
        * It takes two arguments and returns result
        *
        * */
        Function<Integer, String> integerToString = (Integer val) -> {
           String output = val.toString();
           return output;
        };
        System.out.println("Output: "+integerToString.apply(100));

        Predicate<Integer> isEven = (Integer val) -> {
            if(val % 2 == 0){
                return true;
            }
            return false;
        };
        System.out.println("is 2 even: "+isEven.test(2));

    }
}
