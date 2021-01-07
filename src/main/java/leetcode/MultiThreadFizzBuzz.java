package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.IntConsumer;

public class MultiThreadFizzBuzz {

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.print(" fizz "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.print(" buzz "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.print(" fizzbuzz "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.number((x) -> System.out.print(" " + x + " "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    static class FizzBuzz {

        private final Map<Operations, Object> actions = new HashMap<>();
        private final CyclicBarrier cyclicBarrier = new CyclicBarrier(4, this::process);
        private int n;

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            actions.put(Operations.FIZZ, printFizz);
            toBarrier();
        }


        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            actions.put(Operations.BUZZ, printBuzz);
            toBarrier();
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            actions.put(Operations.FIZZBUZZ, printFizzBuzz);
            toBarrier();
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            actions.put(Operations.NONE, printNumber);
            toBarrier();
        }

        enum Operations {
            FIZZ,
            BUZZ,
            FIZZBUZZ,
            NONE
        }

        // define type of operation
        private Operations getOperation(int count) {
            Operations result;
            if (count % 3 == 0 && count % 5 != 0) result = Operations.FIZZ;
            else if (count % 5 == 0 && count % 3 != 0) result = Operations.BUZZ;
            else if (count % 15 == 0) result = Operations.FIZZBUZZ;
            else result = Operations.NONE;
            return result;
        }

        private void toBarrier() {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        private void process() {
            int count = 1;
            while (count <= n) {
                Operations operation = getOperation(count);
                if (operation == Operations.NONE) {
                    ((IntConsumer) actions.get(operation)).accept(count);
                } else {
                    ((Runnable) actions.get(operation)).run();
                }
                count++;
            }
        }
    }
}
