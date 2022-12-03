package accounts;

//накопительный счет
public class SavingsAccount extends Account {

    public static final long minBalance = 20;

    //конструктор. Баланс не меньше установленного минимума
    public SavingsAccount(String name, long balance) {
        super(name, balance);
        if (balance > minBalance) {
            this.balance = balance;
        } else {
            this.balance = minBalance;
            System.out.println("Баланс счета не может быть меньше " + minBalance);
            System.out.println("Баланс равен " + minBalance);
        }
    }

    // переопределим платеж, чтоб баланс не был меньше минимального
    @Override
    public boolean pay(long amount) {
        if (balance - amount > minBalance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean add(long amount) {
        balance += amount;
        return true;
    }
}
