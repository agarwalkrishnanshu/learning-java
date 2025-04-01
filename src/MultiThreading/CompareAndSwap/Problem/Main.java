package MultiThreading.CompareAndSwap.Problem;

public class Main {
    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        Thread thread1 = new Thread(()-> {
            for(int i = 0; i < 2000; i++){
                resource.increment();
            }
        });
        Thread thread2 = new Thread(()-> {
            for(int i = 0; i < 2000; i++){
                resource.increment();
            }
        });

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
            System.out.println("Count: "+resource.getCount());
            // Output will not be 4000 because this is not thread safe
        } catch (InterruptedException e) {
            System.out.println("Exception: "+e.getMessage());
        }
    }
}
