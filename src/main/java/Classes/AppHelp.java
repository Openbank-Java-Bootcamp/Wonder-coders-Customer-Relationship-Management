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

}
