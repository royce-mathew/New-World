// Import Scanner for input
import java.util.Scanner;

import modules.check;
import modules.player;
import story.page1;

class Run {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        clearScreen();
        enterPrompt();

        
        print("Hello, welcome to new world.");
        sc.nextLine();


        print("To play this game you must verify your age.");
        
        nextClearEnter(sc);

        // Check Age
        print("Please enter your age");
        int age = sc.nextInt();
        // If age is bigger than 12
        if ( age > 12){
            print("Your age is: " + age);
        // If age is not bigger than 12
        } else {
            print("You cannot play this game");
            // close the program
            System.exit(0);
        }

        nextClearEnter(sc);

        // Run the getName function 
        String name = getName(sc);
        player plr = new player(name);

        page1 p1 = new page1(plr);

        askOption(sc, p1, 1);

    }

    public static String getName(Scanner sc){
        // Check Name
        print("Please enter your name:");
        String name = sc.nextLine();
        name = check.checkString(name, 2);

        if (name.length() == 0){
            print("You must choose a name longer than 2 words");
            clearScreen();
            getName(sc);
        }

        return name;
    }

    public static void askOption(Scanner sc, page1 page, int question){
        // Decrease by 1 becauase indexes start at 0
        question--;

        String[] storyLine = page.getStory();
        String story = storyLine[question];
        
        String[][] optionData = page.getOptionData();
        String[] mainData = optionData[question];

        print(story);
        print("Options:");

        for (int i = 0; i < mainData.length; i++){
            print("["+i+"]: " + mainData[i]);
        }
        
        print("\n");
        print("Choose Option: ");
        int option = sc.nextInt();
        page.chooseOption(option);
    }

    public static void nextClearEnter(Scanner sc){
        sc.nextLine();
        try {
            wait(1);
        } catch (Exception InterruptedException){
            print("Error occured while waiting.");
        };

        clearScreen();
        enterPrompt();
       
    }

    public static void enterPrompt(){
        print("===========================");
        print("= Press ENTER to continue =");
        print("===========================\n");
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    public static void wait(int sec) throws InterruptedException {
        Thread.sleep(sec*1000);
    }

    public static void print(String toPrint){
        System.out.println(toPrint);
    }
}

