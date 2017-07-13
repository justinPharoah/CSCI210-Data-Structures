/**
 * Project Title: CSCI 210 - Number Systems Lab
 * Project Description: Converts values between Binary, Decimal, and Hexadecimal values.
 * Version/Date: Version 2.0 - July 5, 2017
 * How to Start the Project: Using a Java IDE, run the code. (Wasn't exactly sure what goes here).
 * Author: Justin Ferrell
 * Palomar ID: 011564420
 * User Instructions: Once the program is running, follow the steps specified by the menu
 * that will pop up.
 * DO NOT put spaces in between binary nibbles or anything for that matter.
 * DO NOT use lowercase letters for hexadecimal values.
 */

import java.io.*;

/**
 * Driver Class
 *
 * @author Justin Ferrell
 * @version 2.0 - July 5, 2017
 */
public class Driver {
    public static void main(String[] args) throws IOException {
        int choice;

        PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
        Decimal dec = new Decimal(pw);
        Binary bin = new Binary(pw);
        Hexadecimal hex = new Hexadecimal(pw);
        Menu menu = new Menu(pw);

        do {
            menu.display();
            choice = menu.getSelection();
            switch (choice) {
                case 1:
                    dec.decToBin();
                    break;
                case 2:
                    dec.decToHex();
                    break;
                case 3:
                    bin.binToDec();
                    break;
                case 4:
                    bin.binToHex();
                    break;
                case 5:
                    hex.hexToDec();
                    break;
                case 6:
                    hex.hexToBin();
                    break;
            }
        } while (choice != 7);
        pw.close();
    }
}
