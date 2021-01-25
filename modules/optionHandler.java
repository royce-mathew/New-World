package modules;

import java.util.Scanner;

import java.text.SimpleDateFormat;
import java.util.Date;

public class optionHandler {
    // These variables are not static because using DateFormats as static variables can cause Runtime Exceptions
    private SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
    private String formattedDate = dateFormat.format(new Date());

    // Variables that we can use later
    Scanner sc;
    player plr;
    story mainStory;

    /* Constructor */
    public optionHandler(Scanner _sc, player _plr, story _story){
        sc = _sc;
        plr = _plr;
        mainStory = _story;
    }

    // Private functions
    private void readStory(String[] story){
        // Loop through each string inside the string array
        for (String detailedStrings : story){
            // Check if the string includes plrName
            if (detailedStrings.contains("{plrName}")) {
                // Replace that with the player's name
                detailedStrings = detailedStrings.replace("{plrName}", plr.getName());
            }
            // Check if the string includes systemTime 
            if (detailedStrings.contains("{systemTime}")){
                // Replace that with the system time
                // The "" concatenation is for changing the currentTimeMillis to a string since String.replace only takes Strings as params
                detailedStrings = detailedStrings.replace("{systemTime}", formattedDate);
            }

            // Print those strings
            util.printStory(detailedStrings);

            // Wait one second
            util.wait(0.5);
            
        }
    }


    // TellPart Public function : Only tells the story, without options
    public void tellPart(int part){
        // Get the mainstory
        String[][] storyLine = mainStory.getStory();
        // Get the part of the story we want
        String [] story = storyLine[part];

        // Clear the console
        util.clearScreen();

        // Read the story
       readStory(story);

    }

    // This function is not static because askOption requires the formattedDate, also because this is specific to each player.
    public void askOption(int question){
      
        // get the option data list
        String[][] optionData = mainStory.getOptionData();
        // Access the specific question list
        String[] mainData = optionData[question];


        // Tell the user what the strings in console about to be printed are
        util.print("");
        util.print("Options:");

        // Loop through the question list
        for (int i = 0; i < mainData.length; i++){
            util.print("["+i+"]: " + mainData[i]);
        }
        
        // Prompt user to enter an option
        util.print("\n");
        util.print("Choose Option: ");

        // Get the user input
        String option = sc.nextLine();

        // Check if the user input can be parsed onto a string
            // Pass the range as the third argument (Range: 0-1)
        int newOp = check.checkIfNumber(sc, option, 1);

        // Run the chooseOption method from mainStory class
        mainStory.chooseOption(question, newOp);
    }
}
