import org.example.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("Test BankAccount class")
public class BankAccountAssumptionsTest {
    @Test
    @DisplayName("Test activation account after certain")
    public void testActive(){
        BankAccount bankAccount=new BankAccount(500,0);
        assumeTrue(bankAccount!=null);
        assertTrue(bankAccount.isActive());
    }
}
