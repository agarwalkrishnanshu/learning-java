package MultiThreading;

public class Main {
    public static void main(String[] args) {

        System.out.println("Starting to execute Main method: "+ Thread.currentThread().getName());
        MultiThreadingLearning multiThreadingLearning = new MultiThreadingLearning();

        multiThreadingLearning.run();

        Thread thread = new Thread(multiThreadingLearning);
        thread.start();

        System.out.println("Finished Main method: "+ Thread.currentThread().getName());
    }
}
