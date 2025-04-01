package MultiThreading.Future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureCallable {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        Future<List<Integer>> futureObj = threadPoolExecutor.submit(()-> {
            // do something
            List<Integer> output = new ArrayList<>();
            output.add(300);
            return output;
        });

        try{
            List<Integer> output = futureObj.get();
            System.out.println(output.getFirst());
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        } catch (Exception e){

        }

        threadPoolExecutor.shutdown();
    }
}
