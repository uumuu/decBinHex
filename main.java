package decHexBin;

import ex26.BinaryStack;

public class Main {

    private static boolean isValidConversionType(String str) {
        return (str != null) && (str.equals("b") || str.equals("h"));
    }
    private static boolean isNumeric(String str) {
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }

    public static void main(String[] args) {
        if (args.length != 1 || !isValidConversionType(args[0].substring(0, 1)) ||
                !isNumeric(args[0].substring(1, args[0].length()))) {

            System.out.println("You must provide target conversion type and a numerical " +
                                "value that you wish to convert.");
            System.exit(0);
        }
        else{
            String base = args[0].substring(0, 1);
            String inputNum = args[0].substring(1, args[0].length());
            switch (base) {
                case "d":
                    Decimal decimalConversion = new Decimal();
                    int validatedInputNum = decimalConversion.validateDec(base, inputNum);
                    BinaryStack binaryArray = decimalConversion.decimalBinaryDivider(validatedInputNum);
                    BinaryStack hexArray = decimalConversion.decimalHexDivider(validatedInputNum);
                    String convertedBinaryString = decimalConversion.digitConcatenation(binaryArray);
                    String convertedHexString = decimalConversion.digitConcatenation(hexArray);
                    decimalConversion.convertedPrinter(convertedBinaryString, convertedHexString);
                    break;
                case "b":

                    break;
                case "h":

                    break;
            }
        }
    }
}
