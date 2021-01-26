package modules;

import java.util.Scanner;

public class combatSystem {
    private player plr;
    private Scanner sc;


    /* Constructor */
    public combatSystem(player _plr, Scanner _sc){
        plr = _plr;
        sc = _sc;
    }

    // Private method start fight:
        // 
    private void startFight(String person, int enemyHp){
        // Check if the enemy is the boss or the thug, we will use this string for determining the static hp, which tells the player how much damage the player has done
        String staticHp = (person.compareTo("thugs") == 0) ? "/100" : "/300";

        // Check if the player is dead
        if (plr.getHp() < 0) {
            util.clearScreen();
            util.print("You got defeated by " + person);
            util.print("GAME OVER");
            
            // Clear the save here
            System.exit(0);
        }

        // Clear the screen
        util.clearScreen();
        util.print(person + " HP: " + enemyHp + staticHp);
        util.print("Your HP: " + plr.getHp() + "/100");

        boolean didAnswer = questionHandler.generateQuestion(sc);
        if (didAnswer == true){
            // Do base 20 damage if sanity is lesser than 0, do damage multiplier if sanity is bigger than 0
            enemyHp -= (plr.getSanity() > 0) ? (plr.getSanity() * 20) : 20;

            // If the enemy hp is bigger than 0
            if (enemyHp > 0){
                // Subtract 10 hp from player
                plr.setHp(plr.getHp() - 10);

                // Run this method again (recursive methods)
                startFight(person, enemyHp);

            } else {

                // If the enemyHp is lesser than 10
                util.clearScreen();
                util.print("You defeated " + person + "!");
                util.wait(0.5);
                util.print("You got 2 health potions!");
                plr.addPotions();
                plr.addPotions();
                util.wait(2.0);
            }

        } else {
             // Subtract 10 hp from player
             plr.setHp(plr.getHp() - 10);

             // Run this method again (recursive methods)
             startFight(person, enemyHp);
        }


    }

    private void healUp(){
        plr.subtractPotions();
        plr.setHp(100);
    }

    public void setupFight(String person, int hp){
        util.clearScreen();
        util.print(person + " HP: " + hp + "/100");
        util.print("Your HP: " + plr.getHp() + "/100");

        util.print("");
        util.print("Options:");
        util.print("[1]: Fight");
        util.print("[2]: Use Health Potion");
        util.print("");
        util.print("Enter Option: ");
        String option = sc.nextLine();
        int checkedOption = check.checkIfNumber(sc, option);

        if (checkedOption == 1){
            startFight(person, hp);

        } else if (checkedOption == 2) {
            healUp();

        } else {
            util.print("Wrong option. Please choose option 1 or 2");
            setupFight(person, hp);
        }
    }
}
