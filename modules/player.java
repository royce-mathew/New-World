// Package : Tells the program that this class is stored inside a folder
package modules;

// Player class
public class player {
    // Initialize Variables
    private String name;

    // Initialize private vars
    private int hp;
    private int sanity;
    private int healthPotions;

    /**
     * Constructor that sets every player value to default values and sets the player name to the passed parameter
     * @param _name The name of the player that will be used throughout the story
     */
    public player(String _name){
        // Set the name as the passed param
        name = _name;
        // Set default values
        hp = 100;
        sanity = 0;
        healthPotions = 0;
    }

    /* Getter Methods */ 
    public int getHp(){ return hp; }
    public int getSanity(){ return sanity; }
    public int getPotions(){ return healthPotions; }
    public String getName() { return name; }

    /* Setter Methodss */ 
    // Add 1 potion to the potions variable
    public void addPotions(){
        healthPotions++;
    }
    // Subtract 1 potion from the potions variable
    public void subtractPotions(){
        healthPotions--;
    }

    // Set the plr hp to the passed param
    public void setHp(int _num){
        hp = _num;
    }

    // Add 1 sanity to the sanity variable
    public void addSanity(){
        sanity++;
    }
    // Subtract 1 sanity from the sanity variable
    public void subtractSanity(){
        sanity--;
    }

    
}
