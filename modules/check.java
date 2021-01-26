package modules;

import java.util.Scanner;

public class check {

     // Adding private constructor to hide the implicit public one (This was done because of sonarlint warning)
     private check() {
        throw new IllegalStateException("Utility Class");
    }

    /* Private Methods */
    private static String restateInput(Scanner sc){
        // Tell user that their input was invalid
        util.print("Invalid input. Please try again.");

        // Try to wait for 1 seconds
        util.wait(1.0);
    
        // Get input again and return it
       return sc.nextLine();
    }

    // Check Function
    public static int checkNegative(int value){
        if (value > 0) {
            return value;
        } else {
            util.print("Error: " + value + " cannot be negative");
            return 0;
        }
    }

    public static String checkString(String value, int length){
        if (value.length() > 0) {
            return value;
        } else {
            util.print("Error " + value + " must be longer than length(" + length + ")");
            return "";
        }
    }


    // This method checks if a string can be converted to a number
    public static int checkIfNumber(Scanner sc, String value){
         // Check if there even is a string
         if (value.compareTo("") == 0) { restateInput(sc); }

        // Try statement (Since parseInt can return an exception)
        try {

            // Try to convert the String to an integer, if converting works, return.
            return Integer.parseInt(value);

        // If we catch an exception while converting the string to int
        } catch (NumberFormatException exception){

            // Try to get the input again
            return checkIfNumber(sc, restateInput(sc));
        }
    }

    

    public static int checkIfNumber(Scanner sc, String value, int range){
        // Check if there even is a string
        if (value.compareTo("") == 0) { restateInput(sc); }

        // Try statement (Since parseInt can return an exception)
        try {

            // Try to convert the string to an integer
            int newInt = Integer.parseInt(value);

            // If that integer is in range
            if (newInt <= range && newInt >= 0){

                // Return the int
                return newInt;
            } else {

                // Try to get input again
               return checkIfNumber(sc, restateInput(sc), range);
            }

        // If the string is not a number 
        } catch (NumberFormatException exception){

            // Try to get input again
            return checkIfNumber(sc, restateInput(sc), range);
        }
    }
    
}
