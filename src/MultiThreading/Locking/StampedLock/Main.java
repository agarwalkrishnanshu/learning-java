package MultiThreading.Locking.StampedLock;

public class Main {
    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();
        Thread thread1 = new Thread(() -> {
            System.out.println("thread1 Thread: "+Thread.currentThread().getName());
            sharedResource.produce();
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("thread2 Thread: "+Thread.currentThread().getName());
            sharedResource.produce();
        });
        Thread thread3 = new Thread(() -> {
            System.out.println("thread3 Thread: "+Thread.currentThread().getName());
            sharedResource.consume();
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
