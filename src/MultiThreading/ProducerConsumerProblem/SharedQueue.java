package MultiThreading.ProducerConsumerProblem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Random;

public class SharedQueue {

   private Deque<Integer> queue;
   private Random rand = new Random();
   private int bufferSize;

   public SharedQueue(int size){
       queue = new ArrayDeque<>(10);
       this.bufferSize = size;
   }
   public synchronized void produce(int item){

       // if buffre is full, wait for consumer to consume
       while(queue.size() == bufferSize) {
           System.out.println("Buffer is full, waiting for consumer to consumer");
           try{
               wait();
           }catch (Exception ex){

           }

       }
       queue.offer(item);
       System.out.println(item +" added by: "+Thread.currentThread().getName()+" into the queue. Notifying threads");
       notify(); // to notify any consumer thread that might be waiting

   }
   public synchronized int consumeItem(){

       System.out.println("Consumer Thread: "+ Thread.currentThread().getName() + " is trying to consume item");

       while(queue.isEmpty()){
           System.out.println("No items to consume!! ..Queue is empty");
           try{
               System.out.println(Thread.currentThread().getName()+" is waiting for item");
               wait();
           }catch (Exception ex){
               System.out.println("Exception: "+ex.getMessage());
           }
       }
       int num = queue.poll();
       System.out.println("Consuming from queue: "+num);
       notify(); // to notify any producer thread which might be waiting
       return num;

   }


}
