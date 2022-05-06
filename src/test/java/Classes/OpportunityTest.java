package Classes;

import Enums.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class OpportunityTest {
    private Opportunity opportunity;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
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
        String expected = "This is the opportunity with id 1" + System.getProperty("line.separator") +
                "Opportunity" + System.getProperty("line.separator") +
                "Id: 1" + System.getProperty("line.separator") +
                "Product: BOX" + System.getProperty("line.separator") +
                "Quantity: 40" + System.getProperty("line.separator") +
                "Decision Maker: {id=1, Name ='Nuria', Phone Number ='123456789', Email ='email@email.com'}" + System.getProperty("line.separator") +
                "Status: OPEN" + System.getProperty("line.separator") +
                "--------------------------------------";
        String output = outputStreamCaptor.toString().trim();
        assertEquals(expected, output);
    }
}