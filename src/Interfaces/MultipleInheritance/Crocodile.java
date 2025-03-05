package Interfaces.MultipleInheritance;

public class Crocodile implements LandAnimal, WaterAnimal{
    /**
     * In Java Multiple Inheritance is possible using Interfaces only
     * Implementing Multiple inheritance through interfaces
     * We cannot do this via classes due to the diamond problem
     * Imagine if the same was done using classes then the client class
     * will not be able to resolve which canBreather() function to actually call
     * during runtime
     */
    @Override
    public boolean canBreathe(){
        System.out.println("Crocodile can breathe");
        return true;
    }
}
