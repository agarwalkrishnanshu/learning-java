package MultiThreading.Demo;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // both threads are using the same object
        Thread producerThread = new Thread(new ProducerTask(sharedResource));
        Thread consumerThread = new Thread(new ConsumerTask(sharedResource));

        producerThread.start();;
        consumerThread.start();

    }
}
