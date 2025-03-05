package Interfaces.Polymorphism;

public class Eagle implements Bird{
    @Override
    public boolean canFly() {
        System.out.println("Eagle can fly");
        return true;
    }
}
