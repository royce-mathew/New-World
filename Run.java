import modules.player;
import modules.util;
import modules.optionHandler;

import modules.check;

import modules.story;

class Run {
    public static void main(String[] args){       

        // Clear the screem
        util.clearScreen();
        // Give the enter prompt
        util.enterPrompt();

        
        util.print("Hello, welcome to new world.");
        // Wait until user presses enter
        util.nextLine();

        util.print("To play this game you must verify your age.");
        // Clear screen when user presses enter and then give enter prompt
        util.nextClearEnter();

        // Prompt user to enter age
        util. print("Please enter your age");
        // Get user input
        String stringAge = util.nextLine();

        // Check user input
        int age = check.checkIfNumber(stringAge);

        // If age is bigger than 12
        if ( age > 12){
            util.print("Your age is: " + age);
        // If age is not bigger than 12
        } else {
            util.print("You cannot play this game");
            // close the program
            System.exit(0);
        }
        
        // Clear screen when user presses enter and then give enter prompt
        util.nextClearEnter();

        // get name of user (This is done using util class)
        String name = util.getName();
        // Make a new player with parameters (name)
        player plr = new player(name);

        // Make a new story with the player
        story mainStory = new story(plr);

        // Optionhandler is private because it stores private variables such as time and other
        optionHandler oHandler = new optionHandler(plr, mainStory);

        // Set optionHandler inside mainstory since both classes are private
        mainStory.setOptionHandler(oHandler);
        
        // Tell part 0 of the story
        oHandler.tellPart(0);
        // Ask option 0 of the story
        oHandler.askOption(0);

        // The rest is handled inside the story class

    }
    
}

