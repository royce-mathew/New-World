package modules;

public class check {
    // Check Function
    public static int checkNegative(int value){
        if (value > 0) {
            return value;
        } else {
            System.out.println("Error: " + value + " cannot be negative");
            return 0;
        }
    }

    public static String checkString(String value, int length){
        if (value.length() > 0) {
            return value;
        } else {
            System.out.println("Error " + value + " must be longer than length(" + length + ")");
            return "";
        }
    }

    
}
