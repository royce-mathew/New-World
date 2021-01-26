package modules;

import java.util.Scanner;

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

    public static boolean generateQuestion(Scanner sc){
        util.print("Answer this question: ");
        // Math.random generates a number between 0-1, Math.round rounds up the random number and returns a double.

        // This will give us a number between 1-3
        double randomOperator = Math.floor( Math.random() * 3);

        // Pick a random number between 1 to 100
        double firstNum = Math.ceil ( Math.random() * 100);

        // Add 1 just so we don't get divide by 0 error
        double secondNum = Math.round ( Math.random() * 5) + 1;

        // Division
        if (randomOperator == 0.0){
            // Prompt
            util.print("== Operation : Division ==");
            util.print("What is " + firstNum + " / " + secondNum + "? (Round to an integer)");

            // Get Input
            String givenAns = sc.nextLine();

            // Convert input
            int inputAns = check.checkIfNumber(sc, givenAns);

            // Check input (int) casts long to int and converts the long to int
            return (inputAns == (int) (firstNum / secondNum));


        // Multiplication
        } else if (randomOperator == 1.0) {
            util.print("== Operation : Multiplication ==");
            util.print("What is " + firstNum + " * " + secondNum + "?");

            // Get Input
            String givenAns = sc.nextLine();

            // Convert input
            int inputAns = check.checkIfNumber(sc, givenAns);

            return (inputAns ==  (int)(firstNum * secondNum));
        
        // Addition
        } else if (randomOperator == 2.0){
            util.print("== Operation : Addition ==");
            util.print("What is " + firstNum + " + " + secondNum + "?");

            // Get Input
            String givenAns = sc.nextLine();

            // Convert input
            int inputAns = check.checkIfNumber(sc, givenAns);

            return (inputAns ==  (int)(firstNum + secondNum));

        // Subtraction
        } else if (randomOperator == 3.0){
            util.print("== Operation : Subtraction ==");
            util.print("What is " + firstNum + " - " + secondNum + "?");

            // Get Input
            String givenAns = sc.nextLine();

            // Convert input
            int inputAns = check.checkIfNumber(sc, givenAns);
            return (inputAns ==  (int)(firstNum - secondNum));
        }

        // Return false (This line of code should never execute if everything goes right), we still need it here just in case
        return false;
    }
}
