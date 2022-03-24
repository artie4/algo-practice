package interview.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class AccountService {

    public static final Map<String, Account> accounts = new HashMap<>();
    static BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    static {
        accounts.put("Germiona", new Account(0));
        accounts.put("Harry", new Account(1000));
        accounts.put("Ron", new Account(0));
        accounts.put("Neville", new Account(0));
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Harry balance = " + accounts.get("Harry").getBalance());
        System.out.println("Germiona balance = " + accounts.get("Germiona").getBalance());
        System.out.println("Ron balance = " + accounts.get("Ron").getBalance());
        System.out.println("Neville balance = " + accounts.get("Neville").getBalance());

        Runnable harryToGerm = () -> {
            Account.transfer(accounts.get("Harry"), accounts.get("Ron"), 100);
        };

        Runnable harryToRon = () -> {
            Account.transfer(accounts.get("Harry"), accounts.get("Germiona"), 100);
        };

        Runnable harryToNeville = () -> {
            Account.transfer(accounts.get("Harry"), accounts.get("Neville"), 100);
        };

        Runnable runnable1 = () -> {
            for (int i = 0; i < 5; i++) {
                queue.offer(harryToRon);
            }
        };

        Runnable runnable2 = () -> {
            for (int i = 0; i < 5; i++) {
                queue.offer(harryToGerm);
            }
        };

        Runnable runnable3 = () -> {
            for (int i = 0; i < 5; i++) {
                queue.offer(harryToNeville);
            }
        };

        new Thread(runnable1).start();
        new Thread(runnable2).start();
        new Thread(runnable3).start();

        TimeUnit.MILLISECONDS.sleep(1500);

        while(!queue.isEmpty()) {
            queue.poll().run();
        }

        TimeUnit.MILLISECONDS.sleep(1500);

        System.out.println("Harry balance = " + accounts.get("Harry").getBalance());
        System.out.println("Germiona balance = " + accounts.get("Germiona").getBalance());
        System.out.println("Ron balance = " + accounts.get("Ron").getBalance());
        System.out.println("Neville balance = " + accounts.get("Neville").getBalance());
    }
}
