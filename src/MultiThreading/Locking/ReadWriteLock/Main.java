package MultiThreading.Locking.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args) {
        /*
        * If the application has very high read compared to write
        * then it is better to have read write lock
        * */
        ReadWriteLock lock = new ReentrantReadWriteLock();

        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(() -> {
            System.out.println("thread1 Thread: "+Thread.currentThread().getName());
            sharedResource.produce(lock);
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("thread2 Thread: "+Thread.currentThread().getName());
            sharedResource.produce(lock);
        });

        SharedResource sharedResource1 = new SharedResource();
        Thread thread3 = new Thread(() -> {
            System.out.println("thread3 Thread: "+Thread.currentThread().getName());
            sharedResource1.consume(lock);
        });
        thread1.start();
        thread3.start();
        try { Thread.sleep(500); } catch (InterruptedException e) {}
        thread2.start();
    }
}
