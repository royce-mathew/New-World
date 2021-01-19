package modules;

import java.util.Scanner;

public class questionHandler {
    public static boolean generateQuestion(Scanner sc, int difficultyLevel){
        if (difficultyLevel == 1){
            util.print("Answer this question: ");
            // Math.random generates a number between 0-1, Math.round rounds up the random number and returns a double.

            // This will give us a number between 1-4
            long randomOperator = Math.round( Math.random() * 4);

            long firstNum = Math.round ( Math.random() * 100);
            long secondNum = Math.round ( Math.random() * 5);

            // Division
            if (randomOperator == 1){
                // Prompt
                util.print("== Operation : Division ==");
                util.print("What is " + firstNum + " / " + secondNum + "? (Round to an integer)");

                // Get Input
                String givenAns = sc.nextLine();

                // Convert input
                int inputAns = check.checkIfNumber(sc, givenAns);

                // Check input
                return (inputAns == (firstNum / secondNum));


            // Multiplication
            } else if (randomOperator == 2) {
                util.print("== Operation : Multiplication ==");
                util.print("What is " + firstNum + " * " + secondNum + "?");

                // Get Input
                String givenAns = sc.nextLine();

                // Convert input
                int inputAns = check.checkIfNumber(sc, givenAns);

                return (inputAns == (firstNum * secondNum));
            
            // Addition
            } else if (randomOperator == 3){
                util.print("== Operation : Addition ==");
                util.print("What is " + firstNum + " + " + secondNum + "?");

                // Get Input
                String givenAns = sc.nextLine();

                // Convert input
                int inputAns = check.checkIfNumber(sc, givenAns);

                return (inputAns == (firstNum + secondNum));

            // Subtraction
            } else if (randomOperator == 4){
                util.print("== Operation : Subtraction ==");
                util.print("What is " + firstNum + " - " + secondNum + "?");

                // Get Input
                String givenAns = sc.nextLine();

                // Convert input
                int inputAns = check.checkIfNumber(sc, givenAns);
                return (inputAns == (firstNum - secondNum));
            }

            // Return false (This line of code should never execute if everything goes right), we still need it here just in case
            return false;
        }

        // Return false (This line of code should never execute if everything goes right), we still need it here just in case
        return false;
    }
}
