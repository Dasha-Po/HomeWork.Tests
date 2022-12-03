package clients;

import accounts.Account;
import accounts.MoneyTarget;

import java.util.Objects;

public class Client implements MoneyTarget {
    protected String name; // имя клиента
    protected int maxAccounts; // максимальное кол-во открываемых счетов
    protected Account[] accounts;

    //конструктор
    public Client(String name, int maxAccounts) {
        this.name = name;
        this.maxAccounts = maxAccounts;
        this.accounts = new Account[maxAccounts];
    }

    public String getName() {
        return name;
    }

    //метод вывода баланса счетов клиента
    public void getAccountsBalance() {
        for (Account account : accounts) {
            if (account != null) {
                System.out.println(account.getName() + " : " + account.getBalance());
            }
        }
    }

    // Метод добавления нового счёта (приходит параметром);
    // если превышено максимальное количество счетов, то должно выводиться сообщение об этом пользователю
    public void add(Account account) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                return;
            }
        }
        System.out.println("Мест для добавления нового счета нет!");
    }

    // Метод boolean pay(int amount), который ищет счёт, с которого можно будет заплатить переданную параметром сумму и,
    // если находит, платит с этого счёта и возвращает true. Если нет, то возврашает false.

    public boolean pay(int amount) {
        boolean isPayment = false;
        for (Account account : accounts) {
            if (Objects.nonNull(account) && account.pay(amount)) {
                isPayment = true;
                System.out.println("Списано " + amount + " со счета " + account.getName());
                break;
            }
        }
        return isPayment;
    }

    // операция пополнения любого счета клиента
    @Override
    public boolean accept(int money) {
        boolean isAccept = false;
        for (Account account : accounts) {
            if (account != null && account.add(money)) {
                isAccept = true;
                System.out.println("Пополнен счет " + account.getName() + " на " + money);
                break;
            }
        }
        if (!isAccept) {
            System.out.println("Нет счетов, которые можно пополнить");
        }
        return isAccept;
    }
}
