package modules;

import java.util.Scanner;

public class optionHandler {

    private optionHandler() {
        throw new IllegalStateException("Utility Class");
    }

    public static void askOption(Scanner sc, story mainStory, int question){
        // Decrease by 1 becauase indexes start at 0
        question--;

        String[][] storyLine = mainStory.getStory();
        String [] story = storyLine[question];
        
        String[][] optionData = mainStory.getOptionData();
        String[] mainData = optionData[question];

        util.clearEnter();

        for (String detailedStrings : story){
            util.print(detailedStrings);
            util.wait(0.5);
            
        }

        util.print("Options:");

        for (int i = 0; i < mainData.length; i++){
            util.print("["+i+"]: " + mainData[i]);
        }
        
        util.print("\n");
        util.print("Choose Option: ");

        int option = sc.nextInt();
        mainStory.chooseOption(question, option);
    }
}
