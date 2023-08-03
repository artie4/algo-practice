package interview.concurrent;

import java.util.List;
import java.util.concurrent.*;

public class FutureExample {

    private static ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var firstTask = new Callable<Long>() {
            @Override
            public Long call() {
                long start = System.currentTimeMillis();
                System.out.println("Executing [task-1]");
                waiter(1);
                System.out.println("Finish [task-1]");
                return (System.currentTimeMillis() - start) / 1000;
            }
        };
        var secondTask = new Callable<Long>() {
            @Override
            public Long call() {
                long start = System.currentTimeMillis();
                System.out.println("Executing [task-2]");
                waiter(10);
                System.out.println("Finish [task-2]");
                return (System.currentTimeMillis() - start) / 1000;

            }
        };
        var thirdTask = new Callable<>() {
            @Override
            public Long call() {
                long start = System.currentTimeMillis();
                System.out.println("Executing [task-3]");
                waiter(1);
                System.out.println("Finish [task-3]");
                return (System.currentTimeMillis() - start) / 1000;
            }
        };

        var future1 = executorService.submit(firstTask);
        var future2 = executorService.submit(secondTask);
        var future3 = executorService.submit(thirdTask);

        System.out.println("Second task taken time, s = " + future2.get());
        System.out.println("First task taken time, s = " + future1.get());
        System.out.println("Third task taken time, s = " + future3.get());
        executorService.shutdown();

    }

    public static void waiter(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
