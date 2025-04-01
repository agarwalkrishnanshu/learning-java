package MultiThreading.Locking.StampedLock;

import java.util.concurrent.locks.StampedLock;

public class OptimisticSharedResource {
    int a = 10;
    StampedLock lock = new StampedLock();

    public void produce() {
        long stamp = lock.tryOptimisticRead();
        try{
            System.out.println("Optimistic Read Lock Acquired by: "+Thread.currentThread().getName());
            a = 11;
            Thread.sleep(8000);
            if(lock.validate(stamp)){
                System.out.println("Value updated successfully. a: "+ a);
            }else{
                // rollback
                a = 10;
                System.out.println("Rollback of changes.. a: "+ a);
            }
        }catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
    public void consume() {
        long stamp = lock.writeLock();
        try{
            System.out.println("Write Lock Acquired by: "+Thread.currentThread().getName());
            a = 9;
            System.out.println(Thread.currentThread().getName() + " updated Value  a: "+a);
            Thread.sleep(8000);
        }catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        finally {
            lock.unlockWrite(stamp);
            System.out.println("Write Lock Released by: " + Thread.currentThread().getName());
        }
    }
}
