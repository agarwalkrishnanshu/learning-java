package Interfaces.FunctionalInterface;

@FunctionalInterface
public interface Bird {


    /**
     * Functional Interface - have only 1 abstract method
     * But we can have default method, static method and Object class methods
     * Like toString()
     *
     * Since we have provided the @FunctionalInterface annotation
     * then we cannot add another abstract method in this interface
     * It will show an error if we try to
     * If we have not provided the annotation and the interface has only one abstract
     * method even then it is a functional interface but if we try to add another function
     * We will not see any error because the annotation is not there
     * The annotation is not mandatory
     */
    void canFly(String val);
}
