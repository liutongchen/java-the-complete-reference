import java.lang.annotation.*;
import java.lang.reflect.*;

// Make MyAnno repeatable
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatedAnnos.class)
@interface MyAnno {
    String str() default "Testing";
    int val() default 9000;
}

// This is the container annotation
@Retention(RetentionPolicy.RUNTIME)
@interface MyRepeatedAnnos {
    MyAnno[] value();
}

class RepeatableAnnoDemo {
    @MyAnno(str = "First Anno", val = -1)
    @MyAnno(str = "Second Anno", val = 100)
    public static void myMeth(String str, int i)
    {
      RepeatableAnnoDemo ob = new RepeatableAnnoDemo();
      
      try {
          Class<?> c = ob.getClass();

          Method m = c.getMethod("myMeth", String.class, int.class);

          Annotation anno = m.getAnnotation(MyRepeatedAnnos.class);
          System.out.println(anno);
      } catch (NoSuchMethodException e) {
          System.out.println("Method not found.");
      }
    }

    
    public static void main(String args[]) {
        myMeth("test", 10);
    }
}