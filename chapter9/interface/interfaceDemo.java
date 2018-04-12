interface Callback {
    void callback(int param);
}

class Client implements Callback {
    public void callback(int p) {
        System.out.println("callback called with " + p);
    }

    void nonIfaceMeth() {
        System.out.println("Other members of the class except for interfaces---------");
    }
}

class AnotherClient implements Callback {
    public void callback(int p) {
        System.out.println("Another version of callback");
        System.out.println("p squared is " + (p * p));
    }
}

// a class including an interface but does not fully implement the methods required by interface must be abstract
abstract class Imcomplete implements Callback {
    int a, b;
    void show() {
        System.out.println(a + " " + b);
    }
}

//-----A nested interface example----------
class A {
    // define a nested interface
    public interface NestedIF {
        boolean isNotNegative(int x);
    }
}

class B implements A.NestedIF {
    // implements the nested interface
    public boolean isNotNegative(int x) {
        return x < 0 ? false : true;
    }
}


//--------integer stack interface---------
interface IntStack {
    // define an interger stack interface
    void push(int item);
    int pop();
}

class FixedStack implements IntStack {
    //An implementation of IntStake that uses fixed storage.
    private int stck[];
    private int total;

    // allocate and initialze stack
    FixedStack(int size) {
        stck = new int[size];
        total = 0;
    }

    // push an item onto the stack
    public void push(int item) {
        if (total < stck.length) {
            stck[total++] = item;
        } else {
            System.out.println("Stack is full.");
        }
    }

    // pop an item from the stack
    public int pop() {
        if (total < 0) {
            System.out.println("Stack undeflow");
            return 0;
        } else {
            return stck[--total];
        }
    }
}

class DynamicStack implements IntStack {
    private int stck[];
    private int total;

    DynamicStack(int size) {
        stck = new int[size];
        total = 0;
    }

    public void push(int item) {
        int stckLen = stck.length;

        if (total == stckLen) {
            int[] temp = new int[stckLen * 2];
            for (int i = 0; i < stckLen; i++) {
                temp[i] = stck[i];
            }
            stck = temp;
            stck[total++] = item;
        } else {
            stck[total++] = item;
        }
    }

    public int pop() {
        if (total < 0) {
            System.out.println("Stack underflow.");
            return 0;
        } else {
            return stck[--total];
        }
    }
}

class interfaceDemo {
    public static void main(String args[]) {
        //------top-level interface trail---------
//        Callback c = new Client();
//        AnotherClient ob = new AnotherClient();
//
//        c.callback(42);
//        c = ob;
//        c.callback(42);
        //------nested interface trail---------
//        A.NestedIF nif = new B();
//        if (nif.isNotNegative(10)) {
//            System.out.println("10 is not negative");
//        }
1 + 3 * 5
        //------stack interface---------
        FixedStack myFixedStack = new FixedStack(5);
        DynamicStack myDynStack = new DynamicStack(8);

        // push some numbers onto the stack
        for (int i = 0; i < 5; i++) {
            myFixedStack.push(i);
        }
        for (int i = 0; i < 18; i++) {
            myDynStack.push(i);
        }

        //pop those numbers off the stack
        System.out.println("Stack in myFixedStack");
        for (int i = 0; i < 5; i++) {
            System.out.println(myFixedStack.pop());
        }
        System.out.println("Stack in myDynStack");
        for (int i = 0; i < 18; i++) {
            System.out.println(myDynStack.pop());
        }
    }
}