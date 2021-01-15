package story;

import modules.*;

public class page1 {

    private String[] storyLine = {
        "You wake up. You look around you.\n This is a jungle.\n\n There are two routes here, which one do I take?",
        
    };

    private String[][] optionData = {
        // Data for option 1
        {
            "The left route",
            "The right route"
        },

        
    };
    
    player plr;

    public page1(player _plr){
        plr = _plr;
    }

    

    public void part1(int optionChose){
        if (optionChose == 1){
            System.out.println("One");

        } else if (optionChose == 2){

            System.out.println("Two");
        };
        // You can also run chooseOption function from here

        return;
    }

    public String[] getStory(){
        return storyLine;
    }

    public String[][] getOptionData(){
        return optionData;
    }
}