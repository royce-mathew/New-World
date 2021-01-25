// Import Scanner for input
import java.util.Scanner;

import modules.player;
import modules.util;
import modules.optionHandler;

import modules.story;

class Run {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        

        util.clearScreen();
        util.enterPrompt();

        
        util.print("Hello, welcome to new world.");
        sc.nextLine();


        util.print("To play this game you must verify your age.");
        
        util.nextClearEnter(sc);

        // Check Age
        util. print("Please enter your age");
        int age = sc.nextInt();
        // If age is bigger than 12
        if ( age > 12){
            util.print("Your age is: " + age);
        // If age is not bigger than 12
        } else {
            util.print("You cannot play this game");
            // close the program
            System.exit(0);
        }

        util.nextClearEnter(sc);

        // Run the getName function 
        String name = util.getName(sc);
        player plr = new player(name);

        story mainStory = new story(plr, sc);
        // Optionhandler is private because it stores private variables such as time and other
        optionHandler oHandler = new optionHandler(sc, plr, mainStory);

        mainStory.setOptionHandler(oHandler);
        
        oHandler.tellPart(0);
        oHandler.askOption(0);

    }
    
}

