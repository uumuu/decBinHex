import ex26.BinaryStack;

import java.util.Scanner;

public class Ex2_7 {
    public final int MAX_INPUT_INT = 2147483647;
    public final int MAX_BINARY_DIGITS = 33;
    public final int MAX_HEX_DIGITS = 10;

    public static boolean isValidConversionType (String str) {
        return (str != null) && (str.equals("b") || str.equals("h"));
    }
    public static boolean isNumeric(String str) {
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }

    public String getHexValue(int remainder) {
        // takes in the remainder and returns its hex value

        String HEX_VALUE_10 = "A";
        String HEX_VALUE_11 = "B";
        String HEX_VALUE_12 = "C";
        String HEX_VALUE_13 = "D";
        String HEX_VALUE_14 = "E";
        String HEX_VALUE_15 = "F";

        if (remainder == 10) {
            return HEX_VALUE_10;
        }
        if (remainder == 11) {
            return HEX_VALUE_11;
        }
        if (remainder == 12) {
            return HEX_VALUE_12;
        }
        if (remainder == 13) {
            return HEX_VALUE_13;
        }
        if (remainder == 14) {
            return HEX_VALUE_14;
        }
        if (remainder == 15) {
            return HEX_VALUE_15;
        }
        return "0";
    }

    public int validateNum(String inputNum) {
        try {
            int validatedNum = Integer.parseInt(inputNum);
            return validatedNum;
        } catch (java.lang.NumberFormatException e) {
            System.out.println("The number you have entered is too large.");
            System.exit(0);
        }
        return 0;
    }

    public BinaryStack numberDivider(int inputNum, String base) {
        // Method for continually dividing decimal by 2 or 16 until it reaches zero
        // We then add each remainder to the stack after the subsequent division
        if (base.equals("b")) {
            BinaryStack binaryArray = new BinaryStack(MAX_BINARY_DIGITS);
            binaryArray.push(String.valueOf(inputNum % 2));
            while (inputNum != 0) {
                inputNum /= 2;
                binaryArray.push(String.valueOf(inputNum % 2));
            }
            return binaryArray;
        }
        else {
            BinaryStack hexArray = new BinaryStack(MAX_HEX_DIGITS);
            int dividedNum = inputNum;

            while (dividedNum != 0) {
                dividedNum /= 16;

                // remainder of dec after division
                int numDiffRemainder = Math.abs(inputNum - (dividedNum * 16));

                // if after dividing we have a difference that is within hex value range
                // push remainder to stack
                if (dividedNum != 0 && dividedNum * 16 != inputNum && numDiffRemainder <= 15) {
                    System.out.println("Difference is: " + numDiffRemainder );
                    if (numDiffRemainder <= 9) {
                        hexArray.push(String.valueOf(numDiffRemainder));
                    }
                    else {
                        // get hex value if 10 >= value <= 15
                        hexArray.push(getHexValue(numDiffRemainder));
                    }
                }
                // remainder of dec after division
                int numRemainder = dividedNum % 16;

                if (numRemainder <= 9) {
                    hexArray.push(String.valueOf(numRemainder));
                }
                else {
                    // get hex value if 10 >= value <= 15
                    hexArray.push(getHexValue(numRemainder));
                }
            }
            return hexArray;
        }
    }

    public String digitConcatenation(BinaryStack digitArray) {
        // pops each non-null value from the stack and concatenates it to one string
        String unconvertedString = "";
        while (!digitArray.isEmpty()) {
            if (digitArray.peek() != null) {
                unconvertedString += digitArray.pop();
            } else {
                digitArray.pop();
            }
            if (digitArray.isEmpty()) {
                return unconvertedString;
            }
        }
        return "no";
    }

    public void convertedPrinter(String convertedString, String base) {
        //prints stack to terminal
        if (base == "hex") {
            System.out.println("Hex is: " + convertedString);
        }
        else {
            System.out.println("Binary is: " + convertedString);
        }
    }
    public static void main(String[] args) {
        if (args.length != 2 || !isValidConversionType(args[0]) || !isNumeric(args[1])) {
            System.out.println("You must provide target conversion type and a numerical " +
                                "value that you wish to convert.");
            System.exit(0);
        }
        else{
            String base = args[0];
            System.out.println("base: "+ base);
            String inputNum = args[1];
            System.out.println("num: "+ inputNum);
            Ex2_7 baseConversion = new Ex2_7();
            int validatedInputNum = baseConversion.validateNum(inputNum);
            BinaryStack digitArray = baseConversion.numberDivider(validatedInputNum, base);
            String unconvertedString = baseConversion.digitConcatenation(digitArray);
            baseConversion.convertedPrinter(unconvertedString, base);
        }

    }
}
