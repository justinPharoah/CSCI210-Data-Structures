import java.io.*;

/**
 * Word class
 * implements the Comparable and TreeComparable interfaces
 *
 * @author Justin Ferrell
 */
public class Word implements TreeComparable {
    private PrintWriter pw; //PrintWriter Object
    private int count; //Keeps track of occurrence of words
    private String word; //Current word
    private ObjectList lineList; //references current line

    /**
     * Word, one-arg constructor
     *
     * @param pw PrintWriter object
     */
    Word(PrintWriter pw) {
        this.pw = pw;
        count = 1;
        word = "";
        lineList = new ObjectList();
    }

    //public methods

    /**
     * Compares two Word objects for equality
     *
     * @param o Object to be compared
     * @return int indicating equality (<, =, >)
     */
    @Override
    public int compareTo(Object o) {
        Word w = (Word) o;
        return word.compareTo(w.getWord());
    }

    /**
     * Adds passed in Object to the end of an Object List
     *
     * @param o Object to be added to the ObjectList
     */
    @Override
    public void operate(Object o) {
        Word w = (Word) o;
        ++this.count;
        lineList.addLast(w.getLineList().getFirstNode());
    }

    /**
     * Visits nodes and prints out info on the words
     *
     * @return void
     */
    @Override
    public void visit() {
        String tempWord = this.getWord();
        int tempCtr = this.getCount();
        ObjectList l = this.getLineList();
        ObjectListNode p = l.getFirstNode();

        System.out.printf("%-15s %-5s", tempWord, tempCtr);
        pw.printf("%-15s %-5s", tempWord, tempCtr);

        if (p != null) {
            do {
                LinePosition lVal = (LinePosition) p.getInfo();
                int ctr = lVal.getLineNum(), tempLinePos = lVal.getPosInLine();

                System.out.printf("%2s %2s %3s", ctr, "-", tempLinePos + "\t");
                pw.printf("%2s %2s %3s", ctr, "-", tempLinePos + "\t");

                p = p.getNext();
            } while (p != null);
        }
        System.out.println();
    }

    //package-private methods

    /**
     * Gets and returns current String object held in variable 'word'
     *
     * @return String 'word'
     */
    String getWord() {
        return word;
    }

    /**
     * Sets private variable 'word'
     *
     * @param word String object to be assigned to 'word'
     * @return void
     */
    void setWord(String word) {
        this.word = word;
    }

    /**
     * Gets and returns count variable
     *
     * @return int representing occurrence of current 'word'
     */
    int getCount() {
        return count;
    }

    /**
     * Gets and returns an ObjectList reference to a line in the text file
     *
     * @return ObjectList variable 'lineList'
     */
    ObjectList getLineList() {
        return lineList;
    }

    /**
     * Retrieves a Word object set using a String and ObjectList reference
     *
     * @param tmpStr String to be assigned to the Word
     * @param refer  ObjectList reference
     * @return Word object 'word'
     */
    Word retWordObj(String tmpStr, ObjectList refer) {
        Word word = new Word(pw);
        word.setWord(tmpStr);
        word.setLineList(refer);
        return word;
    }

    //private methods

    /**
     * Sets private variable lineList
     *
     * @param lineList ObjectList object to be assigned to 'lineList'
     * @return void
     */
    private void setLineList(ObjectList lineList) {
        this.lineList = lineList;
    }

}
