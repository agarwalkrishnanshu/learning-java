package MultiThreading.Join;

public class SharedResource {
    public synchronized void produce() {
        System.out.println("Lock Acquired");
        try{
            Thread.sleep(5000);
        }catch (Exception ex){

        }
        System.out.println("Lock Released");

    }
}
