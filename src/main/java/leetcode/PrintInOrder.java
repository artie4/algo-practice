package leetcode;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class PrintInOrder {

    public static void main(String[] args) {

        Runnable firstRunnable = () -> System.out.println("first");
        Runnable secondRunnable = () -> System.out.println("second");
        Runnable thirdRunnable = () -> System.out.println("third");

        Foo foo = new Foo();

        new Thread(() -> {
            try {
                foo.first(firstRunnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                foo.third(thirdRunnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                foo.second(secondRunnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }

    static class Foo {

        volatile int counter = 1;
        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            counter++;
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (counter < 2) {
                Thread.onSpinWait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            counter++;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (counter < 3) {
                Thread.onSpinWait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            counter++;

        }
    }
}
