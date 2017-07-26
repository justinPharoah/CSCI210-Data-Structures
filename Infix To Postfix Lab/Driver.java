/**
 * Project Title: CSCI 210 - Infix to Postfix Lab
 * Project Description: Converts an infix expression to a postifix expression and evaluates it
 * Version/Date: Version 3.0 - July 15, 2017 (modified 3 times)
 * How to Start Project: Using a Java IDE, run the code after providing an input text file.
 * Author: Justin Ferrell
 * Palomar ID: *********
 * User Instructions: Must provide a file to be read in. Expressions can have spaces between
 * each character. Each expression must start on its own line.
 */

import java.io.*;
import java.util.Scanner;

/**
 * Driver Class
 *
 * @author Justin Ferrell
 * @version 1.0 - July 15, 2017
 */
public class Driver {
    public static void main(String[] args) throws IOException {
        InfixToPostfix itp = new InfixToPostfix();
        EvalPostfix ep = new EvalPostfix();
        Scanner fileScan = new Scanner(new File("infix.txt"));
        PrintWriter fileWrite = new PrintWriter(new FileWriter("csis.txt"));

        int expNum = 1;
        while (fileScan.hasNext()) {
            String buf = fileScan.nextLine();

            System.out.println("Expression " + expNum + " to be converted is: " + buf);
            fileWrite.println("Expression " + expNum + " to be converted is: " + buf);

            String toEval = itp.infixToPostfix(buf);
            System.out.println("Postfix notation for expression " + expNum + " is: " + toEval);
            fileWrite.println("Postfix notation for expression " + expNum + " is: " + toEval);

            int evaluated = ep.evaluate(toEval);
            System.out.println("Its corresponding evaluation is: " + evaluated + "\n");
            fileWrite.println("Its corresponding evaluation is: " + evaluated + "\n");

            expNum++;
        }
        fileScan.close();
        fileWrite.close();
    }


}
