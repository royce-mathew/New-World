package modules;

import java.util.Scanner;

public class check {

     // Adding private constructor to hide the implicit public one (This was done because of sonarlint warning)
     private check() {
        throw new IllegalStateException("Utility Class");
    }

    // Check Function
    public static int checkNegative(int value){
        if (value > 0) {
            return value;
        } else {
            System.out.println("Error: " + value + " cannot be negative");
            return 0;
        }
    }

    public static String checkString(String value, int length){
        if (value.length() > 0) {
            return value;
        } else {
            System.out.println("Error " + value + " must be longer than length(" + length + ")");
            return "";
        }
    }

    public static int checkIfNumber(Scanner sc, String value){
        try {
            return Integer.parseInt(value);

        } catch (NumberFormatException exception){
            util.print("Invalid input. Please try again.");

            // Try to wait for 1 seconds
            util.wait(1.0);
        
            util.clearScreen();
            String givenInput = sc.nextLine();
            checkIfNumber(sc, givenInput);
        }
        return 0;
    }
    
}
