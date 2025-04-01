package MultiThreading.CompareAndSwap.Solution;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedResource {

    AtomicInteger count;

    SharedResource(){
        count = new AtomicInteger(0);
    }
    public void increment(){
        count.incrementAndGet();
    }
    public int getCount(){
        return count.get();
    }
}
