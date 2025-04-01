package MultiThreading.ScheduledThreapPoolExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleDemo {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        // Schedule Runnable
        Future<?> obj = scheduledExecutorService.schedule(() ->{
            System.out.println("Thread picked the runnable task");
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e){
                System.out.println("Exception");
            }
            System.out.println("Thread completed the runnable task");
        }, 3, TimeUnit.SECONDS);

        // Schedule Callable
        Future<String> callableObj = scheduledExecutorService.schedule(() ->{
            System.out.println("Thread picked the callable task");
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e){
                System.out.println("Exception");
            }
            System.out.println("Thread completed the callable task");
            return "hello";
        }, 5, TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();
    }
}
