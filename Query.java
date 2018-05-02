import java.io.*;

/**
 * Query Class
 *
 * @author Justin Ferrell
 */
class Query {
    private PrintWriter pw; //PrintWriter Object

    /**
     * Query, one-arg constructor
     *
     * @param pw PrintWriter object
     */
    Query(PrintWriter pw) {
        this.pw = pw;
    }

    //package-private methods

    /**
     * Gets and prints out information on each Word (occurrence, line numbers, line positions)
     *
     * @param bin     ObjectBinaryTree to be searched
     * @param tmpWord Word to be searched for
     */
    void getWordData(ObjectBinaryTree bin, Word tmpWord) {
        ObjectTreeNode t = bin.searchBST(tmpWord);
        ObjectListNode p;
        int wordNum;
        if (t != null) {
            Word word = (Word) t.getInfo();
            String tmpWordVal = word.getWord();
            wordNum = word.getCount();
            ObjectList l = word.getLineList();
            p = l.getFirstNode();

            System.out.printf("%-15s %-5s", tmpWordVal, wordNum);
            pw.printf("%-15s %-5s", tmpWordVal, wordNum);

            if (p != null) {
                do {
                    LinePosition temp = (LinePosition) p.getInfo();
                    int tempLineCount = temp.getLineNum(), tempLinePos = temp.getPosInLine();

                    System.out.printf("%2s %2s %3s", tempLineCount, "-", tempLinePos + "\t");
                    pw.printf("%2s %2s %3s", tempLineCount, "-", tempLinePos + "\t");

                    p = p.getNext();
                } while (p != null);
            }
            System.out.println();
            pw.println();
        } else {
            System.out.println("\nError: Word not found \n");
            pw.println("\nError: Word not found \n");
        }
    }
}