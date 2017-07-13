import java.util.*;
import java.io.*;

/**
 * Decimal Class
 *
 * @author Justin Ferrell
 * @version 2.0 - July 5, 2017
 */

public class Decimal {

    private PrintWriter pw;
    private Scanner sc;
    private int dec;
    private StringBuilder bin;
    private String hex;

    /**
     * Constructor
     *
     * @param pw PrintWriter will be used to write output to file
     */
    public Decimal(PrintWriter pw) {
        this.pw = pw;
        sc = new Scanner(System.in);
        dec = 0;
    }

    /**
     * Executes the conversion between Decimal and Binary
     *
     * @return void
     */
    void decToBin() {
        inputDec();
        toBin();
        outBin();
    }

    /**
     * Executes the conversion between Decimal and Hexadecimal
     *
     * @return void
     */
    void decToHex() {
        inputDec();
        toHex();
        outHex();
    }

    /**
     * Prompts user for a Decimal value and reads the user input
     *
     * @return void
     */
    private void inputDec() {
        System.out.println("Enter a valid integer to convert: ");
        pw.println("Enter a valid integer to convert: ");
        dec = sc.nextInt();
        pw.println("User inputted: " + dec + "\n");
    }

    /**
     * Contains the logic for Decimal to Binary conversion
     * Prints out the resulting decimal value to the console
     *
     * @return void
     */
    private void toBin() {
        bin = new StringBuilder("");

        int tempValue, binValue;
        int value = dec;

        while (value != 0) {
            tempValue = value / 2; //divides by 2 so we can repeat this reduction process the next looping
            binValue = value % 2; //modulo 2 gets the binary values of 1 or 0
            bin.insert(0, binValue);
            value = tempValue;
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

    /**
     * Contains the logic for Decimal to Hexadecimal conversion
     * Prints out the resulting binary value to the console
     *
     * @return void
     */
    private void toHex() {
        hex = "";

        while (dec != 0) {
            int hexValue = dec % 16;
            char hexVal;

            if (hexValue <= 9 && hexValue >= 0)
                hexVal = (char) (hexValue + '0');
            else
                hexVal = (char) (hexValue - 10 + 'A');

            hex = hexVal + hex;

            dec /= 16;

        }
        System.out.println("Your hexadecimal value is: 0x" + hex + "\n");
    }

    /**
     * Writes the resulting hexadecimal value to the file "csis.txt"
     *
     * @return void
     */
    private void outHex() {
        pw.println("Your hexadecimal value is: 0x" + hex + "\n");
    }
}
