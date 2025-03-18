package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SequenceOfStreamExample {
    public static void main(String[] args) {

        /* INTERESTING OBSERVATION
         Operations like sorting need the complete stream, it cannot do sorting on partial stream
         That is why if we observe the output te filtering and negation happens at once
         But sorting happens only after all the numbers in the start are filtered and negated
*/
        List<Integer> numbers = Arrays.asList(2,1,4,7,10);

        Stream<Integer> numberStream = numbers.stream()
                .filter((Integer val) -> val > 2)
                .peek((Integer val) -> System.out.println("After Filter: "+val))
                .map((Integer val) -> -1*val)
                .peek((Integer val) -> System.out.println("After Negating: "+val))
                .sorted()
                .peek((Integer val) -> System.out.println("After Sorting: "+val));

        List<Integer> numberList = numberStream.collect(Collectors.toList());
        System.out.println("Final output: "+numberList);


    }
}
