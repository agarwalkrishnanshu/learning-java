package Interfaces.Polymorphism;

public class Hen implements Bird{
    @Override
    public boolean canFly() {
        System.out.println("Hen cannot really fly");
        return false;
    }
}
