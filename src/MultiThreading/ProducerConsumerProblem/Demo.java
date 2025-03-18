package MultiThreading.ProducerConsumerProblem;

import javax.swing.plaf.TableHeaderUI;

public class Demo {
    public static void main(String[] args) {

        SharedQueue  sharedQueue = new SharedQueue(6);

        Thread producerThread = new Thread(() -> {
            System.out.println("Starting Producer Thread... going to sleep: "+Thread.currentThread().getName());
            try{
                Thread.sleep(10000);
                System.out.println("Producer thread woke up");

            }catch (InterruptedException ex){
                System.out.println("Exception: "+ex.getMessage());
            }
            System.out.println("Producing");
            for(int i = 1; i < 12; i++){
                System.out.println("Producing: "+ (i * 100));
                sharedQueue.produce(i * 100);
            }

        });
        Thread consumerThread = new Thread(() -> {
            System.out.println("Starting Consumer Thread..trying to consume item..."+Thread.currentThread().getName());
            for(int i = 1; i < 12; i++){
                int num = sharedQueue.consumeItem();
                System.out.println("Thread: "+ Thread.currentThread().getName()+ " num: "+num);
            }

        });
        producerThread.start();
        consumerThread.start();
    }
}
