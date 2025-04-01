package MultiThreading.ScheduledThreapPoolExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleWithFixedDelayDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        // Schedule Runnable
        Future<?> obj = scheduledExecutorService.scheduleWithFixedDelay(() -> {
            System.out.println("Thread picked the task");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Exception: " + e.getMessage());
            }
            System.out.println("Thread completed the task");
        }, 3, 5, TimeUnit.SECONDS);
    }
}
