import accounts.CheckingAccount;
import accounts.CreditAccount;
import accounts.SavingsAccount;
import clients.Client;

public class Main {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount("savingAccount", 200);
        CheckingAccount checkingAccount = new CheckingAccount("checkingAccount", 500);
        CreditAccount creditAccount = new CreditAccount("creditAccount", 0);
        Client client = new Client("Mister", 5);
        client.add(savingsAccount);
        client.add(checkingAccount);
        client.add(creditAccount);
        client.getAccountsBalance();
        client.accept(50);
        client.getAccountsBalance();
        savingsAccount.transfer(creditAccount, 100);
        client.getAccountsBalance();
    }
}
