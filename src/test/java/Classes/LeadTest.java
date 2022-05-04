package Classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeadTest {
    private Lead lead;

    @BeforeEach
    public void setUp(){
        lead = new Lead("Pepe", Integer.toString(655789431), "pepe@gmail.com", "Ironhack");
    }

    @Test
    public void newLead_goodData_newLead(){
        Lead.newLead();
        assertEquals(2,Lead.getLeadList().size());
    }




}