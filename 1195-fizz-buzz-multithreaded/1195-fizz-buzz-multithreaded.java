class FizzBuzz {
    private int n;
    private int currentNum = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (currentNum <= n) {

            if (currentNum % 3 == 0 && currentNum % 5 != 0) {
                printFizz.run();
                currentNum++;
                notifyAll();
            } else {
                wait();
            }

        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (currentNum <= n) {
            
            if (currentNum % 3 != 0 && currentNum % 5 == 0) {
                printBuzz.run();
                currentNum++;
                notifyAll();
            } else {
                wait();
            }


        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (currentNum <= n) {
            
            if (currentNum % 15 == 0) {
                printFizzBuzz.run();
                currentNum++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (currentNum <= n) {
            
            if (currentNum % 3 != 0 && currentNum % 5 != 0) {
                printNumber.accept(currentNum);
                currentNum++;
                notifyAll();
            } else {
                wait();
            }

        }
    }
}