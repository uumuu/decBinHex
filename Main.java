package decHexBin;

public class Main {

    private static boolean isValidConversionType(String str) {
        return (str != null) && (str.equals("d") || str.equals("b") || str.equals("h"));
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
                    int validatedInputDec = decimalConversion.validateDec(inputNum);
                    DigitStack binaryArray = decimalConversion.decimalBinaryDivider(validatedInputDec);
                    DigitStack hexArray = decimalConversion.decimalHexDivider(validatedInputDec);
                    String convertedBinaryString = decimalConversion.digitConcatenation(binaryArray);
                    String convertedHexString = decimalConversion.digitConcatenation(hexArray);
                    decimalConversion.convertedPrinter(convertedBinaryString, convertedHexString);
                    break;
//                case "b":
//                    Binary binaryConversion = new Binary();
//                    String validatedInputBinary = binaryConversion.validateBinary(inputNum);
////                    BinaryStack decArray
//                    break;
//                case "h":
//
//                    break;
            }
        }
    }
}
