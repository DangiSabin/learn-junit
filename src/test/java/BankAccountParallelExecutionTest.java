import org.example.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParallelExecutionTest {

    @Test
    @DisplayName("Deposit 500 successfully from method1")
    public void testDeposit1(BankAccount bankAccount){
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        bankAccount.deposit(500);
        assertEquals(500,bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 500 successfully from method2")
    public void testDeposit2(BankAccount bankAccount){
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        bankAccount.deposit(500);
        assertEquals(500,bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 500 successfully from method3")
    public void testDeposit3(BankAccount bankAccount){
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        bankAccount.deposit(500);
        assertEquals(500,bankAccount.getBalance());
    }


}
