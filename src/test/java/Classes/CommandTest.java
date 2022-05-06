package Classes;

import Enums.Product;
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
        command = new Command("test command", "test command sample text", "test commands are created", () -> sayHi());
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void createCommand_newCommand_correctlyAddedCommand() {
    }

    @Test
    void execute_() {
    }

    @Test
    void printCommandsTable() {
    }
}