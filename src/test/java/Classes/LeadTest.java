package Classes;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LeadTest {
    private Lead lead;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp(){
        lead = new Lead("Pepe", Integer.toString(655789431), "pepe@gmail.com", "Ironhack");
        System.setOut(new PrintStream(outputStreamCaptor));
        App.currentId = "1";
    }

    @AfterEach
    void tearDown(){
        Lead.removeLead();
    }

    @Test
    public void newLead_validData_newLead(){
        assertEquals(1,Lead.getLeadList().size());
        assertEquals("Ironhack", lead.getCompanyName());
    }

    @Test
    public void lookUpLead_validData_SystemOut(){
        Lead.lookUpLead();
        String expected = "[0;34m-------------------------------------------------------------------------------------------------------------------"+ System.getProperty("line.separator") +
                "| LEAD                                                                                                           |"+ System.getProperty("line.separator")+
                "-------------------------------------------------------------------------------------------------------------------" + System.getProperty("line.separator")+
                "|  ID      NAME                      PHONE NUMBER              EMAIL                     COMPANY NAME               |"+ System.getProperty("line.separator")+
                "-------------------------------------------------------------------------------------------------------------------"+ System.getProperty("line.separator")+
                "|  1       Pepe                      655789431                 pepe@gmail.com            Ironhack                   |" + System.getProperty("line.separator")+
                "-------------------------------------------------------------------------------------------------------------------"+ System.getProperty("line.separator")+ "\u001B[0m";
        String output = outputStreamCaptor.toString().trim();
        assertEquals(expected, output);

    }

    @Test
    public void removeLead_validDate_noLead(){
        Lead.removeLead();
        assertEquals(0, Lead.getLeadList().size());
    }




}