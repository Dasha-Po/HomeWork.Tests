package accounts;

//кредитный счет
public class CreditAccount extends Account {

    //конструктор, баланс не больше 0
    public CreditAccount(String name, long balance) {
        super(name, balance);
        if (balance > 0) {
            this.balance = 0;
            System.out.println("Баланс кредитного счета не может быть положительным");
            System.out.println("Установлен баланс = 0");
        }
    }

    @Override
    //переопределяем пополнение
    public boolean add(long amount) {
        if (balance + amount <= 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean pay(long amount) {
        balance -= amount;
        return true;
    }
}
