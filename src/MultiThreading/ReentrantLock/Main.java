package MultiThreading.ReentrantLock;

import MultiThreading.ProducerConsumerProblem.SharedQueue;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        SharedResource sharedResource1 = new SharedResource();
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread: "+Thread.currentThread().getName());
            sharedResource1.produce(lock);
        });

        SharedResource sharedResource2 = new SharedResource();
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread: "+Thread.currentThread().getName());
            sharedResource2.produce(lock);
        });
        thread1.start();
        thread2.start();

    }
}
