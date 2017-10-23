package decHexBin;

public class Binary {

    public final int MAX_BINARY_DIGITS = 33;

    public String validateBinary(String inputBin) {
        if (inputBin.length() > MAX_BINARY_DIGITS) {
            System.out.println("The binary you have entered is too large.");
            System.exit(0);
        }
        return inputBin;
    }
}
