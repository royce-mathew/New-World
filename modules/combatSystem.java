// Package : Tells the program that this class is stored inside a folder
package modules;

// Combat System class
public class combatSystem {
    // Stores the plr variable inside this class
    private player plr;

    /* Constructor */
    public combatSystem(player _plr){
        // Set the passed value as the private plr variable
        plr = _plr;
    }

    // Private Methods
    /**
     * This method starts a fight with the enemy. Using the questionHandler class, it asks the player questions and if the player
     * answers the question right, the player does damage to the enemy.
     * 
     * @param person The name of the enemy
     * @param enemyHp The hp of the enemy
     */
    private void startFight(String person, int enemyHp){
        // This line is used since there are only two enemies currently in game
        // Check if the enemy is the boss or the thug, we will use this string for determining the static hp, which tells the player how much damage the player has done
        String staticHp = (person.compareTo("thugs") == 0) ? "/100" : "/300";

        // Check if the player is dead
        if (plr.getHp() <= 0) {
            // Clear Screen
            util.clearScreen();
            // Tell user what happened
            util.print("You got defeated by " + person);
            util.print("Game Over.");
            util.rollCredits();
            
            // Exit out of the program
            System.exit(0);
        }

        // Clear the screen
        util.clearScreen();
        // Tell player the player hp and enemy hp
        util.print(person + " HP: " + enemyHp + staticHp);
        util.print("Your HP: " + plr.getHp() + "/100");

        // Generate a question using the questionHandler, the generate question method returns a boolean value (true or false) and handles everything related to answering questions
        boolean didAnswer = questionHandler.generateQuestion();

        // If the player anwered the question right
        if (didAnswer){
            // Do base 20 damage if sanity is lesser than 0, do damage multiplier if sanity is bigger than 0
            enemyHp -= (plr.getSanity() > 0) ? (plr.getSanity() * 10) : 20;

            // If the enemy hp is bigger than 0
            if (enemyHp > 0){
                // Subtract 10 hp from player
                plr.setHp(plr.getHp() - 10);

                // Run setup encounter becuase it acts as a option selection menu
                encounter(person, enemyHp);
            
            // If the enemyHp is lesser than or equal to 0 (enemy is dead)
            } else {
                // Clear Screen
                util.clearScreen();
                // Give player info
                util.print("You defeated " + person + "!");
                // Wait 0.5 seconds
                util.wait(0.5);

                // Add two potions to the player
                util.print("You got 2 health potions!");
                // Add two potions to the player
                plr.addPotions();
                plr.addPotions();

                // Wait 2 seconds and then go to back to story
                util.wait(2.0);
            }


        // If the player answered the question wrong
        } else {
             // Subtract 10 hp from player
             plr.setHp(plr.getHp() - 10);

             // Run this method again (recursive methods)
             encounter(person, enemyHp);
        }


    }

    /**
     * This method checks if the player has any potions, if the player does then it heals the player or goes back to the combat menu
     * 
     * @param person The name of the enemy (used for calling the combat menu back)
     * @param enemyHp The hp of the enemy (Also used for calling the combat menu back)
     */
    private void healUp(String person, int enemyHp){
        // if the player has on potions
        if (plr.getPotions() == 0) {
            // Tell player that they have no potions left, start the fight again
            util.print("You have no potions!");
            // Wait 1 second
            util.wait(1.0);
            // Go back to options
            encounter(person, enemyHp);

        // If the player does have potions
        } else {
            // Subtract one potion from the player
            plr.subtractPotions();
            // Set playerHp to 100
            plr.setHp(100);

            // Run the encounter method again and go back to main options
            encounter(person, enemyHp);
        }
       
    }


    // Public Methods
    /**
     * Encounter method, this gives the player a options to choose from. Currently includes fight and heal.
     * 
     * @param person The name of the enemy
     * @param enemyHp The health of the enemy
     */
    public void encounter(String person, int enemyHp){
        // Check if the enemy is the boss or the thug, we will use this string for determining the static hp, which tells the player how much damage the player has done
        String staticHp = (person.compareTo("thugs") == 0) ? "/100" : "/300";

        // Clear the screen
        util.clearScreen();
        // Give NPC hp
        util.print(person + " HP: " + enemyHp + staticHp);
        // Give player hp
        util.print("Your HP: " + plr.getHp() + "/100");

        // Tell player options
        util.print("");
        util.print("Options:");
        util.print("[1]: Fight");
        util.print("[2]: Use Health Potion");
        util.print("");
        util.print("Enter Option: ");
        // Get user input
        String option = util.nextLine();
        // Check if the input is a number
        int checkedOption = check.checkIfNumber(option);

        // If the input is 1
        if (checkedOption == 1){
            // Start fight
            startFight(person, enemyHp);

        // If the input is 2
        } else if (checkedOption == 2) {
            // Run the healUp method 
            healUp(person, enemyHp);

        // If the player selected anything other than option 1 or 2
        } else {
            // Tell player what happened
            util.print("Wrong option. Please choose option 1 or 2");
            // Wait 1 second
            util.wait(1.0);
            // Run the method again
            encounter(person, enemyHp);
        }
    }
}
