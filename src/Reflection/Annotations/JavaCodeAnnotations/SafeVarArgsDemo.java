package Reflection.Annotations.JavaCodeAnnotations;

import java.util.ArrayList;
import java.util.List;

public class SafeVarArgsDemo {
    // If we remove the @SafeVarargs annotation we will see a heap pollution warning

    @SafeVarargs
    @SuppressWarnings("unused")
    public static void printLog(List<Integer>... logNumberList){
        Object objectList[] = logNumberList;

        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        objectList[0] = stringList;
    }
}
