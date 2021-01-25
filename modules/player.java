package modules;

public class player {
    // Initialize Variables
    private String name;

    private int coins;
    private int hp;
    private int sanity;
    private int healthPotions;

    /* Constructor with args passed (Used for loading a save) */ 
    public player(String _name, int _hp, int _sanity, int _healthPotions){
        name = _name;
        hp = _hp;
        sanity = _sanity;
        healthPotions = _healthPotions;
    }
    /* Constructor with no args */
    public player(String _name){
        name = _name;
        hp = 100;
        sanity = 0;
        healthPotions = 0;
    }

    /* Getter Functions */ 
    public int getCoins(){ return coins; }
    public int getHp(){ return hp; }
    public int getSanity(){ return sanity; }
    public int getPotions(){ return healthPotions; }
    public String getName() { return name; }

    /* Setter Functions */ 
    public void setCoins(int _coins){
        // Set coins if the value is acceptable
        coins = check.checkNegative(_coins);
    }

    public void addPotions(){
        healthPotions++;
    }
    public void subtractPotions(){
        healthPotions--;
    }

    public void updateCoins(int _coins){
        // Update coins if the value is acceptable
        coins += check.checkNegative(_coins);
    }

    public void setHp(int _num){
        hp = _num;
    }

    public void addSanity(){
        sanity++;
    }

    public void subtractSanity(){
        sanity--;
    }

    
}
