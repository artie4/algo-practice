package leetcode;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.IntConsumer;

public class MultithreadFizzBuzz {

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

        private volatile int count = 1;
        private volatile ReentrantReadWriteLock reentrantLock = new ReentrantReadWriteLock();
        private volatile ReentrantReadWriteLock.WriteLock writeLock = reentrantLock.writeLock();
        private volatile ReentrantReadWriteLock.ReadLock readLock = reentrantLock.readLock();

        private int n;

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while (count < n) {
                if (getOperation() == Operations.FIZZ) {
                    printFizz.run();
                    incrementCount();
                }
            }
        }


        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while (count < n) {
                if (getOperation() == Operations.BUZZ) {
                    printBuzz.run();
                    incrementCount();
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (count < n) {
                if (getOperation() == Operations.FIZZBUZZ) {
                    printFizzBuzz.run();
                    incrementCount();
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            while (count < n) {
                if (getOperation() == Operations.NONE) {
                    printNumber.accept(count);
                    incrementCount();
                }
            }
        }

        enum Operations {
            FIZZ,
            BUZZ,
            FIZZBUZZ,
            NONE
        }

        // define type of operation
        private Operations getOperation() {
            readLock.lock();
            Operations result;
            if (count % 3 == 0 && count % 5 != 0) result = Operations.FIZZ;
            else if (count % 5 == 0 && count % 3 != 0) result = Operations.BUZZ;
            else if (count % 15 == 0) result = Operations.FIZZBUZZ;
            else result = Operations.NONE;
            readLock.unlock();
            return result;
        }

        private void incrementCount() {
            writeLock.lock();
            count++;
            writeLock.unlock();
        }


        // process
        private void process(int number, Runnable runnable, IntConsumer intConsumer) {
            while (count < n) {

            }
        }
    }
}
