package MultiThreading.ForkJoinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class ForkJoinPoolDemo {
    public static void main(String[] args) {

        ForkJoinPool pool = ForkJoinPool.commonPool();

        long startTime = System.nanoTime();

        Future<Integer> future = pool.submit(new ComputeSumTask(0, 10000));
        try {
            System.out.println(future.get());
            long endTime = System.nanoTime();
            System.out.println("Total Execution Time: " + (endTime - startTime) / 1_000_000_000.0 + " seconds");

        }catch (Exception e){
            System.out.println("Exception: "+e.getMessage());
            System.out.println("Exception: Stack Trace: "+e.getStackTrace());
        }
    }
}
