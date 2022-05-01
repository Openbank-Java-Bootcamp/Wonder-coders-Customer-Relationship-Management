package Classes;

public class App {

    private static boolean exit = false;
    private static String currentCommand;
    private static String currentId;

    public static String getCurrentId() { return currentId; }

    private static boolean isExit() {
        return exit;
    }

    public static void exitApp() {
        System.out.println("Closing CRM app");
        exit = true;
    }

    public static void initialize() {
        // COMMANDS:
        // OPPORTUNITIES
        Command closeWon = new Command("close-won #", "close-won <IDnumber>", "Closing opportunity with ID = <IDnumber> with status = WON", () -> Command.printCommandsList()); // METHOD !!!
        Command closeLost = new Command("close-lost #", "close-lost <IDnumber>", "Closing opportunity with ID = <IDnumber> with status = LOST", () -> Command.printCommandsList()); // METHOD !!!
        // LEADS
        Command removeLead = new Command("remove #", "remove <IDnumber>", "remove lead with ID = <IDnumber>", () -> Command.printCommandsList()); // METHOD !!!
        Command convertLead = new Command("convert #", "convert <IDnumber>", "convert lead with ID = <IDnumber> to new opportunity", () -> Command.printCommandsList()); // METHOD !!!
        Command findLead = new Command("lookup lead #", "lookup lead <IDnumber>", "print lead with ID = <IDnumber>", () -> Command.printCommandsList()); // METHOD !!!
        Command showLeads = new Command("show leads", "show leads", "print list of all active leads", () -> Command.printCommandsList()); // METHOD !!!
        Command newLead = new Command("new lead", "new lead", "create new lead", () -> Command.printCommandsList()); // METHOD !!!
        // APP
        Command commandList = new Command("command list", "command list", "print list of application's working commands", () -> Command.printCommandsList());
        Command exit = new Command("exit", "exit", "quit CRM application", () -> exitApp());

        do {
            currentCommand = null;
            currentId = null;

            // Get command from user (case-insensitive)
            String nextCommand = AppHelp.askForString("\nEnter next command:").toLowerCase().replaceAll("#", "");

            // Get generic command and ID in case user's command contains one
            String[] commandWords = nextCommand.split(" ");
            if( commandWords[commandWords.length - 1].replaceAll("[0-9]", "").equals("") ) {
                currentId = commandWords[commandWords.length - 1];
                commandWords[commandWords.length - 1] = "#";
            }
            currentCommand = String.join(" ", commandWords);

            // Execute command
            if(Command.getCommandsList().containsKey(currentCommand)) {
                Command.getCommandsList().get(currentCommand).execute();
            } else {
                System.err.println("No command matches '" + nextCommand + "' --> Type 'command list' to see the list of available commands.");
            }

        } while (!isExit());
    }

}
