package MultiThreading.CPUUtilizationDemo;

public class SingleThreadExample {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        long sum = 0;
        for (long j = 0; j < 16_000_000_000L; j++) { // Simulating same workload as multithreaded
            sum += j;
        }

        long endTime = System.nanoTime();
        System.out.println("Total Execution Time: " + (endTime - startTime) / 1_000_000_000.0 + " seconds");
    }
}

