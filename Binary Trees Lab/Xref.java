import java.io.*;
import java.util.Scanner;

/**
 * Xref Class
 *
 * @author Justin Ferrell
 */
class Xref {
    private ObjectBinaryTree tree = new ObjectBinaryTree();
    private PrintWriter pw;

    /**
     * Xref, one-arg constructor
     *
     * @param pw PrintWriter object
     * @throws IOException throws file handling error
     */
    Xref(PrintWriter pw) throws IOException {
        this.pw = pw;
    }

    //package-private methods

    /**
     * Prints out given text file line by line with indices indicating each line number
     *
     * @param fileName  name of file to be read in
     * @param fileName2 name of file with words to be omitted (used in getHash method - see Hash Class)
     * @return void
     * @throws IOException throws file handling error
     */
    void outputTxtFile(String fileName, String fileName2) throws IOException {
        Scanner sc = new Scanner(new File(fileName));
        Word word1 = new Word(pw), word2;
        Hash h = new Hash(pw);
        int lineCtr = 0;

        System.out.println("File Contents for " + fileName + ": \n");
        pw.println("File Contents for " + fileName + ": \n");

        while (sc.hasNextLine()) {
            lineCtr++;
            String line = sc.nextLine(), delims = "[ ,.-;]+";
            String[] tokens = line.split(delims);
            ObjectList[] table = h.getHash(fileName2);

            System.out.printf("%2s %-2s", lineCtr, " " + line + "\n");
            pw.printf("%2s %-2s", lineCtr, " " + line + "\n");

            int i = 0;
            while (i < tokens.length) {
                int wordCtr = i + 1;
                if (!h.checkHash(tokens[i], table)) {
                    String tmpStr = tokens[i].toLowerCase();

                    ObjectList l = new ObjectList(), linePos = new ObjectList();
                    LinePosition lPos = new LinePosition(lineCtr, wordCtr);
                    ObjectListNode p = new ObjectListNode();
                    p.setInfo(lPos);
                    l.addLast(p);
                    word2 = word1.retWordObj(tmpStr, l);
                    linePos.addLast(p);
                    tree.insertBSTDup(word2);
                }
                i++;
            }
        }
        System.out.println("\n");
        pw.println("\n");
    }

    /**
     * Performs an in-line traversal of a Binary Tree
     *
     * @return void
     */
    void inLineTraverse() {
        ObjectTreeNode n = tree.getRoot();
        tree.inTrav(n);
    }

    /**
     * Executes a search within the given text file for certain words inputted by user
     *
     * @return void
     */
    void queryWords() {
        Query q = new Query(pw);
        Scanner sc = new Scanner(System.in), scan = new Scanner(System.in);
        String dec, wordInp;

        System.out.println("\nEnter a word to be searched: ");
        pw.println("\nEnter a word to be searched: ");

        wordInp = sc.nextLine();
        ObjectList l = new ObjectList();
        Word word1 = new Word(pw), word2 = word1.retWordObj(wordInp, l);
        q.getWordData(tree, word2);

        System.out.println("\nEnter 'C' to continue another search or Q to quit.");
        pw.println("\nEnter 'C' to continue another search or Q to quit.");

        dec = scan.next();

        while (dec.equals("C") || dec.equals("c")) {
            System.out.println("\nEnter a word to be searched: ");
            pw.println("\nEnter a word to be searched: ");

            wordInp = sc.nextLine();
            l = new ObjectList();
            word1 = new Word(pw);
            word2 = word1.retWordObj(wordInp, l);
            q.getWordData(tree, word2);

            System.out.println("\nEnter 'C' to continue another search or Q to quit.");
            pw.println("\nEnter 'C' to continue another search or Q to quit.");
            dec = scan.next();
        }
    }
}
