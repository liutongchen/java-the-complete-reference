class Stack {
    int stk[] = new int[10];
    int total;

    Stack() {
        total = 0;
    }

    void push(int item) {
        if (total == 10) {
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
        Stack mystack1 = new Stack();

        // push some numbers onto the stack
        for (int i = 0; i < 10; i++) {
            mystack1.push(i);
        }

        // pop those numbers off the stack
        for (int i = 0; i < 10; i++) {
            System.out.println(mystack1.pop());
        }
    }
}