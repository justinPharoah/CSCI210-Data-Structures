import java.util.*;
import java.io.*;

/**
 * Hexadecimal Class
 *
 * @author Justin Ferrell
 * @version 2.0 - July 5, 2017
 */
public class Hexadecimal {

    private PrintWriter pw;
    private Scanner sc;
    private String hex;
    private int sumEachDec;
    private StringBuilder bin;
    private final String HEX_HELPER = "0123456789ABCDEF";

    /**
     * Constructor
     *
     * @param pw PrintWriter will be used to write output to file
     */
    public Hexadecimal(PrintWriter pw) {
        this.pw = pw;
        sc = new Scanner(System.in);
        hex = "";

    }

    /**
     * Executes the conversion between Hexadecimal and Decimal
     *
     * @return void
     */
    void hexToDec() {
        inputHex();
        toDec();
        outDec();
    }

    /**
     * Executes the conversion between Hexadecimal and Binary
     *
     * @return void
     */
    void hexToBin() {
        inputHex();
        toBin();
        outBin();
    }

    /**
     * Prompts user for a Hexadecimal value and reads the user input
     *
     * @return void
     */
    private void inputHex() {
        System.out.println("Enter a Hexadecimal number to convert: ");
        pw.println("Enter a Hexadecimal number to convert: ");
        hex = sc.next();
        pw.println("User inputted: " + hex + "\n");
    }

    /**
     * Contains the logic for Hexadecimal to Decimal conversion
     * Prints out the resulting decimal value to the console
     *
     * @return void
     */
    private void toDec() {
        int exponent = 0;
        int resultDec = 0;
        char hexValue;
        for (int i = 0; i < hex.length(); i++) {
            hexValue = hex.charAt(hex.length() - i - 1);
            resultDec += HEX_HELPER.indexOf(hexValue) * (int) Math.pow(16, exponent);
            exponent++;
        }
        System.out.println("Your Decimal value is: " + resultDec + "\n");
    }

    /**
     * Writes the resulting decimal value to the file "csis.txt"
     *
     * @return void
     */
    private void outDec() {
        pw.println(sumEachDec);
    }

    /**
     * Contains the logic for Hexadecimal to Binary conversion
     * Prints out the resulting binary value to the console
     *
     * @return void
     */
    private void toBin() { //this method's code was inspired by the example from the book's lab instructions
        bin = new StringBuilder("");

        for (int i = 0; i < hex.length(); i++) {
            if (hex.substring(i, i + 1).equals("0"))
                bin.append("0000");
            else if (hex.substring(i, i + 1).equals("1"))
                bin.append("0001");
            else if (hex.substring(i, i + 1).equals("2"))
                bin.append("0010");
            else if (hex.substring(i, i + 1).equals("3"))
                bin.append("0011");
            else if (hex.substring(i, i + 1).equals("4"))
                bin.append("0100");
            else if (hex.substring(i, i + 1).equals("5"))
                bin.append("0101");
            else if (hex.substring(i, i + 1).equals("6"))
                bin.append("0110");
            else if (hex.substring(i, i + 1).equals("7"))
                bin.append("0111");
            else if (hex.substring(i, i + 1).equals("8"))
                bin.append("1000");
            else if (hex.substring(i, i + 1).equals("9"))
                bin.append("1001");
            else if (hex.substring(i, i + 1).equals("A"))
                bin.append("1010");
            else if (hex.substring(i, i + 1).equals("B"))
                bin.append("1011");
            else if (hex.substring(i, i + 1).equals("C"))
                bin.append("1100");
            else if (hex.substring(i, i + 1).equals("D"))
                bin.append("1101");
            else if (hex.substring(i, i + 1).equals("E"))
                bin.append("1110");
            else if (hex.substring(i, i + 1).equals("F"))
                bin.append("1111");
        }
        System.out.println("Your binary value is: 0b" + bin + "\n");
    }

    /**
     * Writes the resulting binary value to the file "csis.txt"
     *
     * @return void
     */
    private void outBin() {
        pw.println("Your binary value is: 0b" + bin + "\n");
    }
}
