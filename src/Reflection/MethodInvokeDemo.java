package Reflection;

import java.lang.reflect.Method;

public class MethodInvokeDemo {
    public static void main(String[] args) {
        try{
            Class eagleClass = Class.forName("Reflection.Eagle");

            Object eagleObject = eagleClass.newInstance();

            Method flyMethod = eagleClass.getMethod("fly", int.class, boolean.class, String.class);
            flyMethod.invoke(eagleObject, 1, true, "String");

        } catch (Exception e) {
            System.out.println("Exception: "+e.getMessage());
        }
    }
}
