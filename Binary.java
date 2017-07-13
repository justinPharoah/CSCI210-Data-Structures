import java.util.*;
import java.io.*;

/**
 * Binary Class
 *
 * @author Justin Ferrell
 * @version 2.0 - July 5, 2017
 */
public class Binary {

    private PrintWriter pw;
    private Scanner sc;
    private String bin;
    private int dec;
    private StringBuilder hex;

    /**
     * Constructor
     *
     * @param pw PrintWriter will be used to write output to file
     */
    public Binary(PrintWriter pw) {
        this.pw = pw;
        sc = new Scanner(System.in);
        bin = "";
    }

    /**
     * Executes the conversion between Binary and Decimal
     *
     * @return void
     */
    void binToDec() {
        inputBin();
        toDec();
        outDec();
    }

    /**
     * Executes the conversion between Binary and Hexadecimal
     *
     * @return void
     */
    void binToHex() {
        inputBin();
        toHex();
        outHex();
    }

    /**
     * Prompts user for a Binary value and reads the user input
     *
     * @return void
     */
    private void inputBin() {
        System.out.println("Enter a 32-bit binary number to convert: ");
        pw.println("Enter a 32-bit binary number to convert: ");
        bin = sc.next();
        pw.println("User inputted: " + bin + "\n");
    }

    /**
     * Contains the logic for Binary to Decimal conversion
     * Prints out the resulting decimal value to the console
     *
     * @return void
     */
    private void toDec() {
        dec = 0;
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '1')
                dec += Math.pow(2, bin.length() - 1 - i);
        }
        System.out.println("Your decimal value is: " + dec + "\n");
    }

    /**
     * Writes the resulting decimal value to the file "csis.txt"
     *
     * @return void
     */
    private void outDec() {
        pw.println("Your decimal value is: " + dec + "\n");
    }

    /**
     * Contains the logic for Binary to Hexadecimal conversion
     * Prints out the resulting decimal value to the console
     *
     * @return void
     */
    private void toHex() { //this method's code was inspired by the example from the book's lab instructions
        hex = new StringBuilder("");

        for (int i = 0; i < bin.length() - 3; i += 4) {
            if (bin.substring(i, i + 4).equals("0000"))
                hex.append('0');
            else if (bin.substring(i, i + 4).equals("0001"))
                hex.append('1');
            else if (bin.substring(i, i + 4).equals("0010"))
                hex.append('2');
            else if (bin.substring(i, i + 4).equals("0011"))
                hex.append('3');
            else if (bin.substring(i, i + 4).equals("0100"))
                hex.append('4');
            else if (bin.substring(i, i + 4).equals("0101"))
                hex.append('5');
            else if (bin.substring(i, i + 4).equals("0110"))
                hex.append('6');
            else if (bin.substring(i, i + 4).equals("0111"))
                hex.append('7');
            else if (bin.substring(i, i + 4).equals("1000"))
                hex.append('8');
            else if (bin.substring(i, i + 4).equals("1001"))
                hex.append('9');
            else if (bin.substring(i, i + 4).equals("1010"))
                hex.append('A');
            else if (bin.substring(i, i + 4).equals("1011"))
                hex.append('B');
            else if (bin.substring(i, i + 4).equals("1100"))
                hex.append('C');
            else if (bin.substring(i, i + 4).equals("1101"))
                hex.append('D');
            else if (bin.substring(i, i + 4).equals("1110"))
                hex.append('E');
            else if (bin.substring(i, i + 4).equals("1111"))
                hex.append('F');
        }
        System.out.println("Your hexadecimal value is: 0x" + hex.toString() + "\n");
    }

    /**
     * Writes the resulting hexadecimal value to the file "csis.txt"
     *
     * @return void
     */
    private void outHex() {
        pw.println("Your hexadecimal value is: 0x" + hex.toString() + "\n");
    }
}
