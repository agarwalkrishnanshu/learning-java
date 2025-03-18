package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperationsInStream {
    public static void main(String[] args) {

        /*
        * Remeber: Once terminal operation is used on a stream, it is closed/consumed
        * It cannot be used again to call another terminal operation
        * If you try to use it again then IllegalStateException will occur
        * */
        List<Integer> numbers = Arrays.asList(2, 1, 4, 7, 10);
        Stream<Integer> numStream;
        // forEach(Consumer)
        numbers.stream()
                .forEach((Integer val) -> System.out.println(val));

        // toArray() - collects the elements of the stream into an array
        Object[] filteredNumbers = numbers.stream()
                .filter((Integer val) -> val > 2)
                .toArray();

        // If we want a Integer array
        Integer[] filteredNumbersArr = numbers.stream()
                .filter((Integer val) -> val > 2)
                .toArray((int size) -> new Integer[size]);

        // reduce() - does reduction on the elements of the stream
        // Perform associative aggregation function
        Optional<Integer> reducedNumber = numbers.stream()
                .reduce((Integer a, Integer b) -> a + b);
        System.out.println("Reduced: "+ reducedNumber.get());

        // collect() - used to collect the elements of a stream into a list
        List<Integer> finalList = numbers.stream().filter((Integer val) -> val > 2)
                .collect(Collectors.toList());
        System.out.println("Collected List: "+ finalList);

        // min() max()
        Optional<Integer> min = numbers.stream().min((Integer a, Integer b) -> a - b);
        Optional<Integer> max = numbers.stream().max((Integer a, Integer b) -> a - b);

        System.out.println("Min: "+ min.get() + " Max: "+ max.get());

        // count() - gives the number of elements present in the stream
        long n = numbers.stream().count();
        System.out.println("Count: "+ n);

        // anyMatch(Predicate) - check if any value in the stream match the given predicate
        // we know that Predicate is a Functional interface which takes a input and returns boolean

        boolean hasValueGreaterThanThree = numbers.stream().anyMatch((Integer val) -> val >3);
        System.out.println("anyMatch(): "+hasValueGreaterThanThree);

        // allMatch();
        boolean iaAllValueGreaterThanThree = numbers.stream().allMatch((Integer val) -> val >3);
        System.out.println("allMatch(): iaAllValueGreaterThanThree "+iaAllValueGreaterThanThree);

        // noneMatch
        boolean iaNoValueGreaterThanThree = numbers.stream().noneMatch((Integer val) -> val >10);
        System.out.println("allMatch(): iaNoValueGreaterThanThree "+iaNoValueGreaterThanThree);

        // findFirst()
        // findAny()


    }
}
