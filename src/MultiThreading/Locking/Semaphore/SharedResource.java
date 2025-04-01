package MultiThreading.Locking.Semaphore;


import java.util.concurrent.Semaphore;

public class SharedResource {

    boolean isAvailable;
    Semaphore lock = new Semaphore(2);

    public void produce() {

        try{
            lock.acquire();
            System.out.println("Lock Acquired by: "+Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(8000);
        }catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        finally {
            System.out.println("Lock Released by: " + Thread.currentThread().getName());
            lock.release();
        }
    }

}

