package Interfaces.FunctionalInterface.Consumer;

@FunctionalInterface
public interface Consumer<T> {
    /*
    * Represents an operation, that accepts a single input parameter
    * and returns no results
    * */
    void accept(T t);
}
