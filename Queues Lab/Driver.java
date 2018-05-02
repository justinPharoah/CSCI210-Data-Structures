/**
 * Project Title: CSCI 210 - Multi-level Feedback Queue Lab
 * Project Description - Uses 4 queues to efficiently simulate job scheduling that
 *                      models that of a computer
 * Version/Date: Version 5.0 - July 26, 2017 (modified 5 times)
 * How to Start Project: Using a Java IDE, run the code after providing an input text file.
 * Author: Justin Ferrell
 * Palomar ID: 011564420
 * User Instructions: Must provide a file with the Jobs to be read in
 *                    PLEASE expand the csis.txt file when you open it so the formatting appears as it should
 *
 * ERRORS: Output is not entirely correct. I tried commenting, modularizing, tracing, and using various forms
 * of debugging on my code but I cannot figure out why it falls apart halfway through.
 * The statistics are also wrong.
 */

import java.io.*;

/**
 * Driver Class
 *
 * @author Richard Stegman (implemented by Justin Ferrell)
 * @version 1.0 - July 26, 2017
 */
public class Driver {

    /**
     * main method
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{
        PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));

        MFQ mfq = new MFQ(pw);
        mfq.getJobs("mfq.txt");
        mfq.outputHeader();
        mfq.runSimulation();
        mfq.outputStats();

        pw.close();
    }

}