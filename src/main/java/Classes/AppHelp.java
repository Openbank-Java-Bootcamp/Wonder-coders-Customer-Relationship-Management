package Classes;

import java.util.Scanner;

public class AppHelp {

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

}
