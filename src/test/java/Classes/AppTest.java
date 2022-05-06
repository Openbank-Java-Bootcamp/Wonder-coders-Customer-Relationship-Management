package Classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void exitApp() {
    }

    @Test
    void initialize() {
    }

    public void runCommand(){
        int number = 0;
        // COMMANDS:


        Command exit = new Command("exit", "exit", "quit CRM application", () -> exitApp());

            App.currentCommand = null;
            App.currentId = null;

            // Get command from user (case-insensitive)
            String nextCommand = "convert 24";

            // Get generic command and ID in case user's command contains one
            String[] commandWords = nextCommand.split(" ");
            if( commandWords[commandWords.length - 1].replaceAll("[0-9]", "").equals("") ) {
                App.currentId = commandWords[commandWords.length - 1];
                commandWords[commandWords.length - 1] = "#";
            }
            App.currentCommand = String.join(" ", commandWords);

            // Execute command
            if(Command.getCommandsList().containsKey(App.currentCommand)) {
                Command.getCommandsList().get(App.currentCommand).execute();
            } else {
                System.err.println("No command matches '" + nextCommand + "' --> Type 'command list' to see the list of available commands.");
            }

    }
}