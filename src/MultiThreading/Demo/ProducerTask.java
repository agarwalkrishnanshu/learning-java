package MultiThreading.Demo;

public class ProducerTask implements Runnable{
    SharedResource sharedResource;

    ProducerTask(SharedResource sr){
        this.sharedResource = sr;
    }

    @Override
    public void run(){
        System.out.println("Producer Thread is going to sleep: "+Thread.currentThread().getName());
        try{
            Thread.sleep(10000);
            System.out.println("Producer thread woke up..");

        }catch (InterruptedException ex){
            System.out.println("Exception: "+ex.getMessage());
        }
        sharedResource.addItem();
    }

}
