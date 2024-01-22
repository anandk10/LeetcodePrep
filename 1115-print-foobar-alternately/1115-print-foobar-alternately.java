class FooBar {
    private int n;
    boolean doBar = false;
    // Semaphore foo = new Semaphore(1); // the first thread to run uses this
    // Semaphore bar = new Semaphore(0); // the second thread to run uses this


    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (doBar) { wait(); }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            // foo.acquire();
            printFoo.run();
            doBar = true;
            // bar.release();
            notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!doBar) { wait(); }
            // bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            // foo.release();
            doBar = false;
            notifyAll();
        }
    }
}