package modules;

public class story {
    player plr;

    private String[][] storyLine = {
        {
            "Name ..",
            "Name !",
            "Wake up!",
            "Its {System time}!!",
            "Wake up?"
        },
        {}


        
    };

    private String[][] optionData = {
        // Data for option 1
        {
            "Yes",
            "No, I think I'll sleep a bit more"
        },

        
    };
    
    

    public story(player _plr){
        plr = _plr;
    }

    

    public void chooseOption(int part, int optionChose){
        if (part == 1){
            if (optionChose == 0){
                util.print("One");
    
            } else if (optionChose == 1){
    
                util.print("Two");
            }
        }
        
        // You can also run chooseOption function from here

    }

    public String[][] getStory(){
        return storyLine;
    }

    public String[][] getOptionData(){
        return optionData;
    }
}
