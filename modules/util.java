// Package : Tells the program that this class is stored inside a folder
package modules;

// Import the java scanner from java util
import java.util.Scanner;

// Imported for running ending music
import java.io.File;

// Utility class (Helps keep other classes clean and also reuse methods)
public class util {

    // The same scanner should be used for all classes that call this class
    private  static Scanner sc = new Scanner(System.in);

    // Adding private constructor to hide the implicit public one (This was done because of sonarlint warning)
    private util() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * GetName method, used for getting name from user, 
     * returns the name of the user and checks the user input if the name is valid
     * 
     * @return The name of the user
    */
    public static String getName(){
        // Prompt
        util.print("Please enter your name:");
        // Run the nextLine method (located at the bottom of this class)
        String name = nextLine();
        // Check if the string is bigger than length 2
        name = check.checkStringLength(name, 2);
        // Return the name
        return name;
    }

    // NextClearEnter Method, waits for user input, clears the screen, and then gives the enter prompt (used in the first part of story)
    public static void nextClearEnter(){
        // Wait for user to press enter
        nextLine();
        // Wait 1 second
        wait(1.0);
        // Clear Screen
        clearScreen();
        // Give enter prompt
        enterPrompt();
    }

    // Clear Enter Method:  Clears the screen, and gives the enter prompt
    public static void clearEnter(){
        // Wait 1 second
        wait(1.0);
        // Clear screen
        clearScreen();
        // Give enter prompt
        enterPrompt();
    }

    // enterPrompt method, Gives the user enter prompt
    public static void enterPrompt(){
        print("==============================");
        print("=  Press ENTER to continue   =");
        print("==============================\n");
    }

    /** 
     * Clear screen method, clears the console
     * The clear screen method might not work on IDE's that keep a log of the command line and don't allow clearing the screen.
     * IDE's such as IntelliJ IDEA and more.
     */
    public static void clearScreen() {  
        // Using ANSI escape codes, this line of code moves the cursor to the first row, first column
        print("\033[H\033[2J"); 
        // Flushes the stream by writing any buffered output bytes to the underlying output stream and then flushing that specified stream.
        System.out.flush(); 
    }  

    // rollCredits method, prints the developer names slowly. This method runs before the program ends the game
    public static void rollCredits(){

        // Get the audio file from resources
        File audioFile = new File("./resources/ending.wav");

        // Game over
        print("Game Over.");
        // Show Developers
        printStory("Developers: \nRoyce Mathew\nXinghao Li\nJien Terence Laure");
        // Thankyou message
        printStory("Thankyou for playing this game. Have a great day.");

        // Run the play sound method with parameter (file : The audio file to play), (toYield : Boolean parameter, tells the program whether to yield or not)
        soundHandler.playSound(audioFile, true);
    }

    /** 
     * Wait method, yields the thread until that time has passed
     * 
     * @param sec The time to yield the thread in seconds 
    */ 
    public static void wait(double sec) {
        // Convert the seconds to milliseconds since Thread.sleep only accepts milliseconds
        long toWait = Math.round(sec*1000);
        
        // Try to put the thread to sleep for toWait milliseconds
        try {
            Thread.sleep(toWait);

        // If we catch an InterruptedException, which usually happens when a thread is waiting, sleeping, or otherwise occupied, and the thread is interrupted, either before or during the activity.
        } catch (InterruptedException e){
            print("An error occured while waiting, please report this error to the developers.");
            // Restore interrupted state (Code from sonarlint docs)...
            Thread.currentThread().interrupt();
        }
       
    }

    /** 
     * Print method, this is used instead of System.out.print to save more time 
     * (Another reason is that, since the whole program will be using this same print method,
     * I can change it in here anytime and it will be implemented in the whole program)
     * 
     * @param toPrint The string that will be printed 
    */
    public static void print(String toPrint){
        // Print the passed string
        System.out.println(toPrint);
    }


    /** 
     * Print story method, using toCharArray (Returns the string converted as a charArray), this method prints the string slowly. 
     * This method of printing better for the player's experience, since seeing static strings appear isn't really that appealing
     * 
     * @param toPrint The string that will be split up into a char array and will be printed
     * 
    */
    public static void printStory(String toPrint){
        // For each string inside the string converted to char Arrray
        for (char s : toPrint.toCharArray()){
            // Print ( Print doesn't print through a line and doesn't use enter ) the char
            System.out.print(s);
            // Wait a very small time
            wait(0.05);
        }
        // Print a blank line after the string is finisihed printing
        print("");
    }

    /**
     * NextLine Method, This is also done similar to the print method, 
     * so that the whole program can be changed just by modifying this nextLine method
     * 
     * @return the user input
    */
     public static String nextLine(){
        return sc.nextLine();
    }
}
