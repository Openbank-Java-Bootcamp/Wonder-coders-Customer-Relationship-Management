package Classes;

import java.util.Scanner;

public class AppHelp {

    // Ask user for a String
    public static String askForString(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        String entry = "";
        boolean done = false;
        do {
            try {
                entry = scanner.nextLine();
                done = true;
            } catch (Exception e) {
                System.err.println("You did not introduce a valid text");
                scanner.next();
            }
        } while (!done);
        return entry;
    }

    //Ask user for an integer
    public static int askForInt(String question){
        boolean done = false;
        int entry = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println(question);
                entry = scanner.nextInt();
                done = true;
            } catch(Exception e){
                System.out.println("\nYou did not introduce a valid integer. Please try again.");
                scanner.next();
            }
        }while(!done);
        return entry;
    }

    // Ask for an integer within a range
    public static int askForIntInRange(String question, int min, int max) {
        boolean done = false;
        int entry = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println(question);
                entry = scanner.nextInt();
                while (entry < min || entry > max) {
                    System.err.println(entry + " is not a valid option");
                    entry = scanner.nextInt();
                }
                done = true;
            } catch (Exception e) {
                System.err.println("You did not introduce a valid integer. Please try again.");
                scanner.next();
            }
        } while (!done);
        return entry;
    }
    //Select an option from a list
    public static int selectOption(String instruction, String[] optionsList) {
        //Show menu
        System.out.println("\n" + instruction);
        printList(optionsList);
        //Ask for selected option
        int response = askForIntInRange("\n-> Type a number from 1 to " + (optionsList.length), 1, optionsList.length);
        //Show selected option
        if (response > 0 && response < optionsList.length + 1) {
            System.out.println("You have selected option " + response + ": " + optionsList[response - 1] + "\n");
        }
        return response - 1;
    }
    //Print List
    public static void printList(String[] optionsList) {
        for (int i = 0; i < optionsList.length; i++) {
            System.out.println("\t\t" + (i + 1) + "." + optionsList[i]);
        }
    }

}
