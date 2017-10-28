package decHexBin;

public class Hexadecimal {
    public final int MAX_HEX_DIGITS = 8;
    public final int MAX_DEC_DIGITS = 12;

    private int getDecValue(char hex) {
        // takes in the hex string and returns its decimal value

        hex = Character.toLowerCase(hex);
        int HEX_VALUE_A = 10;
        int HEX_VALUE_B = 11;
        int HEX_VALUE_C = 12;
        int HEX_VALUE_D = 13;
        int HEX_VALUE_E = 14;
        int HEX_VALUE_F = 15;

        if (hex == 'a') {
            return HEX_VALUE_A;
        }
        if (hex == 'b') {
            return HEX_VALUE_B;
        }
        if (hex == 'c') {
            return HEX_VALUE_C;
        }
        if (hex == 'd') {
            return HEX_VALUE_D;
        }
        if (hex == 'e') {
            return HEX_VALUE_E;
        }
        if (hex == 'f') {
            return HEX_VALUE_F;
        }
        return 0;
    }

    private String getBinValue(int placeholderNum){
        if (placeholderNum == 0)
            return "0001";
        else if (placeholderNum == 1)
            return "0010";
        else if (placeholderNum == 2)
            return "0011";
        else if (placeholderNum == 3)
            return "0100";
        else if (placeholderNum == 4)
            return "0101";
        else if (placeholderNum == 5)
            return "0110";
        else if (placeholderNum == 6)
            return "0111";
        else if (placeholderNum == 7)
            return "1000";
        else if (placeholderNum == 8)
            return "1001";
        else if (placeholderNum == 9)
            return "1010";
        else if (placeholderNum == 10)
            return "1011";
        else if (placeholderNum == 11)
            return "1100";
        else if (placeholderNum == 12)
            return "1101";
        else if (placeholderNum == 13)
            return "1110";
        else if (placeholderNum == 14)
            return "1111";

        return "0";
    }

    public void validateHex(String inputNum){
        if (inputNum.length() > MAX_HEX_DIGITS){
            System.out.println("The hexadecimal you have entered is too large.");
            System.exit(0);
        }
    }

    public DigitStack hexDecimalMultiplier(String inputNum){
        DigitStack<Integer> decArray = new DigitStack<>(MAX_DEC_DIGITS);
        Integer hexPlaceholderValArray[] = new Integer[inputNum.length()];

        // populate hex placeholder array that we use to multiply to convert to decimal
        for (int i = 0; i < inputNum.length(); i++){
            hexPlaceholderValArray[i] = (int) Math.pow(16, i);
        }

        // reverse order of the array so we can multiply in the correct order
        for (int j = 0; j < inputNum.length() /2; j++){
            int temp = hexPlaceholderValArray[j];
            hexPlaceholderValArray[j] = hexPlaceholderValArray[hexPlaceholderValArray.length - j - 1];
            hexPlaceholderValArray[hexPlaceholderValArray.length - j - 1] = temp;
        }

        // pushes each digit calculation to stack
        for (int k = 0; k <= inputNum.length()-1; k++){
            if(Character.isAlphabetic(inputNum.charAt(k))) {
                int decValue = getDecValue(inputNum.charAt(k));
                decArray.push(decValue*hexPlaceholderValArray[k]);
            }else {
                int decValue = inputNum.charAt(k) - 48;
                decArray.push(decValue * hexPlaceholderValArray[k]);
            }
        }
        return decArray;
    }

    public int digitConcatenation(DigitStack decArray){
        // pops all the decimal values from the stack and adds them together
        int convertedDec = 0;

        while(!decArray.isEmpty()){
            if(decArray.peek() != null){
                convertedDec += (int) decArray.pop();
            }else{
                decArray.pop();
            }
        }
        return convertedDec;
    }

    public void hexBinaryConverter(String inputHex){

        // array for 1-15 binary values
        String[] binValueArray = new String[15];

        // populate 1-15 binary values
        for (int i = 0; i < 15; i++){
            binValueArray[i] = getBinValue(i);
        }

        String convertedBinary = "";
        // iterate through each hex digit and convert to binary using the array we created.
        for (int i = 0; i < inputHex.length(); i++){
            if(Character.isAlphabetic(inputHex.charAt(i))){
                convertedBinary = convertedBinary + binValueArray[getDecValue(inputHex.charAt(i))-1]+ " ";
            }else{
                convertedBinary = convertedBinary + binValueArray[(inputHex.charAt(i) - 48) -1] + " ";
            }
        }
        System.out.println("Binary is: "+convertedBinary);

    }

    public void convertedPrinter(int convertedDec){
        // prints the converted decimal value
        System.out.println("Decimal: " + convertedDec);
    }
}
