// Package : Tells the program that this class is stored inside a folder
package modules;

// Import the SimpleDateFormat and Date (Used for getting time)
import java.text.SimpleDateFormat;
import java.util.Date;

// Used for getting a file (Specifically used in this class for audio files)
import java.io.File;

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
    /**
     * This method runs trigger checks to see if the story includes any Strings that can be replaced with player data.
     * It also allows us to make the player feel atleast a bit more immersed by using the information from the local player
     * 
     * @param story The string array that will be read. This array should be a subArray from the mainStory 2d array
     */
    private void readStory(String[] story){
        // Loop through each string inside the string array
        for (String detailedStrings : story){

            /* These if statements check for triggers inside the story */
            // Check if the string includes plrName : Tells the program to replace plrName with the player's name
            if (detailedStrings.contains("{plrName}")) {
                // Replace that with the player's name
                detailedStrings = detailedStrings.replace("{plrName}", plr.getName());

            // Check if the string includes systemTime : Tells the program to replace systemTime with the local time on the computer
            } else if (detailedStrings.contains("{systemTime}")){
                // Replace that with the system time
                // The "" concatenation is for changing the currentTimeMillis to a string since String.replace only takes Strings as params
                detailedStrings = detailedStrings.replace("{systemTime}", formattedDate);
            }

            // These are in seperate if statements because these types of methods should not print onto the screen and do not replace strings at all            
            // Check if the string includes clearScreen : Tells the program to clear the screen
            if (detailedStrings.contains("{clearScreen}")){
                // Clear the screen
                util.clearScreen();

            // Check if the string contains a trigger to play a  audioFile
            } else if (detailedStrings.contains("{play: ")){
                // Get the audio name : play audio string is normally formatted in {play : aidoFileName} so substring does the job in getting the audio name
                detailedStrings = detailedStrings.substring(7, detailedStrings.length()-1);

                // Get the audio file from resources
                File audioFile = new File("./resources/" + detailedStrings + ".wav");

                // Run the play sound method with parameter (file : The audio file to play), (toYield : Boolean parameter, tells the program whether to yield or not)
                soundHandler.playSound(audioFile, false);


            // If the string does not contain any method triggers
            } else {
                // Print the strings
                util.printStory(detailedStrings);

                // Wait one second
                util.wait(1.0);
            }
        }
    }


    /**
     * This method slowly reads the story using the readStory method.
     * 
     * @param part The subArray that will be read of the mainStory 2d array
     */
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


    /**
     * This method asks the player a question which is grabbed by indexing the optionData array
     * 
     * @param question The index that will be used to find the array of options inside the optionData array
     */
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
