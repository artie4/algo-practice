package interview.concurrent;

import java.util.logging.Logger;

//public class Account {
//    private int balane;
//    ReentrantReadWriteLock reentrantLock = new ReentrantReadWriteLock();
//    ReentrantReadWriteLock.WriteLock wr = reentrantLock.writeLock();
//    ReentrantReadWriteLock.ReadLock rd = reentrantLock.readLock();
//
//    public static void transfer(ydx.Account from, ydx.Account to, int val) {
//
//    }
//
//    private void changeBalance(int value) {
//        wr.lock();
//        balane += value;
//        wr.unlock();
//    }
//}

public class Account {

    private Logger logger = Logger.getLogger(Account.class.getName());
    public Account(int balance) {
        this.balance = balance;
    }

    private int balance;

    public int getBalance() {
        return balance;
    }

    public synchronized static void transfer(Account from, Account to, int val) {
        System.out.println(String.format("[Account] transfer %d start from=%d to=%d ", val, from.balance, to.balance));

        from.changeBalance(-val);
        to.changeBalance(val);
        System.out.println(String.format("[Account] transfer %d end from=%d to=%d ", val, from.balance, to.balance));

    }

    private void changeBalance(int value) {
        if (value < 0 && Math.abs(value) > balance) {
            logger.warning("Balance must be positive or 0");
            return;
        }
        balance += value;
    }
}


