package concurrency.fizzbuzz;

import java.util.function.IntConsumer;

public class FizzBuzzMultithreaded {

    private int n;
    private Integer currInt;

    public FizzBuzzMultithreaded(int n) {
        this.n = n;
        currInt = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (this) {
            while(currInt < n) {
                while(currInt % 3 != 0 && currInt % 5 == 0) wait();
                if(currInt < n)
                    printFizz.run();
                currInt++;
                notifyAll();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (this) {
            while (currInt < n) {
                while(currInt % 5 != 0 && currInt % 3 == 0) wait();
                if(currInt < n)
                    printBuzz.run();
                currInt++;
                notifyAll();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (this) {
            while (currInt < n) {
                while(currInt % 15 != 0) wait();
                if(currInt < n)
                    printFizzBuzz.run();
                currInt++;
                notifyAll();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (currInt < n) {
                while(currInt % 5 == 0 || currInt % 3 == 0) wait();
                if(currInt < n)
                    printNumber.accept(currInt);
                currInt++;
                notifyAll();
            }
        }
    }
}
