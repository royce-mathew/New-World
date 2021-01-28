// Package : Tells the program that this class is stored inside a folder
package modules;

// Check class : This class is used for checking input from the user
public class check {

     // Adding private constructor to hide the implicit public one (This was done because of the sonarlint from vscode warning)
     private check() {
        throw new IllegalStateException("Utility Class");
    }

    /* Private Methods */
    /**
     * This method gets the user input again and then returns it. Normally used if the user inputted 
     * something wrong like a String instead of int or a negative integer and so on.
     * 
     * @return The new user input.
     */
    private static String restateInput(){
        // Tell user that their input was invalid
        util.print("Invalid input. Please try again.\nEnter Value:");

        // Try to wait for 1 seconds
        util.wait(1.0);
    
        // Get input again and return it
       return util.nextLine();
    }

    /* Public Methods */
    /**
     * This method checks if a integer is negative
     * 
     * @param value The value to check if negative
     * @return The value passed if it is positive or a new user input
     */
    public static int checkNegative(int value){

        // If the value passed is over 0
        if (value > 0) {
            // Return the value
            return value;
        } else {
            // If the value passed is below 0
            util.print("Error: " + value + " cannot be negative");
            // Get the input again
            String newInput = restateInput();

            // Check if the input is a number and also check if the input is negative again.
            return checkNegative(checkIfNumber(newInput));
        }
    }

    /**
     * Checks if the passed string's length is bigger than or equal to the passed length
     * 
     * @param value The string that will be checked for it's length
     * @param length The length of the string that is acceptable
     * 
     * @return The same value passed if it passes the check or a new input from the user
     */
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

    /**
     * Checks if a string can be converted a number, if it can't then tries to get input 
     * again from the user and then converts it to a number
     * 
     * @param value The string value that will be converted to a number
     * 
     * @return The int value that is the converted value of the passed parameter.
     */
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

    
    /**
     * This method checks if a string can be converted to a integer while also taking a range parameter 
     * which checks if the integer is inside the range
     * 
     * @param value The String to be converted to a integer
     * @param range The range that the integer can be
     * 
     * @return The passed parameter or a new input converted to a integer
     */
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
