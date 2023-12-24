import org.example.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test BankAccount class")
public class BankAccountAssertionsTest {
    @Test
    @DisplayName("withdraw 300 successfully")
    public void testWithdraw(){
        BankAccount bankAccount=new BankAccount(500,-1000);
        bankAccount.withdraw(300);
        assertEquals(200,bankAccount.getBalance());
    }
    @Test
    @DisplayName("deposit 400 successfully")
    public void testDeposit(){
        BankAccount bankAccount=new BankAccount(400,0);
        bankAccount.deposit(300);
        assertEquals(700,bankAccount.getBalance());
    }

    @Test
    public void testWithdrawNotStuckAtZero(){
        BankAccount bankAccount=new BankAccount(500,-1000);
        bankAccount.withdraw(800);
        assertNotEquals(0,bankAccount.getBalance());
    }

    @Test
    public void testActive(){
        BankAccount bankAccount=new BankAccount(500,0);
        assertTrue(bankAccount.isActive());
    }

    @Test
    public void testBankHolderName(){
        BankAccount bankAccount=new BankAccount(500,0);
        bankAccount.setHolderName("Sabin");
        assertNotNull(bankAccount.getHolderName());
    }
    @Test
    public void testNoWithdrawBelowMinimum(){
        BankAccount bankAccount=new BankAccount(500,-1000);
        assertThrows(RuntimeException.class,()->bankAccount.withdraw(2000));
    }

    @Test
    public void testWithdrawAndDepositWithoutExceptions(){
        BankAccount bankAccount=new BankAccount(500,-1000);
        assertAll(()->bankAccount.deposit(200),()->bankAccount.withdraw(400));
    }
    @Test
    public void testDepositTime(){
        BankAccount bankAccount=new BankAccount(500,-1000);
        assertTimeout(Duration.ofNanos(1),()->bankAccount.deposit(200));
    }
}
