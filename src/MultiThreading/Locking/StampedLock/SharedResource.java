package MultiThreading.Locking.StampedLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    boolean isAvailable;
    StampedLock lock = new StampedLock();

    public void produce() {
        long stamp = lock.readLock();
        try{
            System.out.println("Read Lock Acquired by: "+Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(8000);
        }catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        finally {
            lock.unlockRead(stamp);
            System.out.println("Read Lock Released by: " + Thread.currentThread().getName());
        }
    }
    public void consume() {
        long stamp = lock.writeLock();
        try{
            System.out.println("Write Lock Acquired by: "+Thread.currentThread().getName());
            isAvailable = false;
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
