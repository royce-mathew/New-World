// Package : Tells the program that this class is stored inside a folder
package modules;

public class questionHandler {

    /* This constructor is here because according to SonarLint Rules,
        Utility classes, which are collections of static members, are not meant to be instantiated. 
        Even abstract utility classes, which can be extended, should not have public constructors.
        Java adds an implicit public constructor to every class which does not define at least one explicitly. 
        Hence, at least one non-public constructor should be defined.
    */
    private questionHandler() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Generate question method, generates a random question and a random operator using Math.random
     * 
     * @return A boolean which tells the program whether the player got the answer right or wrong.
     */
    public static boolean generateQuestion(){
        // Give user info on what's being printed
        util.print("Answer this question: ");
        // Math.random generates a number between 0-1, Math.round rounds up the random number and returns a double.
        // This will give us a number between 1-3
        double randomOperator = Math.round( Math.random() * 3);

        // Pick a random number between 1 to 100
        // Math.ceil rounds the integer up
        double firstNum = Math.ceil ( Math.random() * 100);

        // Add 1 just so we don't get divide by 0 error
        double secondNum = Math.round ( Math.random() * 5) + 1.0;

        // Division
        // if the randomOperator chosen by Math.random is equal to 0
        if (randomOperator == 0.0){
            // Give user info on what's about to be printed
            util.print("== Operation : Division ==");
            // Ask user prompt
            util.print("What is " + firstNum + " / " + secondNum + "? (Round to an integer)::");

            // Get Input from user
            String givenAns = util.nextLine();

            // Convert input to an integer using check class and checkIfNumber method
            int inputAns = check.checkIfNumber(givenAns);

            // Return a boolean based on if the answer is right or not
            // This is done with Math.round instead of casting int because it would basically truncate the number
            return (inputAns == Math.round((firstNum / secondNum)));


        // Multiplication
        } else if (randomOperator == 1.0) {
            util.print("== Operation : Multiplication ==");
            util.print("What is " + firstNum + " * " + secondNum + "?");

            String givenAns = util.nextLine();

            int inputAns = check.checkIfNumber(givenAns);

            // Check if the userinput equals to the firstNumber multiplied by the secondNum
            //  (int) casts long to int and converts the long to int
            return (inputAns ==  (int)(firstNum * secondNum));
        
        // Addition
        } else if (randomOperator == 2.0){
            util.print("== Operation : Addition ==");
            util.print("What is " + firstNum + " + " + secondNum + "?");

            String givenAns = util.nextLine();

            int inputAns = check.checkIfNumber(givenAns);

            // Check if the userinput equals to the firstNumber added by the secondNum
            return (inputAns ==  (int)(firstNum + secondNum));

        // Subtraction
        } else if (randomOperator == 3.0){
            util.print("== Operation : Subtraction ==");
            util.print("What is " + firstNum + " - " + secondNum + "?");

            String givenAns = util.nextLine();

            int inputAns = check.checkIfNumber(givenAns);
            
            // Check if the userinput equals to the firstNumber subtracted by the secondNum
            return (inputAns ==  (int)(firstNum - secondNum));
        }

        // Return false (This line of code should never execute if everything goes right), we still need it here just in case
        return false;
    }
}
