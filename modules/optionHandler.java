// Package : Tells the program that this class is stored inside a folder
package modules;

// Import the SimpleDateFormat and Date (Used for getting time)
import java.text.SimpleDateFormat;
import java.util.Date;

// Option handler class
public class optionHandler {
    // These variables are not static because using DateFormats as static variables can cause Runtime Exceptions
    // DateFormat: Create a new dateFormat in the format (hour : minutes)
    private SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
    // create a new date using the dateFormat in the last line
    private String formattedDate = dateFormat.format(new Date());

    // Initialize a plr variable (Used for getting info from the player)
    private player plr;
    // Initialize a mainstory variable (Used for getting the story)
    private story mainStory;

    /* Constructor */
    public optionHandler(player _plr, story _story){
        // Set the player and story as the passed args
        plr = _plr;
        mainStory = _story;
    }

    // Private methods
    private void readStory(String[] story){
        // Loop through each string inside the string array
        for (String detailedStrings : story){

            /* These if statements check for triggers */
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
            if (detailedStrings.contains("{clearScreen}")){
                // Replace the text with nothing because it will still print in next line 
                detailedStrings = detailedStrings.replace("{clearScreen}", "");
                // Clear the screen
                util.clearScreen();
            }

            // Print the strings
            util.printStory(detailedStrings);

            // Wait one second
            util.wait(1.0);
            
        }
    }


    // TellPart Public function : Tells the story of the part passed
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
            // Print the index and the option
            util.print("["+i+"]: " + mainData[i]);
        }
        
        // Prompt user to enter an option
        util.print("");
        util.print("Choose Option:");

        // Get the user input
        String option = util.nextLine();

        // Check if the user input can be parsed onto a string
            // Pass the range as the third argument (Range: 0-1)
        int newOp = check.checkIfNumber(option, 1);

        // Run the chooseOption method from mainStory class
        mainStory.chooseOption(question, newOp);
    }
}
