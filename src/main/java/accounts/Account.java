package accounts;

public abstract class Account implements MoneyTarget {

    protected String name;
    protected long balance;

    // конструктор
    public Account(String name, long balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public long getBalance() {
        return balance;
    }

    // операция платеж
    public abstract boolean pay(long amount);

    // операция пополнение
    public abstract boolean add(long amount);

    @Override
    public String toString() {
        return name;
    }

    // операция перевода с текущего счета на счет, указанный в параметрах
    public boolean transfer(Account accountTo, int amount) {
        boolean isTransfer = false;
        if (accountTo.add(amount)) {
            if (pay(amount)) {
                System.out.println("Выполнен перевод со счета " + name + " на счет " + accountTo.getName());
                isTransfer = true;
            } else {
                accountTo.pay(amount);
            }
        } else {
            System.out.println("Невозможно произвести перевод");
        }
        return isTransfer;
    }

    @Override
    public boolean accept(int money) {
        boolean isAccept = false;
        if (add(money)) {
            isAccept = true;
        }
        return isAccept;
    }
}
