package Reflection;

import java.lang.reflect.Method;

public class MethodReflectionDemo {
    public static void main(String[] args) {
        Class eagleClass = Eagle.class;

        Method[] methods = eagleClass.getMethods(); // This will return only the public methods in this class and its parents
        System.out.println("________Using getMethods()_________________________");
        display(methods);

        Method[] declaredMethods = eagleClass.getDeclaredMethods(); // This will return all the methods in this class only
        System.out.println("________Using getDeclaredMethods()__________________");
        display(declaredMethods);
    }
    private static void display(Method[] methods){
        for (Method method : methods){
            System.out.println("Method Name: "+ method.getName());
            System.out.println("Method Return Type: "+ method.getReturnType());
            System.out.println("Class Name: "+ method.getDeclaringClass());
            System.out.println("____________________________________________");
        }
    }
}
