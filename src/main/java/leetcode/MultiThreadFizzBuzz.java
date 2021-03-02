package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;
import java.util.function.IntConsumer;

public class MultiThreadFizzBuzz {

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(46);
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

        private final int n;

        public FizzBuzz(int n) {
            this.n = n;
        }

        Phaser phaser1 = new Phaser(2);
        Phaser phaser3 = new Phaser(2);
        Phaser phaser5 = new Phaser(2);
        Phaser phaser15 = new Phaser(2);

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            for (int i = 3; i <= n; i += 3) {
                if (i % 5 == 0) continue;
                phaser3.arriveAndAwaitAdvance();
                printFizz.run();
                phaser1.arrive();
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            for (int i = 5; i <= n; i+=5) {
                if (i % 3 == 0) continue;
                phaser5.arriveAndAwaitAdvance();
                printBuzz.run();
                phaser1.arrive();
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for (int i = 15; i <= n; i+=15) {
                phaser15.arriveAndAwaitAdvance();
                printFizzBuzz.run();
                phaser1.arrive();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 != 0) { phaser3.arrive(); phaser1.arriveAndAwaitAdvance(); }
                else if (i % 5 == 0 && i % 3 != 0) { phaser5.arrive(); phaser1.arriveAndAwaitAdvance(); }
                else if (i % 15 == 0) { phaser15.arrive(); phaser1.arriveAndAwaitAdvance(); }
                else printNumber.accept(i);
            }
            phaser1.arrive();
            phaser3.arrive();
            phaser5.arrive();
            phaser15.arrive();
        }
    }


    static class FizzBuzz2 {

        private final Map<Operations, Object> actions = new HashMap<>();
        private final CyclicBarrier cyclicBarrier = new CyclicBarrier(4, this::process);
        private int n;

        public FizzBuzz2(int n) {
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
