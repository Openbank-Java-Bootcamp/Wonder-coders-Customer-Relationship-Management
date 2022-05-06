package Classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private Command command;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    public static void sayHi() {
        System.out.println("Hi!");
    }

    @BeforeEach
    void setUp() {
        command = new Command("test command", "command sample text", "test commands are created", () -> sayHi());
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void initializeAndExitApp() {
        assertEquals(false, App.isExit());
        App.exitApp();
        assertEquals(true, App.isExit());
    }



    @Test
    public void runCommand(){
        App.currentCommand = "test command";
        assertEquals("test command", App.currentCommand);
        Command.getCommandsList().get(App.currentCommand).execute();
        String expected = "Hi!";
        String output = outputStreamCaptor.toString().trim();
        assertEquals(expected, output);
    }
}