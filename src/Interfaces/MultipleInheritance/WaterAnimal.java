package Interfaces.MultipleInheritance;

public interface WaterAnimal {
    public boolean canBreathe();

    /**
     * If we add any method to the interface then all the child classes implementing
     * this interface has to be changed
     * So this was a problem or gap
     * In order to solve this From Java 8 onwards default method was introduced in interface
     * You can give the implementation of the default method also
     *
     * If your class is implementing two interfaces with same function signatures
     * then your class is required to provide the implementation of the function
     *
     * @return boolean
     */
    default boolean canWalk(){
        return false;
    }

    /**
     * We can provide the implementation of the static method
     * This method cannot be overridden by the classes that implements this interface
     * We can access it using the interface name itself
     * It is default public (Java 8)
     * @return
     */
    static boolean canDance(){
        return false;
    }

    /**
     * From Java 9
     * We can provide the implementation of the private methods in an interface
     * Private method cannot be abstract so we have to provide the definition
     * It can be used inside the interface only
     * If multiple default methods share the same code then private methods can help
     * It can be static or non-static
     */
    private boolean canRun() {
        return false;
    }
}
