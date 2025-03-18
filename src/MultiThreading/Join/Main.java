package MultiThreading.Join;


public class Main {
    public static void main(String[] args) {
        // join() - it is used to tell the current thread to join the thread on which it is called

        SharedResource resource = new SharedResource();

        System.out.println("Main Thread started");

        Thread thread = new Thread(() -> {
            System.out.println("Thread 1 is calling produce method");
            resource.produce();
        });
        thread.start();
        try{
            System.out.println("Main thread is waiting for thread 1 to finish..");
            thread.join();
        }catch (Exception ex){
            System.out.println("Exception");
        }
        System.out.println("Main thread has finished execution");
    }
}
