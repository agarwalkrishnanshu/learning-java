package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOperationsInStream {
    public static void main(String[] args) {

        // filter(Predicate<T> predicate)
        Stream<Integer> numberStream = Stream.of(10000, 30000, 20000, 40000);
        Stream<Integer> filteredStream = numberStream.filter((Integer val) -> val > 10000);
        List<Integer> filteredList = filteredStream.collect(Collectors.toList());
        System.out.println("Using filter(): "+filteredList);

        // map(Function<T,R> mapper)
        Stream<String> nameStream = Stream.of("Hello", "How", "ARE", "You");
        Stream<String> filteredNameStream = nameStream.map((String val) -> val.toLowerCase());
        List<String> filteredNameList = filteredNameStream.collect(Collectors.toList());
        System.out.println("Using map(): "+filteredNameList);

        // flatMap(Function<T,Stream<R>> mapper)
        List<List<String>> sentenceList = Arrays.asList(
                Arrays.asList("I", "Love", "Java"),
                Arrays.asList("Concepts", "are", "clear")
        );
        Stream<String> wordsStream = sentenceList.stream()
                .flatMap((List<String> sentence) -> sentence.stream());
        Stream<String> filteredWordStream = wordsStream.map((String val) -> val.toLowerCase());
        List<String> filteredWordList = filteredWordStream.collect(Collectors.toList());
        System.out.println("Using flatMap(): "+filteredWordList);

        // distinct()
        Integer[] arr = {1, 5, 2, 7, 4, 4, 2, 0, 9};
        Stream<Integer> arrStream = Arrays.stream(arr).distinct();
        System.out.println("Using distinct: "+ arrStream.collect(Collectors.toList()));

        arrStream = Arrays.stream(arr).sorted();
        System.out.println("Using sorted: "+ arrStream.collect(Collectors.toList()));

        // peek() Helps to see the intermediate result of the stream
        List<Integer> numbers = Arrays.asList(1, 3, 4, 2, 7, 5);
        Stream<Integer> numbersStream = numbers.stream()
                .filter((Integer val) -> val > 2)
                .peek(System.out::println)
                .map((Integer val) -> -1 * val);
        List<Integer> numberList = numbersStream.collect(Collectors.toList());
        System.out.println("Using peek: "+ numberList);

        // using limit
        Stream<Integer> limitNumbersStream = numbers.stream().limit(3);
        List<Integer> limitedNumber = limitNumbersStream.collect(Collectors.toList());
        System.out.println("Using limit: "+limitedNumber);

        // using skip
        Stream<Integer> skipNumbersStream = numbers.stream().skip(3);
        List<Integer> skippedNumber = skipNumbersStream.collect(Collectors.toList());
        System.out.println("Using skip(): "+skippedNumber);

        // Using mapToInt
        // Used for primitive types
        Stream<String> strNumberStream = Stream.of("10000", "30000", "20000", "40000");
        IntStream intStream = strNumberStream.mapToInt((String val) -> Integer.parseInt(val));

        int nums[] = intStream.toArray();
        System.out.println("Using mapToInt(): "+ nums);

        IntStream numStream = Arrays.stream(nums).filter((int val) -> val > 10000);
        int[] filteredNums = numStream.toArray();

    }
}
