import java.io.*;
import java.util.*;

/**
 * Hash Class
 *
 * @author Justin Ferrell
 */
class Hash {
    private PrintWriter pw; //PrintWriter Object
    private int numColl; //will hold number of collisions whilst hashing
    private ObjectList[] table; //the hash table
    private String[] tokens; //used later to split text file
    private ArrayList<String> omitList; //holds all words to be omitted

    /**
     * Hash, one-arg constructor
     *
     * @param pw PrintWriter object
     */
    Hash(PrintWriter pw) {
        this.pw = pw;
        numColl = 0;
        table = new ObjectList[37];
        omitList = new ArrayList<>();
    }

    //package-private methods

    /**
     * Creates hash function and table
     *
     * @param fileName name of text file to be read in
     * @return ObjectList table
     * @throws IOException throws file handling error
     */
    ObjectList[] getHash(String fileName) throws IOException {
        fillOmitList(fileName, omitList);
        numColl = 0;
        for (String wordElem : omitList) {
            int hashValue, sum = 0;
            char[] arr = wordElem.toCharArray();

            for (char tmpChar : arr) sum += tmpChar;

            hashValue = sum % 37;
            ObjectListNode p = new ObjectListNode();
            Word word = new Word(pw);
            word.setWord(wordElem);
            p.setInfo(word);
            ObjectList l = new ObjectList();

            if (table[hashValue] == null) {
                l.addLast(p);
                table[hashValue] = l;
            } else {
                numColl++;
                l = table[hashValue];
                l.addLast(p);
                table[hashValue] = l;
            }
        }
        return table;
    }

    /**
     * Prints out description of hash function and resulting hash table with indices
     *
     * @return void
     */
    void printHash() {
        System.out.println("Description of Hash Function: ");
        pw.println("Description of Hash Function: ");

        System.out.println("Hashing is executed by assigning a value for each word. " +
                "\nUsing % 37, the word is then mapped/inserted into an array, or hash table. \n");
        pw.println("Hashing is executed by assigning a value for each word. " +
                "\nUsing % 37, the word is then mapped/inserted into an array, or hash table. \n");

        System.out.println("Display of Hash Table w/Array Indices: ");
        pw.println("Display of Hash Table w/Array Indices: ");

        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                ObjectList l = table[i];
                ObjectListNode p = l.getFirstNode();

                System.out.print("[" + i + "] = ");
                pw.print("[" + i + "] = ");

                while (p != null) {
                    Word word = (Word) p.getInfo();
                    String tmpWordVal = word.getWord();

                    System.out.print(tmpWordVal + " ");
                    pw.print(tmpWordVal + " ");

                    p = p.getNext();
                }
                System.out.println();
                pw.println();
            } else {
                System.out.println("[" + i + "] = null");
                pw.println("[" + i + "] = null");
            }
        }
        Hash h = new Hash(pw);
        int colCtr = h.getNumColl();

        System.out.println("Collisions: " + colCtr + "\n");
        pw.println("Collisions: " + colCtr + "\n");
    }

    /**
     * Returns if a String object is found in the hash table
     *
     * @param tmpStr    String to be searched for
     * @param hashTable hash table to be searched in
     * @return boolean true or false if found
     */
    boolean checkHash(String tmpStr, ObjectList hashTable[]) {
        char[] arr = tmpStr.toCharArray();
        int sum = 0, hashValue = sum % 37;

        for (char aCharArray : arr) sum += aCharArray;

        ObjectList l = hashTable[hashValue];

        if (l == null) return false;
        ObjectListNode p = l.getFirstNode();
        while (p != null) {
            Word temp = (Word) p.getInfo();
            String tempString = temp.getWord();
            if (tempString.equals(tmpStr)) return true;
            else p = p.getNext();
        }
        return false;
    }

    //private methods

    /**
     * Takes the text file of words to omit, reads them in, fills the ArrayList with those words
     *
     * @param fileName name of file with the words to omit
     * @param list     ArrayList to be filled
     * @return void
     * @throws IOException throws file handling error
     */
    private void fillOmitList(String fileName, List<String> list) throws IOException {
        Scanner sc = new Scanner(new File(fileName));
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String delims = "[ ]++";
            tokens = line.split(delims);
        }
        Collections.addAll(list, tokens);
    }

    /**
     * Returns the number of collisions resulting from the design of the hash function
     *
     * @return int representing collisions
     */
    private int getNumColl() {
        return numColl;
    }

}