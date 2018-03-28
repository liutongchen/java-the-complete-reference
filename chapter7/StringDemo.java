class StringDemo {
    public static void main(String args[]) {
        String[] str = {"One", "One", "Two", "Three"};
        for (int i = 0; i < str.length; i++) {
            System.out.println("String: " + str[i]);
            System.out.println("Index at 0: " + str[i].charAt(0));
            if (str[i].equals(str[i+1])) {
                System.out.println("Find two same strings");
            }
        }
    }
}