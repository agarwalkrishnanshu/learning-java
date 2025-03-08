package Reflection.Annotations.UserDefinedAnnotations.DependencyInjection;


public class DatabaseService {
    String dbName;
    DatabaseService(String dbName){
        this.dbName = dbName;
    }
    public void connect(){
        System.out.println("Connected to Database: "+dbName);
    }
}
