package concurrency.fizzbuzz;

import java.util.function.IntConsumer;

public class TestFizzBuzz {

    public static void main(String[] args) {

        FizzBuzzMultithreaded fizzBuzz = new FizzBuzzMultithreaded(15);
        Thread threadA = new Thread(() -> {
            try {
                fizzBuzz.fizz(new RunnableImp("Fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                fizzBuzz.buzz(new RunnableImp("Buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(new RunnableImp("FizzBuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        IntConsumer ic = System.out::println;
        Thread threadD = new Thread(() -> {
            try {
                fizzBuzz.number(ic);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}
