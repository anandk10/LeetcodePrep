class ZeroEvenOdd {
    private int n;
    Semaphore[] semaphores;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.semaphores = new Semaphore[3];
        this.semaphores[0] = new Semaphore(1);
        this.semaphores[1] = new Semaphore(0);
        this.semaphores[2] = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        boolean printOdd = true;
        for (int i = 0; i < this.n; i++) {
            this.semaphores[0].acquire();
            printNumber.accept(0);
            if (printOdd) {
                this.semaphores[1].release();
            } else {
                this.semaphores[2].release();
            }
            printOdd = !printOdd;
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= this.n; i += 2) {
            this.semaphores[1].acquire();
            printNumber.accept(i);
            this.semaphores[0].release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= this.n; i += 2) {
            this.semaphores[2].acquire();
            printNumber.accept(i);
            this.semaphores[0].release();
        }
    }

}