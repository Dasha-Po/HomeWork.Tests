import accounts.CheckingAccount;
import accounts.CreditAccount;
import accounts.SavingsAccount;
import clients.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AccountsTest {

    Client client = new Client("Petya", 2);
    CheckingAccount checkingAccount = new CheckingAccount("checking", 350);
    CreditAccount creditAccount = new CreditAccount("credit", 0);
    SavingsAccount savingsAccount = new SavingsAccount("saving", 100);

    @Test
    public void testPayCheckingAccount() {
        boolean result = checkingAccount.pay(500);
        Assertions.assertEquals(result, false);
    }

    @Test
    public void testAddCreditAccount() {
        boolean result = creditAccount.add(500);
        Assertions.assertEquals(result, false);
    }

    @Test
    public void testPaySavingAccount() {
        boolean result = savingsAccount.pay(300);
        Assertions.assertEquals(result, false);
    }

    @Test
    public void testPayClient() {
        boolean result = client.pay(400);
        Assertions.assertFalse(result);
    }

    @Test
    public void testTransferAccount() {
        boolean result = checkingAccount.transfer(creditAccount, 100);
        Assertions.assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 20, 50})
    public void testAcceptClient(int arg) {
        boolean result = client.accept(arg);
        Assertions.assertFalse(result);
    }
}
