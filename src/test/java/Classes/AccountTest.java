package Classes;

import Enums.Industry;
import Enums.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private Account account;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        account= new Account("Mercadeo",Industry.ECOMMERCE,200,"Málaga","Spain");
        System.setOut(new PrintStream(outputStreamCaptor));
        App.currentId = "1";
    }

    @Test
    public void createAccount_ValidData_Account() {
        assertEquals(200, account.getEmployeeCount());
    }

    @Test
    public void lookUpAccounts_ValidData_SystemOut() {
        Account.lookUpAccounts();
        String expected =
                "[0;34m--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ System.getProperty("line.separator") +
                "| ACCOUNT                                                                                                                                                                      |"+System.getProperty("line.separator") +
                "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+System.getProperty("line.separator") +
                "|  ACCOUNT-ID      COMPANY NAME    INDUSTRY         EMPLOYEES NUMBE  CITY             COUNTRY         CONTACTS                                 OPPORTUNITIES                             |"+System.getProperty("line.separator") +
                "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+System.getProperty("line.separator") +
                "|  1               Mercadeo        ECOMMERCE        200              Málaga           Spain           []                                       []                                        |"+System.getProperty("line.separator") +
                "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+System.getProperty("line.separator   ") +"\u001B[0m" ;
        String output = outputStreamCaptor.toString().trim();
        assertEquals(expected, output);
    }
}