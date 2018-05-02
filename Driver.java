/**
 * Project Title: CSCI 210 - Binary Trees and Hashing Lab
 * Project Description:
 * Version/Date: Version 1.0 - August 18, 2017
 * How to Start Project: Using a Java IDE, run the code after providing an input text file.
 * Author: Justin Ferrell
 * Palomar ID: 011564420
 * User Instructions: Must provide a text file to be read in and used to to be searched and analyzed
 *
 * Note to self: Probably needed to do this lab before the final...
 */

import java.io.*;

/**
 * Driver Class
 *
 * @author Justin Ferrell
 */
public class Driver {
    /**
     * Executes and runs Binary Trees and Hashing Lab Program
     *
     * @param args List of arguments
     * @throws IOException throws file handling error
     */
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
        Hash hash = new Hash(pw);
        Xref xref = new Xref(pw);

        hash.getHash("omit.txt");
        hash.printHash();
        xref.outputTxtFile("getty.txt", "omit.txt");
        xref.inLineTraverse();
        xref.queryWords();
        pw.flush();

        pw.close();
    }
}