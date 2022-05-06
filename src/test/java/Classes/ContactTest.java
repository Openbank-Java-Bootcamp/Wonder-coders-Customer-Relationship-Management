package Classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {
    private Contact contact;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp(){
        contact = new Contact("Pepe", Integer.toString(655789431), "pepe@gmail.com");
        System.setOut(new PrintStream(outputStreamCaptor));
        App.currentId = "1";
    }

    @Test
    public void newLead_validData_newLead(){
        assertEquals(1,Contact.getContactList().size());
        assertEquals("Pepe", contact.getName());
    }

    @Test
    public void lookUpLead_validData_SystemOut(){
        Contact.lookUpContact();
        String expected = "[0;34m-------------------------------------------------------------------------------------------------------------------"+ System.getProperty("line.separator") +
                "| CONTACT                                                                                                         |"+ System.getProperty("line.separator")+
                "-------------------------------------------------------------------------------------------------------------------" + System.getProperty("line.separator")+
                "|  ID      NAME                              PHONE NUMBER                      EMAIL                              |"+ System.getProperty("line.separator")+
                "-------------------------------------------------------------------------------------------------------------------"+ System.getProperty("line.separator")+
                "|  1       Pepe                              655789431                         pepe@gmail.com                     |" + System.getProperty("line.separator")+
                "-------------------------------------------------------------------------------------------------------------------"+ System.getProperty("line.separator")+ "\u001B[0m";
        String output = outputStreamCaptor.toString().trim();
        assertEquals(expected, output);

    }

}