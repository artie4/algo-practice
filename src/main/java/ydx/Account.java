package ydx;

public class Account {

    public Account(int balance) {
        this.balance = balance;
    }

    private int balance;

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account from, Account to, int val) {
        System.out.println(String.format("[Account] transfer %d start from=%d to=%d ", val, from.balance, to.balance));
        from.changeBalance(-val);
        to.changeBalance(val);
        System.out.println(String.format("[Account] transfer %d end from=%d to=%d ", val, from.balance, to.balance));

    }

    private void changeBalance(int value) {
        if (value < 0 && Math.abs(value) > balance) {
            throw new RuntimeException("Balance must be positive or 0");
        }
        balance += value;
    }
}
