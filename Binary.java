package decHexBin;


public class Binary {

    public final int MAX_DEC_DIGITS = 12;
    public final int MAX_BINARY_DIGITS = 33;

    public void validateBinary(String inputBin) {
        // validates binary length
        if (inputBin.length() > MAX_BINARY_DIGITS) {
            System.out.println("The binary you have entered is too large.");
            System.exit(0);
        }
    }
    public DigitStack<Integer> binaryDecimalMultiplier(String inputBinary) {
        // Method that multiplies the binary by it's base-10 coefficient and adds it to the stack

        DigitStack<Integer> decimalArray = new DigitStack<>(MAX_DEC_DIGITS);
        Integer binaryPlaceholderValueArray[] = new Integer[inputBinary.length()];

        // add base-2 placeholder powers to array to use when pushing decimal values to stack
        for (int i = 0; i <= inputBinary.length(); i++) {
            binaryPlaceholderValueArray[i] = (int) Math.pow(2, i);
        }

        // reverses array order as we will be evaluating binary from left-to-right
        // which is the opposite that the powers were added to the array
        for(int i = 0; i < binaryPlaceholderValueArray.length / 2; i++)
        {
            int temp = binaryPlaceholderValueArray[i];
            binaryPlaceholderValueArray[i] = binaryPlaceholderValueArray[binaryPlaceholderValueArray.length - i - 1];
            binaryPlaceholderValueArray[binaryPlaceholderValueArray.length - i - 1] = temp;
        }
        // pushes each decimal converted placeholder digit when a '1' is found
        // this is done by accessing the digit's location'th element in the placeholder value array
        for (int j = 0; j <=inputBinary.length()-1; j++) {
            if (inputBinary.charAt(j) == '1') {
                decimalArray.push(binaryPlaceholderValueArray[j]);

            }
        }
    return decimalArray;
    }

    public void binaryHexConverter(String inputBinary) {
        // Method for calculating/multiplying binary digits to hex.
        // This is the main method for the conversion.

        // adds padding to the left of the binary if it is not divisible by four.
        int padding = inputBinary.length() % 4;
        if (padding != 0) {
            for (int i = 1; i<= (4 - padding); i++) {
                inputBinary = "0" + inputBinary;
            }
        }
        // sum variable for all blocks of four digits
        int sum = 0;
        // variable to track which placeholder we are in
        int placeholderNumber = 1;
        System.out.print("Hex: ");

        // loops through the whole binary number, multiplies out each digit and adds it to the sum
        // once the placeholder value, which is incremented each loop, reaches four it will
        // then convert that digit to hex and print it to the terminal.
        for (int i = 0; i < inputBinary.length(); i++) {
            if (placeholderNumber == 1)
                sum+= Integer.parseInt(inputBinary.charAt(i) + "") * 8;
            else if (placeholderNumber == 2)
                sum+= Integer.parseInt(inputBinary.charAt(i) + "") * 4;
            else if (placeholderNumber == 3)
                sum+= Integer.parseInt(inputBinary.charAt(i) + "") * 2;
            else if (placeholderNumber == 4 || i < inputBinary.length()+1) {
                sum += Integer.parseInt(inputBinary.charAt(i) + "") * 1;
                placeholderNumber = 0;
                if (sum < 10)
                    System.out.print(sum);
                else if (sum == 10)
                    System.out.print("A");
                else if (sum == 11)
                    System.out.print("B");
                else if (sum == 12)
                    System.out.print("C");
                else if (sum == 13)
                    System.out.print("D");
                else if (sum == 14)
                    System.out.print("E");
                else if (sum == 15)
                    System.out.print("F");
                sum = 0;
            }
            placeholderNumber++;
        }
        System.out.print("\n");
    }

    public int digitConcatenation(DigitStack decArray) {
        // pops each non-null value from the stack and concatenates it to one string
//        String unconvertedString = "";
        int convertedDec = 0;

        while(!decArray.isEmpty()) {
            if (decArray.peek() != null)
                convertedDec += (int) decArray.pop();

            else
                decArray.pop();
        }
        return convertedDec;
    }

    public void convertedPrinter(int convertedDecString) {
        //prints converted string to terminal
        System.out.println("Decimal: " + convertedDecString);
    }
}