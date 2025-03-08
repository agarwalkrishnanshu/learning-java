package Reflection.Annotations.UserDefinedAnnotations.DependencyInjection;

import javax.xml.crypto.Data;

public class Application {
    @Inject
    private DatabaseService databaseService;

    public void start(){
        databaseService.connect();
        System.out.println("Application Started");
    }
}
