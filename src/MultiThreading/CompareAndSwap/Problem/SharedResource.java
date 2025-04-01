package MultiThreading.CompareAndSwap.Problem;

public class SharedResource {

    int count;

    SharedResource(){
        count = 0;
    }
    public void increment(){
        count++;
    }
    public int getCount(){
        return count;
    }
}
