package Reflection.Annotations.JavaCodeAnnotations;

public class OverrideDemo implements Bird {

    // Notice the errors
    @Override
    public boolean fly(){
        return true;
    }
}
