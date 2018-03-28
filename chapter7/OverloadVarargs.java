class OverloadVarargs {
    static void vaTest(int ... v) {
        System.out.print("vaTest(int...): " + "Number of arguments " + v.length + " contents: ");
        for (int i : v) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void vaTest(boolean ... v) {
        System.out.print("vaTest(bool...): " + "Number of arguments " + v.length + " contents: ");
        for (boolean i : v) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void vaTest(String msg, int ... v) {
        System.out.print("vaTest(string, int ...): " + "arguments " + msg + v.length + " Contents: ");
        for (int i : v) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        vaTest(1, 2, 3);
        vaTest(true, false);
        vaTest("hi", 1, 2, 3, 4);
    }
}