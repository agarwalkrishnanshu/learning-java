package Reflection.Annotations.UserDefinedAnnotations.DependencyInjection;

import java.lang.reflect.Field;
import java.util.HashMap;

public class DependencyInjectionExample {
    public static void main(String[] args) throws IllegalAccessException {
        Application application = new Application();

        for(Field field : Application.class.getDeclaredFields()){

            if(field.isAnnotationPresent(Inject.class)){
                field.setAccessible(true);
                field.set(application, new DatabaseService("MySQL"));
            }
        }
        application.start();
    }
}
