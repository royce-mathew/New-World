package modules;

import java.util.Scanner;

public class util {
    // Adding private constructor to hide the implicit public one (This was done because of sonarlint warning)
    private util() {
        throw new IllegalStateException("Utility Class");
    }

    public static String getName(Scanner sc){
        // Check Name
        util.print("Please enter your name:");
        String name = sc.nextLine();
        name = check.checkString(name, 2);

        if (name.length() == 0){
            util.print("You must choose a name longer than 2 words");
            util.clearScreen();
            getName(sc);
        }

        return name;
    }

    public static void nextClearEnter(Scanner sc){
        sc.nextLine();
        try {
            wait(1.0);
        } catch (Exception InterruptedException){
            print("Error occured while waiting.");
        }

        clearScreen();
        enterPrompt();
       
    }

    public static void clearEnter(){
        try {
            wait(1.0);
        } catch (Exception InterruptedException){
            print("Error occured while waiting.");
        }

        clearScreen();
        enterPrompt();
    }

    public static void enterPrompt(){
        print("==============================");
        print("=  Press ENTER to continue   =");
        print("==============================\n");
    }

    public static void clearScreen() {  
        print("\033[H\033[2J");  
        System.out.flush(); 
    }  

    public static void wait(double sec) {
        long toWait = Math.round(sec*1000);
        try {
            Thread.sleep(toWait);

        } catch (InterruptedException e){
            print("An error occured while waiting, please report this error to the developers.");
            // Restore interrupted state (Code from sonarlint docs)...
            Thread.currentThread().interrupt();
        }
       
    }

    public static void print(String toPrint){
        System.out.println(toPrint);
    }

    public static void printStory(String toPrint){
        for (char s : toPrint.toCharArray()){
            System.out.print(s);
            wait(0.05);
        }
        System.out.println();
    }
}
