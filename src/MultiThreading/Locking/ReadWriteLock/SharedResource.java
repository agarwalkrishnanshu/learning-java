package MultiThreading.Locking.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {

    boolean isAvailable;
    public void produce(ReadWriteLock lock) {
        try{
            lock.readLock().lock();
            System.out.println("Read Lock Acquired by: "+Thread.currentThread().getName());
            Thread.sleep(8000);
        }catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        finally {
            lock.readLock().unlock();
            System.out.println("Read Lock Released by: " + Thread.currentThread().getName());
        }
    }
    public void consume(ReadWriteLock lock) {
        try{
            lock.writeLock().lock();
            System.out.println("Write Lock Acquired by: "+Thread.currentThread().getName());
            isAvailable = false;
            Thread.sleep(8000);
        }catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        finally {
            lock.writeLock().unlock();
            System.out.println("Write Lock Released by: " + Thread.currentThread().getName());
        }
    }
}
