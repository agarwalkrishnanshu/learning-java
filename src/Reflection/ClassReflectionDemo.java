package Reflection;

import java.lang.reflect.Modifier;

public class ClassReflectionDemo {
    public static void main(String[] args) {
        /*There are 3 ways to get the class of a class
        * Using Class.forName() function
        * Using the .class with the class
        * Using the object.getClass();
        *
        * */
        try {

//            Class birdUsingForName = Class.forName("Eagle");
//            Eagle eagle = new Eagle();
//            Class birdUsingObject = eagle.getClass();

            Class eagleClass = Eagle.class;
            System.out.println("Class Name: "+eagleClass.getName());
            System.out.println("Class Modifiers: "+Modifier.toString(eagleClass.getModifiers()));

        }catch (Exception ex){
            System.out.println("Exception: "+ ex.getMessage());
        }

    }
}
