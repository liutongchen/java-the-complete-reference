import java.util.Random;
import java.util.Arrays;

class OneCatchException {
    int a = 0, b = 0, c = 0;
    Random r = new Random();

    OneCatchException() {
        for (int i=0; i<32000; i++) {
            try {
                b = r.nextInt();
                c = r.nextInt();
                a = 12345 / (b/c);
            } catch (ArithmeticException e) {
                System.out.println("Exception caused by division by zero: " + e);
                a = 0; // set a to zero and continue
            }
            System.out.println("a: " + a);
        }
    }
}

class MultipleCatchException {
    MultipleCatchException(String args[]) {
        try {
            int a = args.length;
            System.out.println("a = " + a);
            int b = 42 / a;
            int c[] = new int[] { 1, 2 };
            System.out.println("---------C array: " + Arrays.toString(c));
            c[42] = 99;
        } catch (ArithmeticException e) {
            System.out.println("Divide by 0: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index oob: " + e);
        }
        System.out.println("After try/catch blocks.");
    }
}

class CustomException extends Exception{
    private int detail;

    CustomException(int a) {
        detail = a;
    }

    public String toString() {
        return "My exception: [" + detail + "]";
    }
}

// Exception is a subclass of Throwable, which overrides toString() method
class ErrorHandler {
    static void compute(int a) throws CustomException {
        System.out.println("Called compute(" + a + ")");
        if (a > 10) {
            throw new CustomException(a);
        }
        System.out.println("Normal exit");
    }

    public static void main(String[] args) {
//        OneCatchException oneCatchBlock = new OneCatchException();
//        MultipleCatchException multipleCatchBlock = new MultipleCatchException(args);
        try {
            compute(1);
            compute(20);
        } catch (CustomException e) {
            System.out.println("Caught: " + e);
        }
    }
}