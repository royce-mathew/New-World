// Package : Tells the program that this class is stored inside a folder
package modules;

// Check class : This class is used for checking input from the user
public class check {

     // Adding private constructor to hide the implicit public one (This was done because of the sonarlint from vscode warning)
     private check() {
        throw new IllegalStateException("Utility Class");
    }

    /* Private Methods */
    private static String restateInput(){
        // Tell user that their input was invalid
        util.print("Invalid input. Please try again.\nEnter Value:");

        // Try to wait for 1 seconds
        util.wait(1.0);
    
        // Get input again and return it
       return util.nextLine();
    }

    // checkNegative method : Checks if an integer is negative
    public static int checkNegative(int value){

        // If the value passed is over 0
        if (value > 0) {
            // Return the value
            return value;
        } else {
            // If the value passed is above 0
            restateInput();
            util.print("Error: " + value + " cannot be negative");
            return 0;
        }
    }

    // checkStringLength method : Checks if the passed string's length is bigger than the passed length
    public static String checkStringLength(String value, int length){
        // if the length of the string is bigger than or equal to the length passed
        if (value.length() >= length) {
            // Return the string
            return value;

        // The string's length is lesser than the passed value
        } else {
            // Tell user error
            util.print("Error: " + value + " must be longer than length(" + length + ")");

            // Run this method again with the new string that the player has inputted using the restateInput method
            return checkStringLength(restateInput(), length);
        }
    }


    // This method checks if a string can be converted to a number
    public static int checkIfNumber(String value){
         // Check if there even is a string
         if (value.compareTo("") == 0) { restateInput(); }

        // Try statement (Since parseInt can return an exception)
        try {

            // Try to convert the String to an integer, if converting works, return.
            return Integer.parseInt(value);

        // If we catch an exception while converting the string to int
        } catch (NumberFormatException exception){

            util.print("Error: " + value + " was not a number.");
            
            // Try to get the input again
            return checkIfNumber(restateInput());
        }
    }

    
    // This method checks if a string can be converted to a number while also taking a range parameter which checks if the number is inside the range
    public static int checkIfNumber(String value, int range){
        // Check if there even is a string
        if (value.compareTo("") == 0) { restateInput(); }

        // Try statement (Since parseInt can return an exception)
        try {

            // Try to convert the string to an integer
            int newInt = Integer.parseInt(value);

            // If that integer is in range
            if (newInt <= range && newInt >= 0){

                // Return the int
                return newInt;
            } else {
                // Tell the user what to fix
                util.print("Error: " + value + " must be in range of 0-" + range );
                // Try to get input again
               return checkIfNumber(restateInput(), range);
            }

        // If the string is not a number 
        } catch (NumberFormatException exception){
            util.print("Error: " + value + " was not a number.");
            // Try to get input again
            return checkIfNumber(restateInput(), range);
        }
    }
    
}
