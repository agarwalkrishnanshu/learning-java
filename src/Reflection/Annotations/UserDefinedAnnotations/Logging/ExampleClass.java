package Reflection.Annotations.UserDefinedAnnotations.Logging;

public class ExampleClass {
    @LogExecutionTime
    public void process() throws InterruptedException {
        Thread.sleep(500); // Simulate work
        System.out.println("Processing completed.");
    }
}
