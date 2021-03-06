package decHexBin;
public class Decimal {

    private final int MAX_BINARY_DIGITS = 33;
    private final int MAX_HEX_DIGITS = 10;

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

    public int validateDec(String inputDec) {
        // Method that validates decimal inputs to see if it is within legal length.
        try {
            return Integer.parseInt(inputDec);
        } catch (java.lang.NumberFormatException e) {
            System.out.println("The number you have entered is too large.");
            System.exit(0);
        }
        return 0;
    }

    public DigitStack<String> decimalBinaryDivider(int inputNum) {
        // Method for continually dividing decimal by 2 until it reaches zero
        // We then add each remainder to the stack after the subsequent division
         DigitStack<String> binaryArray = new DigitStack<>(MAX_BINARY_DIGITS);
        binaryArray.push(String.valueOf(inputNum % 2));
        while (inputNum != 0) {
            inputNum /= 2;
            binaryArray.push(String.valueOf(inputNum % 2));
        }
        return binaryArray;
    }

    public DigitStack<String> decimalHexDivider(int inputNum) {
        // Method for continually dividing decimal by 16 until it reaches zero
        // We then add each remainder to the stack after the subsequent division

        DigitStack<String> hexArray = new DigitStack<>(MAX_HEX_DIGITS);
        int dividedNum = inputNum;

        while (dividedNum != 0) {
            dividedNum /= 16;

            // remainder of dec after division
            int numDiffRemainder = Math.abs(inputNum - (dividedNum * 16));

            // if after dividing we have a difference that is within hex value range
            // push remainder to stack
            if (dividedNum != 0 && dividedNum * 16 != inputNum && numDiffRemainder <= 15) {
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

    public String digitConcatenation(DigitStack digitArray) {
        // pops each non-null value from the stack and concatenates it to one string
        String unconvertedString = "";
        while (!digitArray.isEmpty()) {
            if (digitArray.peek() != null) {
                unconvertedString += digitArray.pop();
            } else {
                digitArray.pop();
            }
//            if (digitArray.isEmpty()) {
//                return unconvertedString;
//            }
        }
        return unconvertedString;
    }

    public void convertedPrinter(String convertedBinary, String convertedHex) {
        //prints stack to terminal
        System.out.println("Binary: " + convertedBinary.substring(1, convertedBinary.length()));
        System.out.println("Hex: " + convertedHex.substring(1, convertedHex.length()));
    }
}