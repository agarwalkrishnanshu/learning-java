package MultiThreading.CPUUtilizationDemo;

import java.util.concurrent.*;

public class MultiThreadingExample {
    public static void main(String[] args) throws InterruptedException {
        int numThreads = Runtime.getRuntime().availableProcessors(); // Get CPU cores (should be 16)
        System.out.println("Available Logical Processors: " + numThreads);

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        long startTime = System.nanoTime();

        // Submitting 16 CPU-intensive tasks
        for (int i = 0; i < numThreads; i++) {
            executor.submit(() -> {
                long sum = 0;
                for (long j = 0; j < 1_000_000_000L; j++) { // Simulate CPU workload
                    sum += j;
                }
                System.out.println("Thread: " + Thread.currentThread().getName() + " completed.");
            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);

        long endTime = System.nanoTime();
        System.out.println("Total Execution Time: " + (endTime - startTime) / 1_000_000_000.0 + " seconds");
    }
}

