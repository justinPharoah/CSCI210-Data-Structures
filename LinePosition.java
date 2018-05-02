/**
 * LinePosition Class
 *
 * @author Justin Ferrell
 */
class LinePosition {
    private int lineNum, posInLine;

    /**
     * LinePosition, two-arg constructor
     * @param lineNum line number within text file
     * @param posInLine position within the line
     */
    LinePosition(int lineNum, int posInLine) {
        this.lineNum = lineNum;
        this.posInLine = posInLine;
    }

    //package-private methods
    /**
     * Returns the current line in the text file
     * @return int representing current line
     */
    int getLineNum() {
        return lineNum;
    }

    /**
     * Returns the current position within the line
     * @return int representing position in line
     */
    int getPosInLine() {
        return posInLine;
    }
}