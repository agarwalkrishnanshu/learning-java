package MultiThreading.Demo;

public class SharedResource {
    boolean itemAvailable;

    SharedResource(){
        this.itemAvailable = false;
    }
    // Synchronized so it will put the monitor lock so that only one thread enters this block
    public synchronized void addItem(){
        itemAvailable = true;
        System.out.println("Item added by "+Thread.currentThread().getName()+" and notifying all threads");
        notifyAll();
    }

    public synchronized void consumeItem(){
        System.out.println("consumeItem() invoked by: "+Thread.currentThread().getName());
        // using while loop here to avoid "spurious wake-up", sometimes because of system noise
        while(!itemAvailable){
            try {
                System.out.println("Thread: "+Thread.currentThread().getName()+" is waiting for item.");
                wait(); // it releases the monitor lock
                System.out.println("Consumer Wait is over!!");
            }catch (InterruptedException ex){
                System.out.println("Exception: "+ ex.getMessage());
            }
        }
        System.out.println("Item consumed by: "+Thread.currentThread().getName());
        itemAvailable = false;

    }
}
