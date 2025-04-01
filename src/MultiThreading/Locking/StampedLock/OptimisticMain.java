package MultiThreading.Locking.StampedLock;

public class OptimisticMain {
    public static void main(String[] args) {

        OptimisticSharedResource sharedResource = new OptimisticSharedResource();
        Thread thread1 = new Thread(() -> {
            System.out.println("thread1 Thread: " + Thread.currentThread().getName());
            sharedResource.produce();
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("thread2 Thread: " + Thread.currentThread().getName());
            sharedResource.consume();
        });
        thread1.start();
        thread2.start();
    }
}
