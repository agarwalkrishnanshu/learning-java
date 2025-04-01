package MultiThreading.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    boolean isAvailable = false;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void produce() {

        try{
            lock.lock();
            System.out.println("produce(): Lock Acquired by: "+Thread.currentThread().getName());
            if(isAvailable){
                System.out.println("Produce thread is waiting: "+Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = true;
            condition.signal();

        }catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        finally {
            System.out.println("produce(): Lock Released by: " + Thread.currentThread().getName());
            lock.unlock();
        }
    }
    public void consume() {

        try{
            Thread.sleep(3000);
            lock.lock();
            System.out.println("Consumer: Lock Acquired by: "+Thread.currentThread().getName());
            if(!isAvailable){
                System.out.println("Consumer thread is waiting: "+Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = false;
            condition.signal();

        }catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        finally {
            System.out.println("Consumer Lock Released by: " + Thread.currentThread().getName());
            lock.unlock();
        }
    }

}

