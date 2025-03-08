package Reflection.Annotations.JavaCodeAnnotations;

public class AnnotationsDemo {
    public void deprecatedDemo(){
        // Using a deprecated function or class should show a warning
        DeprecatedDemo deprecatedDemo = new DeprecatedDemo();
        deprecatedDemo.dummy(); // Notice the amazing warning string that is generated due to the parameters we have provided with the annotation

    }
    @SuppressWarnings("deprecation")
    public void suppressWarningDemo(){
        DeprecatedDemo deprecatedDemo = new DeprecatedDemo();
        deprecatedDemo.dummy();
    }

}
