package accounts;

//расчетный счет
public class CheckingAccount extends Account {
    // конструктор. Баланс не меньше 0
    public CheckingAccount(String name, long balance) {
        super(name, balance);
        if (balance < 0) {
            balance = 0;
            System.out.println("Баланс расчетного счета не может быть меньше 0");
            System.out.println("Баланс = 0");
        }
    }

    // переопределяем операцию платежа, чтоб баланс не был меньше 0
    @Override
    public boolean pay(long amount) {
        if (balance - amount >= 0) {
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
