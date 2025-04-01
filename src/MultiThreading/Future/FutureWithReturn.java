package MultiThreading.Future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureWithReturn {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        // Use Case 2
        List<Integer> output = new ArrayList<>();
        Future<List<Integer>> futureObject = threadPoolExecutor.submit(new MyRunnable(output), output);

        try{
            futureObject.get();

            // 1 way
            System.out.println(output.get(0));

            // 2nd way
            List<Integer> result = futureObject.get();
            System.out.println(result.get(0));


        } catch (InterruptedException e) {
            System.out.println("InterruptedException Exception");
        } catch (Exception e) {
            System.out.println("Exception");
        }

        threadPoolExecutor.shutdown();
    }
}

