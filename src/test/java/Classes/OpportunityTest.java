package Classes;

import Enums.Product;
import Enums.Status;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class OpportunityTest {
    private Opportunity opportunity;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        opportunity = new Opportunity(Product.BOX, 40, new Contact("Nuria", "123456789", "email@email.com"));
        System.setOut(new PrintStream(outputStreamCaptor));
        App.currentId = "1";
    }

    @Test
    public void createOpportunity_ValidData_Opportunity() {
        assertEquals(40, opportunity.getQuantity());
    }

    @Test
    public void lookUpOpportunity_ValidData_SystemOut() {
        Opportunity.lookUpOpportunity();
        String expected =
                "This is the opportunity with id 1" + System.getProperty("line.separator") +
                "[0;34m-------------------------------------------------------------------------------------------------------------------" + System.getProperty("line.separator") +
                "|  ID    PRODUCT    QUANTITY     DECISION MAKER                                                         STATUS    |" + System.getProperty("line.separator") +
                "-------------------------------------------------------------------------------------------------------------------" + System.getProperty("line.separator") +
                "|  1     BOX        40           {id=1, Name ='Nuria'}                                                  OPEN      |" + System.getProperty("line.separator") +
                "-------------------------------------------------------------------------------------------------------------------" + System.getProperty("line.separator") +
                "[0m";
        String output = outputStreamCaptor.toString().trim();
        assertEquals(expected, output);
    }

    @Test
    public void closeWon_ChangeStatus_StatusWon() {
        opportunity.closeWon();
        assertEquals(Status.CLOSED_WON, opportunity.getStatus());
    }

    @Test
    public void closeLost_ChangeStatus_StatusWon() {
        opportunity.closeLost();
        assertEquals(Status.CLOSED_LOST, opportunity.getStatus());
    }
}