class NewThread1 implements Runnable {
    // create thread through implementing Runnable
    private Thread t;

    NewThread1() {
        t = new Thread(this, "Demo Thread");
        System.out.println("Child thread: " + t);
    }

    public Thread getNewThread1() {
        return t;
    }

    // This is the entry point for the second thread.
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child Thread1: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child1 interrupted.");
        }
        System.out.println("Existing child1 thread.");
    }
}

class NewThread2 extends Thread {
    // create a new thread by extending Thread
    NewThread2() {
        super("Demo Thread");
        System.out.println("Child thread: " + this);
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child Thread2: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child2 interrupted.");
        }
        System.out.println("Existing child2 thread.");
    }
}

class CurrentThreadDemo {
    public static void main (String[] args) {
        NewThread1 nt1 = new NewThread1();
        NewThread2 nt2 = new NewThread2();

        nt1.getNewThread1().start();
        nt2.start();

        try {
            for (int n = 5; n > 0; n--) {
                System.out.println("Main Thread: " + n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting");
    }
}