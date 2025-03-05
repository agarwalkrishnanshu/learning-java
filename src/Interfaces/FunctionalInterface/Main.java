package Interfaces.FunctionalInterface;

public class Main {
    public static void main(String[] args) {
        // Using anonymous class - a class without a name

        Bird eagleBird = new Bird() {
            @Override
            public void canFly(String val) {
                System.out.println("Eagle Bird Implementation: " + val);
            }
        };
        eagleBird.canFly("vertical");
    }
}
