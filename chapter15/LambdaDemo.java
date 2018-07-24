// lambda and functional interface
interface NumericTest {
    boolean test(int n);
}

class LambdaDemo {
    public static void main(String[] args) {
        NumericTest isEven = (n) -> (n % 2) == 0;
        if (isEven.test(10)) System.out.println("10 is even");
        if (!isEven.test(9)) System.out.println("9 is NOT even");

        NumericTest isNeg = (n) -> n < 0;
        if (isNeg.test(-1)) System.out.println("-1 is negative");
        if (!isNeg.test(1)) System.out.println("1 is NOT negative");
    }
}