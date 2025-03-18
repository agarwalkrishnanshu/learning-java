package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WaysToCreateStream {
    public static void main(String[] args) {

        // From Collection
        List<Integer> salaryList = new ArrayList<>();
        salaryList.add(10000);
        salaryList.add(30000);
        salaryList.add(20000);
        salaryList.add(10000);

        Stream<Integer> streamFromIntegerList = salaryList.stream();

        // From Array
        Integer salaryArray[] = {10000, 30000, 20000, 40000};
        Stream<Integer> streamFromIntegerArray = Arrays.stream(salaryArray);

        // From Static Method
        Stream<Integer> streamFromStaticMethod = Stream.of(10000, 30000, 20000, 40000);

        // From Stream Builder
        Stream.Builder<Integer> streamBuilder = Stream.builder();
        streamBuilder.add(10000).add(30000).add(20000).add(40000);
        Stream<Integer> streamFromStreamBuilder = streamBuilder.build();

        // From Stream Iterate
        Stream<Integer> streamFromIterate = Stream.iterate(10000, (Integer n) -> n + 5000).limit(50000);



    }
}
