package MultiThreading.ThreadPool;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 1, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2), new CustomThreadFactory(), new CustomRejectHandler());

        threadPoolExecutor.allowCoreThreadTimeOut(true);

        // submit task
        for(int i = 1; i <= 7; i++){
            threadPoolExecutor.submit(() -> {
                try{
                    System.out.println("Started Processing task by "+Thread.currentThread().getName());
                    Thread.sleep(5000);
                    System.out.println("Completed processing by: "+ Thread.currentThread().getName());
                }catch (Exception e){
                    System.out.println("Exception: "+ e.getMessage());
                }
            });
        }
        threadPoolExecutor.shutdown();
    }
}


