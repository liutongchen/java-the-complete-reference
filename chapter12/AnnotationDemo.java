import java.lang.annotation.*;
import java.lang.reflect.*;

// An annotation type declaration.
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str();
    int val();
}

class AnnotationDemo {

    // Annotate a method
    @MyAnno(str = "Annotation Example", val = 100)
    public static void myMeth(String str, int i) {
        AnnotationDemo ob = new AnnotationDemo();

        // obtain the annotation for this method 
        // and display the values of the members using reflection

        try {
            // first, get a Class object that represents this class
            Class<?> c = ob.getClass();

            // now get a method object that represents this method
            Method m = c.getMethod("myMeth", String.class, int.class);

            // next, get the annotation for this method
            MyAnno anno = m.getAnnotation(MyAnno.class);

            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException exc) {
            System.out.println("Method Not Found.");
        }
    }

    public static void main(String args[]) {
        myMeth("test", 10);
    }
}