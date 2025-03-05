package Interfaces.Polymorphism;

public class Demo {

    public static void main(String[] args) {
        /**
         * We can notice here that interface can act as user defined data type
         * it can store the reference to the classes that implements it.
         * It can resolve which canFly() implementation to call depending
         * on the reference type it is storing at run time
         */
        Bird bird1 = new Hen();
        Bird bird2 = new Eagle();
        bird1.canFly();
        bird2.canFly();
    }

}
