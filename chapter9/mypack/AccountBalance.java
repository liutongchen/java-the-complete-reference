//a simple package
package mypack;

class Balance {
    String name;
    double bal;

    Balance(String n, double b) {
        name = n;
        bal = b;
    }

    void show() {
        if (bal < 0) {
            System.out.println(" ---> ");
        }
        System.out.print(name + ": $" + bal);
    }
}

class AccountBalance {
    public static void main(String[] args) {
        Balance current[] = new Balance[3];
        current[0] = new Balance("Liutong", 1234567890);
        current[1] = new Balance("Lifu", 123456789);
        current[2] = new Balance("Dwight", -4567);

        for (int i = 0; i < 3; i++) {
            current[i].show();
        }
    }
}