package decHexBin;

import ex26.BinaryStack;

public class Main {

    public static boolean isValidConversionType (String str) {
        return (str != null) && (str.equals("b") || str.equals("h"));
    }
    public static boolean isNumeric(String str) {
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
            if (base.equals("d")) {
                Decimal decimalConversion = new Decimal();
                int validatedInputNum = decimalConversion.validateDec(base, inputNum);
                BinaryStack digitArray = decimalConversion.numberDivider(validatedInputNum, base);
                String unconvertedString = decimalConversion.digitConcatenation(digitArray);
                decimalConversion.convertedPrinter(unconvertedString, base);
            }
            else if (base.equals("b")) {

            }
            else if (base.equals("h")) {

            }
        }
    }
}
