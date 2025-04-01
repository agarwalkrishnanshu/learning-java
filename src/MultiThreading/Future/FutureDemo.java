package MultiThreading.Future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        //Use Case 1
        Future<?> futureObj = threadPoolExecutor.submit(() ->{
            try{
                System.out.println("Task with runnable");
                Thread.sleep(7000);
                System.out.println("This is the task, which thread will execute");
            } catch (InterruptedException e) {
                System.out.println("Exception");
            }
        });

        System.out.println("is Done: "+futureObj.isDone());

        try {
            futureObj.get(2, TimeUnit.SECONDS);
        }catch (TimeoutException e) {
            System.out.println("Timeout Exception Occurred: "+e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: "+e.getMessage());
        }

        try{
            Object object = futureObj.get();
            System.out.println(object == null);
        } catch (Exception e) {
            System.out.println("Excception: "+e.getMessage());
        }
        System.out.println("is Done: "+ futureObj.isDone());
        System.out.println("is Cancelled: "+ futureObj.isCancelled());

        // Use Case 2
        List<Integer> output = new ArrayList<>();
        Future<List<Integer>> futureObjct2 = threadPoolExecutor.submit(() -> {
            output.add(100);
            System.out.println("Task 2 wtth Runnable and Return object");
        }, output);
        threadPoolExecutor.shutdown();
    }
}
