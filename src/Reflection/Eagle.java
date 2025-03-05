package Reflection;

public class Eagle {
    public String breed;
    private boolean canSwim;

    private Eagle(){

    }
    public void fly(){
        System.out.println("Fly Eagle");
    }
    public void fly(int intParam, boolean booleanParam, String strParam){
        System.out.println("IntParam: "+ intParam);
        System.out.println("Boolean Param: "+ booleanParam);
        System.out.println("String Param: "+ strParam);
    }

    public void eat(){
        System.out.println("Eat");
    }
}
