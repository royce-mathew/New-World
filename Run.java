// Import Scanner for input
import java.util.Scanner;

import modules.check;

class Run {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        clearScreen();
        enterPrompt();

        
        print("Hello, welcome to new world.");
        sc.nextLine();


        print("To play this game you must verify your age.");
        sc.nextLine();

        clearScreen();
        enterPrompt();

        // Check Age
        print("Please enter your age");
        int age = sc.nextInt();
        // If age is bigger than 12
        if ( age > 12){
            print("Your age is: " + age);
        // If age is not bigger than 12
        } else {
            print("You cannot play this game");
            // close the program
            System.exit(0);
        }

        sc.nextLine();
        clearScreen();
        enterPrompt();

        // Run the getName function 
        String name = getName(sc);
    }

    public static String getName(Scanner sc){
        // Check Name
        print("Please enter your name:");
        String name = sc.nextLine();
        name = check.checkString(name, 2);

        if (name.length() == 0){
            print("You must choose a name longer than 2 words");
            clearScreen();
            getName(sc);
        }

        return name;
    }

    public static void enterPrompt(){
        print("===========================");
        print("= Press ENTER to continue =");
        print("===========================\n");
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    public static void wait(int sec) throws InterruptedException {
        Thread.sleep(sec*1000);
    }

    public static void print(String toPrint){
        System.out.println(toPrint);
    }
}

