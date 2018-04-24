class NewThread implements Runnable {
    // create thread through implementing Runnable
    private Thread t;

    NewThread() {
        t = new Thread(this, "Demo Thread");
        System.out.println("Child thread: " + t);
    }

    public Thread getNewThread() {
        return t;
    }

    // This is the entry point for the second thread.
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child Thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted.");
        }
        System.out.println("Existing child thread.");
    }
}

class CurrentThreadDemo {
    public static void main (String[] args) {
        NewThread nt = new NewThread();

        nt.getNewThread().start();

        try {
            for (int n = 5; n > 0; n--) {
                System.out.println("Main Thread: " + n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
    }
}