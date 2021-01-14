package modules;

public class player {
    // Initialize Variables
    private String name;

    private int coins;
    private int level;
    private int exp;

    check checker;

    /* Constructor */ 
    public player(String _name){
        name = _name;
    }

    /* Getter Functions */ 
    public int getCoins(){ return coins; }
    public int getLevel(){ return level; }
    public int getExp() { return exp; }
    public String getName() { return name; }

    /* Setter Functions */ 
    public void setCoins(int _coins){
        // Set coins if the value is acceptable
        coins = checker.checkNegative(_coins);
    }

    public void updateCoins(int _coins){
        // Update coins if the value is acceptable
        coins += checker.checkNegative(_coins);
    }

    public void updateExp(int _exp){
        // Update exp if the value is acceptable
        exp += checker.checkNegative(_exp);
    }


    
}
