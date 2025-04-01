package MultiThreading.Future;

import java.util.concurrent.*;

public class CompletableFutureDemo {

    public static void main(String[] args) {

        try {

            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 3,
                    TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(10),
                    Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.DiscardPolicy());

            CompletableFuture<String> asyncTask = CompletableFuture.supplyAsync(() -> {
                return "Task Completed";
            }, threadPoolExecutor);

            System.out.println("asyncTask output: "+asyncTask.get());

            // thenApply
            CompletableFuture<String> asyncTask2 = CompletableFuture.supplyAsync(() -> {
                try{
                    System.out.println("Thread Name in supplyAsync: "+ Thread.currentThread().getName());
//                    Thread.sleep(1000);
                }catch (Exception e){

                }
                return "Task Completed";
            }, threadPoolExecutor).thenApply((String val) -> {
                System.out.println("Thread Name in thenApply(): "+ Thread.currentThread().getName());
                return val + " coding";
            });

            System.out.println("asyncTask2: "+asyncTask2.get());

            threadPoolExecutor.shutdown();

        } catch (Exception e){
            System.out.println("Exception: "+ e.getMessage());
        }

    }
}
