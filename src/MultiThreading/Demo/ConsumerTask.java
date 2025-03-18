package MultiThreading.Demo;

public class ConsumerTask implements Runnable{
    SharedResource sharedResource;

    ConsumerTask(SharedResource sr){
        this.sharedResource = sr;
    }
    @Override
    public void run() {
        System.out.println("Consumer is trying to consume item..."+Thread.currentThread().getName());
        sharedResource.consumeItem();
    }
}
