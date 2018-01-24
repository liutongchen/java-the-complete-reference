class Examples {
    public static void main(String arg[]) {
        /**
         * Type conversion and casting
         */
        byte b;
        int i = 257;
        double d = 345.38;
        System.out.println("\nConverstion of int to byte.");
        b = (byte) i;
        System.out.println("i and b: " + i + " " + b);

        System.out.println("\nConversion of double to int.");
        i = (int) d;
        System.out.println("i and d: " + i + " " + d);

        System.out.println("\nConversion of double to byte.");
        b = (byte) d;
        System.out.println("b and d: " + b + " " + d);
    }
}