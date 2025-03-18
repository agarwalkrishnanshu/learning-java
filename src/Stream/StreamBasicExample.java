package Stream;

import java.util.ArrayList;
import java.util.List;

public class StreamBasicExample {
    public static void main(String[] args) {

        List<Integer> salaryList = new ArrayList<>();
        salaryList.add(10000);
        salaryList.add(30000);
        salaryList.add(20000);
        salaryList.add(10000);

        int count = 0;
        for(Integer salary: salaryList){
            if(salary > 10000){
                count++;
            }
        }
        System.out.println("Without Stream Employee with Salary > 10000: "+count);

        long output = salaryList.stream().filter((Integer val) -> val > 10000).count();
        System.out.println("With Stream Employee with Salary > 10000: "+output);

    }
}
