package Classes;

import java.util.HashMap;
import java.util.Map;

public class Command {

    private static Map<String, Command> commandsList = new HashMap<>();

    private final String commandText;
    private final String commandSampleText;
    private final String description;
    private final Runnable method;

    public Command(String commandText, String commandSampleText, String description, Runnable method) {
        this.commandText = commandText;
        this.commandSampleText = commandSampleText;
        this.description = description;
        this.method = method;
        commandsList.put(commandText, this);
    }

    public void execute() {
        this.method.run();
    }

    public static Map<String, Command> getCommandsList() {
        return commandsList;
    }

    public static void printCommandsList() {
        commandsList.forEach((key, value) -> {
            System.out.println(value.getCommandSampleText() + " --> " + value.getDescription());
        });
    }
    public static void printCommandsTable() {
        String l1 = "%-2.2s";
        String s1 = "%-30.30s";
        String s2 = "%-7.7s";
        String s3 = "%-70.70s";
        String l2 = "%2.2s";
        String format = l1 + " " + s1 + " " + s2 + " " + s3 + " " + l2;

        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.format(format, "| ","COMMAND", " ", "DESCRIPTION", " |");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        commandsList.forEach((key, value) -> {
            System.out.format(format, "|", value.getCommandSampleText(), " --> ", value.getDescription(), "|");
            System.out.println();
        });
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
    }

    public String getCommandSampleText() {
        return commandSampleText;
    }
    public String getDescription() {
        return description;
    }

}
