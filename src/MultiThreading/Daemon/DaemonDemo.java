package MultiThreading.Daemon;

import MultiThreading.Join.SharedResource;

public class DaemonDemo {
    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        System.out.println("Main Thread started");

        Thread thread = new Thread(() -> {
            System.out.println("Daemon Thread 1 is calling produce method");
            resource.produce();
        });
        thread.setDaemon(true);
        thread.start();

        System.out.println("Main thread has finished execution");

    }
}
