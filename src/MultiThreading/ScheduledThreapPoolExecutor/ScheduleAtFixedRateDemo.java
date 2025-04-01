package MultiThreading.ScheduledThreapPoolExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleAtFixedRateDemo {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        // Schedule Runnable
        Future<?> obj = scheduledExecutorService.scheduleAtFixedRate(() ->{
            System.out.println("Thread picked the task");
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                System.out.println("Exception: "+e.getMessage());
            }
            System.out.println("Thread completed the task");
        }, 3, 5, TimeUnit.SECONDS);

//        try{
//            Thread.sleep(10000);
//            obj.cancel(true);
//        }catch (InterruptedException e){
//            System.out.println("Exception: "+ e.getMessage());
//        }
        //scheduledExecutorService.shutdown();
    }
}
