package MultiThreading.Locking.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable;
    public void produce(ReentrantLock lock) {

        try{
            lock.lock();
            System.out.println("Lock Acquired by: "+Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(5000);
        }catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        finally {
            lock.unlock();
            System.out.println("Lock Released by: " + Thread.currentThread().getName());
        }

    }
}
