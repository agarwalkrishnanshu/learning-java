package Reflection.Annotations.UserDefinedAnnotations.Logging;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.StreamSupport;

public class LoggingService {
    // Using reflection to implement the logging functionality
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ExampleClass exampleClass = new ExampleClass();

        for (Method method : ExampleClass.class.getDeclaredMethods()){

            if(method.isAnnotationPresent(LogExecutionTime.class)){
                long start = System.currentTimeMillis();
                method.invoke(exampleClass);
                long end = System.currentTimeMillis();
                System.out.println("Execution Time: " + (end - start) + "ms");
            }
        }
    }
}
