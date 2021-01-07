package ydx;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class AccountService {

    public static final Map<String, Account> accounts = new HashMap<>();

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

        for (int i = 0; i < 5; i++) {
            new Thread(harryToGerm).start();
            new Thread(harryToRon).start();
            new Thread(harryToNeville).start();
        }

        TimeUnit.MILLISECONDS.sleep(1500);

        System.out.println("Harry balance = " + accounts.get("Harry").getBalance());
        System.out.println("Germiona balance = " + accounts.get("Germiona").getBalance());
        System.out.println("Ron balance = " + accounts.get("Ron").getBalance());
        System.out.println("Neville balance = " + accounts.get("Neville").getBalance());
    }

}
