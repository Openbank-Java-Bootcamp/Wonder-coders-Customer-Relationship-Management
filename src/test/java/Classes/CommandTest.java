package Classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

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
    void createCommand_newCommand_correctlyAddedCommand() {
        assertEquals(1, command.getCommandsList().size());
    }

    @Test
    void execute_callCommandExecuteMethod_correctOutput() {
        Command.getCommandsList().get("test command").execute();
        String expected = "Hi!";
        String output = outputStreamCaptor.toString().trim();
        assertEquals(expected, output);
    }

    @Test
    void printCommandsTable_callCommandClassStaticMethod_correctOutput() {
        command.printCommandsTable();
        String expected =
                "[0;34m-------------------------------------------------------------------------------------------------------------------" + System.getProperty("line.separator") +
                "| COMMAND LIST                                                                                                    |" + System.getProperty("line.separator") +
                "-------------------------------------------------------------------------------------------------------------------" + System.getProperty("line.separator") +
                "|  COMMAND                                DESCRIPTION                                                             |" + System.getProperty("line.separator") +
                "-------------------------------------------------------------------------------------------------------------------" + System.getProperty("line.separator") +
                "|  command sample text             -->    test commands are created                                               |" + System.getProperty("line.separator") +
                "-------------------------------------------------------------------------------------------------------------------" + System.getProperty("line.separator") +
                "\u001B[0m";

        String output = outputStreamCaptor.toString().trim();
        assertEquals(expected, output);
    }
}