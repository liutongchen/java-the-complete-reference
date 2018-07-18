// demonstrate a simple generic method inside a non-generic class
class GenMethDemo {
    // determin in an object is inside an array
    static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for (int i = 0; i < y.length; i++) {
            if (x.equals(y[i])) return true;
        }
        return false;
    }

    public static void main (String[] args) {
        // use isIn on integers
        Integer[] nums = {1, 2, 3};
        if (isIn(2, nums)) {
            System.out.println("2 is in nums");
        }

        if (!isIn(5, nums)) {
            System.out.println("5 is not in nums");
        }

        System.out.println();

        // use isIn on strings
        String[] strs = {"Jack", "Mary", "Joe"};
        if (isIn("Jack", strs)) {
            System.out.println("Jack is in strs");
        }

        if (!isIn("Helen", strs)) {
            System.out.println("Helen is not in strs");
        }
    }
}