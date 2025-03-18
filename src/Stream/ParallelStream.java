package Stream;

import java.util.Arrays;
import java.util.List;

public class ParallelStream {
    public static void main(String[] args) {
        /*
        *
        *  */
        List<Integer> numbers = Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88, 99, 110, 121);

        // sequential processing
        long sequentialprocessingStartTime = System.currentTimeMillis();
        numbers.stream()
                .map((Integer val) -> val * val)
                .forEach(System.out::println);
        System.out.println("Sequential Processing Time Taken: " + (System.currentTimeMillis() - sequentialprocessingStartTime) + " milliseconds" );

        // Parallel Processing
        long parallelProcessingStartTime = System.currentTimeMillis();
        numbers.parallelStream()
                .map((Integer val) -> val * val)
                .forEach(System.out::println);
        System.out.println("Parallel Processing Time Taken: " + (System.currentTimeMillis() - parallelProcessingStartTime) + " milliseconds" );


    }
}
