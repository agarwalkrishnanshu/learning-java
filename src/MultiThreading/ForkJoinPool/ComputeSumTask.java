package MultiThreading.ForkJoinPool;

import java.util.concurrent.RecursiveTask;

public class ComputeSumTask extends RecursiveTask<Integer> {

    int start;
    int end;

    ComputeSumTask(int s, int e){
        this.start = s;
        this.end = e;
    }
    @Override
    protected Integer compute() {

        if(end - start <= 4){
            int totalSum = 0;
            for(int i = start; i < end; i++){
                totalSum += i;
            }
            return totalSum;
        }else {
            int mid = start + (end - start)/2;
            System.out.println("Dividing task into start: "+start + " mid: "+ mid + " end: "+ end);
            ComputeSumTask left = new ComputeSumTask(start, mid);
            ComputeSumTask right = new ComputeSumTask(mid + 1, end);
            left.fork();
            right.fork();

            int leftSum = left.join();
            int rightSum = right.join();

            return leftSum + rightSum;
        }
    }
}
