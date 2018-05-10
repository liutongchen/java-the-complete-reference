class Callme {
    void call(String msg) {
        System.out.println("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {
    String msg;
    Callme target;
    Thread t;

    public Caller(Callme targ, String s) {
        target = targ;
        msg = s;
        t = new Thread(this);
    }

    // synchronize calls to call()
    public void run() {
        synchronized(target) {
            target.call(msg);
        }
    }

    // unsynchronized calles
//    public void run() {
//        target.call(msg);
//    }
}

class Q {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        while(!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
            System.out.println("Got: " + n);
            valueSet = false;
            notify();
            return n;
    }

    synchronized void put(int n) {
        while(valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
            this.n = n;
            valueSet = true;
            System.out.println("Put: " + n);
            notify();
    }
}

class Producer implements Runnable {
    Q q;
    Thread t;

    Producer(Q q) {
        this.q = q;
        t = new Thread(this, "Producer");
    }

    public void run() {
        int i = 0;
        while (i < 10) {
            q.put(i++);
        }
    }
}

class Consumer implements Runnable {
    Q q;
    Thread t;

    Consumer(Q q) {
        this.q = q;
        t = new Thread(this, "Consumer");
    }

    public void run() {
        while (true) {
            q.get();
        }
    }
}

class SyncThreadDemo {
    public static void main(String args[]) {
        // using synchronized method on objRef

//        Callme target = new Callme();
//        Caller obj1 = new Caller(target, "Hello");
//        Caller obj2 = new Caller(target, "Synchronized");
//        Caller obj3 = new Caller(target, "World");
//
//        // Start the thread
//        obj1.t.start();
//        obj2.t.start();
//        obj3.t.start();
//
//        // wait for threads to end
//        try {
//            obj1.t.join();
//            obj2.t.join();
//            obj3.t.join();
//        } catch(InterruptedException e) {
//            System.out.println("Interrupted");
//        }


        // --------cross thread communication--------
        Q q = new Q();
        Producer p = new Producer(q);
        Consumer c = new Consumer(q);

        // start the threads
        p.t.start();
        c.t.start();

        System.out.println("Press Control-C to strop.");
    }
}