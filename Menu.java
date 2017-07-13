import java.util.*;
import java.io.*;

/**
 * Menu Class
 *
 * @author Justin Ferrell
 * @version 2.0 - July 5, 2017
 */
public class Menu {

    private Scanner sc;
    private PrintWriter pw;

    /**
     * Constructor
     *
     * @param pw PrintWriter will be used to write output to file
     */
    public Menu(PrintWriter pw) {
        this.pw = pw;
    }

    /**
     * Displays the menu screen to the user on the console.
     * Also writes the menu screen to the file "csis.txt".
     *
     * @return void
     */
    protected void display() {
        System.out.println("Select one of the following operations: \n\n" +
                "1. Decimal to Binary \n" +
                "2. Decimal to Hexadecimal \n" +
                "3. Binary to Decimal \n" +
                "4. Binary to Hexadecimal \n" +
                "5. Hexadecimal to Decimal \n" +
                "6. Hexadecimal to Binary \n" +
                "7. Quit Program");
        pw.println("Select one of the following operations: \n\n" +
                "1. Decimal to Binary \n" +
                "2. Decimal to Hexadecimal \n" +
                "3. Binary to Decimal \n" +
                "4. Binary to Hexadecimal \n" +
                "5. Hexadecimal to Decimal \n" +
                "6. Hexadecimal to Binary \n" +
                "7. Quit Program");
    }

    /**
     * Reads the users selection as to which operation they would like to execute.
     *
     * @return void
     */
    int getSelection() {
        sc = new Scanner(System.in);
        int choiceNum = sc.nextInt();
        pw.println("User executed operation: " + choiceNum + "\n");
        return choiceNum;
    }
}
