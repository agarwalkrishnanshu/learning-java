package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class SingletonReflectionDemo {
    /*
    * This class is to show how Singletons can be used to break using Reflection
    * To void the above we should use a if condition in the constructor as well.
    * To check if the instance is available then throw exception
    * */
    public static void main(String[] args) {

        try {
            Class eagle = Eagle.class;
            Constructor[] eagleConstructors = eagle.getDeclaredConstructors();

            for (Constructor con : eagleConstructors) {
                System.out.println("Modifier: " + Modifier.toString(con.getModifiers()));
                con.setAccessible(true); // This will make the constructor public
                Eagle eagleObj = (Eagle) con.newInstance();
                eagleObj.fly();

            }
        } catch (Exception ex){
            System.out.println("Exception: "+ex.getMessage());
        }
    }
}
