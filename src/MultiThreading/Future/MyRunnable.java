package MultiThreading.Future;

import java.util.List;

public class MyRunnable implements Runnable{

    List<Integer> list;
    MyRunnable(List<Integer> list){
        this.list = list;
    }

    @Override
    public void run() {
        // do something
        list.add(300);
        System.out.println("Run method.. Thread is doing some work");
    }
}
