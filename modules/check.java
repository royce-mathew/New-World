package modules;

import java.util.Scanner;

public class check {

     // Adding private constructor to hide the implicit public one (This was done because of sonarlint warning)
     private check() {
        throw new IllegalStateException("Utility Class");
    }

    /* Private Methods */
    private static void restateInput(Scanner sc){
        // Tell user that their input was invalid
        util.print("Invalid input. Please try again.");

        // Try to wait for 1 seconds
        util.wait(1.0);
    
        // Get input again
        String givenInput = sc.nextLine();

        // Check if that input is a number
        checkIfNumber(sc, givenInput);
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

            // Try to convert the string to an integer 
            return Integer.parseInt(value);

        // If we catch an exception while converting the string to int
        } catch (NumberFormatException exception){

            // Try to get the input again
            restateInput(sc);
        }

        // This line of could should never be reached but just in case, this method will return a -1
        return -1;
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
               restateInput(sc);
            }

        // If the string is not a number 
        } catch (NumberFormatException exception){

            // Try to get input again
           restateInput(sc);
        }

        // This line of could should never be reached but just in case, this method will return a -1
        return -1;
    }
    
}
