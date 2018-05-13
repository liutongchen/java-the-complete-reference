
class NewThread implements Runnable {
    String name;
    Thread t;
    boolean suspendFlag;

    NewThread(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New Thread: " + t);
        suspendFlag = false;
    }

    // entry point for the thread
    public void run() {
        try {
            for (int i = 0; i < 15; i++) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized(this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted");
        }
        System.out.println(name + " existing");
    }

    synchronized void mysuspend() {
        suspendFlag = true;
    }

    synchronized void myresume() {
        suspendFlag = false;
        notify();
    }
}

class SuspendResume {
    public static void main(String args[]) {
        NewThread ob1 = new NewThread("ONE");
        NewThread ob2 = new NewThread("TWO");

        ob1.t.start();
        ob2.t.start();

        try {
            Thread.sleep(1000);  // should print to 5 for ob1 and ob2
            ob1.mysuspend();
            System.out.println("Suspending thread ONE");
            Thread.sleep(1000);
            ob1.myresume(); 
            System.out.println("Resuming thread ONE");
            ob2.mysuspend();
            System.out.println("Suspending thread TWO");
            Thread.sleep(1000);
            ob2.myresume();
            System.out.println("Resuming thread TWO");
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread existing");
    }
}