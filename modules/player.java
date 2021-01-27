// Package : Tells the program that this class is stored inside a folder
package modules;

public class player {
    // Initialize Variables
    private String name;

    // Initialize private vars
    private int coins;
    private int hp;
    private int sanity;
    private int healthPotions;

    /* Constructor with args passed (Used for loading a save) */ 
    public player(String _name, int _hp, int _sanity, int _healthPotions){
        // Set private variables as the params passed
        name = _name;
        hp = _hp;
        sanity = _sanity;
        healthPotions = _healthPotions;
    }
    /* Constructor with no args */
    public player(String _name){
        // Set the name as the passed param
        name = _name;
        // Set default values
        hp = 100;
        sanity = 0;
        healthPotions = 0;
    }

    /* Getter Methods */ 
    public int getCoins(){ return coins; }
    public int getHp(){ return hp; }
    public int getSanity(){ return sanity; }
    public int getPotions(){ return healthPotions; }
    public String getName() { return name; }

    /* Setter Methodss */ 
    // Set coins as passed param
    public void setCoins(int _coins){
        // Set coins if the value is acceptable
        coins = check.checkNegative(_coins);
    }

    // Add 1 potion to the potions variable
    public void addPotions(){
        healthPotions++;
    }
    // Subtract 1 potion from the potions variable
    public void subtractPotions(){
        healthPotions--;
    }

    // Update the coins to the coins passed
    public void updateCoins(int _coins){
        // Update coins if the value is acceptable
        coins += check.checkNegative(_coins);
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
