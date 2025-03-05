package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class FieldReflectionDemo {
    public static void main(String[] args) {
        Class eagleClass = Eagle.class;

        Field[] fields = eagleClass.getFields(); // This will return only the public fields in this class and its parents
        System.out.println("________Using getFields()_________________________");
        display(fields);

        Field[] declaredFields = eagleClass.getDeclaredFields(); // This will return all the fields in this class only
        System.out.println("________Using getDeclaredFields()__________________");
        display(declaredFields);
    }
    private static void display(Field[] fields) {
        for (Field field : fields) {
            System.out.println("Field Name: " + field.getName());
            System.out.println("Field Type: " + field.getType());
            System.out.println("Modifier: "+ Modifier.toString(field.getModifiers()));
            System.out.println("Class Name: " + field.getDeclaringClass());
            System.out.println("____________________________________________");
        }
    }
}
