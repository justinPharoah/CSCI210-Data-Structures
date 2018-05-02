/**
 * Project Title: CSCI 210 - Payroll Lab
 * Project Description:
 * Version/Date: Version 1.0 - August 5, 2017
 * How to Start Project: Using a Java IDE, run the code after providing an input text file.
 * Author: Justin Ferrell
 * Palomar ID: 011564420
 * User Instructions: Must provide three files to be read in. One for list of employees,
 *                      one for who to hire, one for who to fire
 *                    Expand csis.txt window slightly to view the proper formatting
 */

import java.io.*;

/**
 * Driver Class
 * @author Justin Ferrell
 * @version 1.0 - August 5, 2017
 */
public class Driver {
    /**
     * Executes and runs Payroll Lab Program
     *
     * @param args List of arguments
     * @throws IOException throws file handling error
     */
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));

        Payroll pr = new Payroll(pw);

        pr.readInEmployees("payfile.txt");
        pr.outputTable();
        pr.outputNumEmployees();
        pr.outputWomenNames();
        pr.outputWeekly();
        pr.giveRaise();
        pr.sortEmployees();
        pr.hireEmployees("hirefile.txt");
        pr.fireEmployees("firefile.txt");

        pw.close();
    }
}
