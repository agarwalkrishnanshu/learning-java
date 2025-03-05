package Interfaces.FunctionalInterface;

public class LambdaExpression {
    /**
     * Lambda Expression is a way to implement functional interface in java
     *
     */
    public static void main(String[] args) {
        Bird bird = (String value) -> {
            System.out.println("Using Lambda Expression eagle bird implementation: " + value);
        };
        bird.canFly("vertical");
    }
}
