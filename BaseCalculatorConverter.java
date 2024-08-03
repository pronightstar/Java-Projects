import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputBase, outputBase, convertedInt1, convertedInt2, spaceCount = 0;
        String menuInput, input, int1, int2, outputBaseString, inputBaseString;
        char operator = ' ';
        do {
            System.out.println("Welcome to the different base calculator \n Enter (1) to use the calculator \n Enter (stop) to exit the program");
            menuInput = sc.nextLine();
            if (menuInput.equals("1")) {
                    System.out.println("Enter the base for both integers, integer, operand, and integer");
                    input = sc.nextLine().trim();
                    for (int i = 0; i < input.length(); i++) {
                        if (input.charAt(i) == ' ') {
                            spaceCount++;
                        }
                    }
                 if (spaceCount != 3) {
                     while (spaceCount != 3) {
                         spaceCount = 0;
                         System.out.println("Invalid input, please re-enter the base for both integers, integer, operand, and integer");
                         input = sc.nextLine().trim();
                         for (int i = 0; i < input.length(); i++) {
                             if (input.charAt(i) == ' ') {
                                 spaceCount++;
                             }
                         }
                     }
                 }
                spaceCount = 0;
                    inputBaseString = input.substring(0, input.indexOf(' '));
                    if (inputBaseString.length() == 1 && input.charAt(0) >= '2' && input.charAt(0) <= '9') {
                        inputBase = Integer.parseInt(input.substring(0,1));
                        input = input.substring(2);
                    } else if (inputBaseString.length() == 2 && inputBaseString.equals("10")) {
                        inputBase = 10;
                        input = input.substring(3);
                    } else {
                        while (!intChecker(inputBaseString) || Integer.parseInt(inputBaseString) > 10 || Integer.parseInt(inputBaseString) < 2) {
                            System.out.println("Input base must be between 2 and 10 / Valid integer");
                            inputBaseString = sc.nextLine();
                        }
                        inputBase = Integer.parseInt(inputBaseString);
                        input = input.substring(input.indexOf(' ') +1);
                    }
                    int1 = input.substring(0, input.indexOf(' '));
                    if (!intChecker(int1) || !baseChecker(int1, inputBase)) {
                        while (!intChecker(int1) || !baseChecker(int1, inputBase)) {
                            System.out.println("First integer input invalid, re-enter");
                            int1 = sc.nextLine();
                        }
                    }
                    input = input.substring(input.indexOf(' ')+1);
                    operator = input.charAt(0);
                if (operator != '+' && operator != '-' && operator != '*' && operator != '/' && operator != '%') {
                    while (operator != '+' && operator != '-' && operator != '*' && operator != '/' && operator != '%') {
                        System.out.println("Invalid operand input, re-enter");
                        operator = sc.nextLine().charAt(0);
                    }
                }
                    input = input.substring(input.indexOf(' ')+1);
                    int2 = input;
                    if (!intChecker(int2) || !baseChecker(int2, inputBase)) {
                        while (!intChecker(int2) || !baseChecker(int2, inputBase)) {
                            System.out.println("Second integer input invalid, re-enter");
                            int2 = sc.nextLine();
                        }
                    }
                    System.out.println("Enter the output base between two and ten");
                    outputBaseString = sc.nextLine();
                    if (!intChecker(outputBaseString) || Integer.parseInt(outputBaseString) > 10 || Integer.parseInt(outputBaseString) < 2) {
                        while (!intChecker(outputBaseString) || Integer.parseInt(outputBaseString) > 10 || Integer.parseInt(outputBaseString) < 2) {
                            System.out.println("Invalid input, output base must be between 2-10 / valid integer");
                            outputBaseString = sc.nextLine();
                        }
                    }
                    outputBase = Integer.parseInt(outputBaseString);
                int[] int1Array = new int[int1.length()], int2Array = new int[int2.length()];
                    arrayConverter(int1, int1Array);
                    arrayConverter(int2, int2Array);
                    convertedInt1 = baseConverter(int1Array, inputBase);
                    convertedInt2 = baseConverter(int2Array, inputBase);
                if (operator != '%') {
                    System.out.println(outputBaseConverter(calculation(convertedInt1, convertedInt2, operator), outputBase));
                } else {
                    System.out.println(outputBaseConverter(convertedInt1 / convertedInt2, outputBase) + "R" + outputBaseConverter(convertedInt1 % convertedInt2, outputBase));
                }
            } else if (!menuInput.equals("stop")) {
                System.out.println("Invalid input, enter 1 or stop");
            }
        } while (!menuInput.equals("stop"));
    }
    public static void arrayConverter(String integer, int[] array){
        for (int i = 0; i < integer.length(); i++) {
            array[i] = Integer.parseInt(integer.substring(i, i+1));
        }
    }
    public static int baseConverter(int[] intArray, int base) {
        int result = 0;
        for (int i = 0; i < intArray.length; i++) {
            result += (int)(intArray[i] * Math.pow(base, intArray.length - i - 1));
        }
        return result;
    }
    public static int calculation(int int1, int int2, char operator) {
        int result = 0;
        switch (operator) {
            case '+' :
                result = int1 + int2;
                break;
            case '-' :
                result = int1 - int2;
                break;
            case '*' :
                result = int1 * int2;
                break;
            case '/' :
                 if (int1 % int2 == 0) {
                     result = int1 / int2;
                 } else {
                     System.out.println("Second integer does not go into first integer evenly");
                 }
                break;
        }
        return result;
    }
    public static String outputBaseConverter(int answer, int base) {
        int highestPower = 0;
        String convertedAnswer = "";
        while (answer >= Math.pow(base, highestPower+1)) {
            highestPower++;
        }
        for (int i = highestPower; i >= 0; i--) {
            convertedAnswer += (int)(answer / Math.pow(base, i));
            answer = (int)(answer % Math.pow(base, i));
        }
        return convertedAnswer + " (base " + base + ")";
    }
    public static boolean intChecker(String integer) {
        for (int i = 0; i < integer.length(); i++) {
            if (integer.charAt(i) < '0' || integer.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
    public static boolean baseChecker(String integer, int inputBase) {
          for (int i = 0; i < integer.length(); i++) {
              if (integer.charAt(i) - '0' >= inputBase) {
                  return false;
              }
          }
                  return true;
}
}
