class Stack {
    private int stk[];
    private int total;

    Stack(int size) {
        stk = new int[size];
        total = 0;
    }

    int getLength() {
        return stk.length;
    }

    void push(int item) {
        if (total == stk.length) {
            System.out.println("Stack is full");
        } else {
            stk[total++] = item;
        }
    }

    int pop() {
        if (total <= 0) {
            System.out.println("Stack underflow.");
            return 0;
        } else {
            return stk[--total];
        }

    }
}

class TestStack {
    public static void main(String[] args) {
        Stack mystack1 = new Stack(8);
        Stack mystack2 = new Stack(10);

        int stack1Len = mystack1.getLength();
        int stack2Len = mystack2.getLength();
        // push some numbers onto the stack
        for (int i = 0; i < stack1Len; i++) {
            mystack1.push(i);
        }

        for (int i = 0; i < stack2Len; i++) {
            mystack2.push(i);
        }

        // pop those numbers off the stack
        System.out.println("Stack 1");
        for (int i = 0; i < stack1Len; i++) {
            System.out.println(mystack1.pop());
        }

        System.out.println("Stack 2");
        for (int i = 0; i < stack2Len; i++) {
            System.out.println(mystack2.pop());
        }


    }
}