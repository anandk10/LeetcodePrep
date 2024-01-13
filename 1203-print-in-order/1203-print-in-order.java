class Foo {
    
    // private AtomicInteger firstJobDone = new AtomicInteger(0);
    // private AtomicInteger secondJobDone = new AtomicInteger(0);

    // User of Semaphore
    Semaphore[] semaphores;
    public Foo() {
        semaphores = new Semaphore[2];
        for (int i = 0; i < semaphores.length; i++) {
            semaphores[i] = new Semaphore(1);
            semaphores[i].acquireUninterruptibly();
        }
    }
    
    // Approach 1
    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphores[0].release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        semaphores[0].acquireUninterruptibly();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphores[0].release();
        semaphores[1].release();
        
    }

    public void third(Runnable printThird) throws InterruptedException {
                
        // printThird.run() outputs "third". Do not change or remove this line.
        semaphores[1].acquireUninterruptibly();
        printThird.run();
        semaphores[1].release();
    }
    
    // Approach 2
    /**
        Based on this comment: https://leetcode.com/problems/print-in-order/solution/355012
        its stated that AtomicInteger consumes more CPU cycles 
    */
    /*
    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        
        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        while(firstJobDone.get() != 1);
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        
        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        while(secondJobDone.get() != 1);
        
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
    */
}