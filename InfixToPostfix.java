/**
 *  InfixToPostfix Class
 *
 *  @author Justin Ferrell
 *  @version 3.0 - July 15, 2017
 */
class InfixToPostfix {
    private StringBuilder postfixExp;
    private ObjectStack postStack;

    /**
     * Constructor
     */
    InfixToPostfix() {
        postStack = new ObjectStack();
    }

    /**
     * Converts an infix expression to postfix notation
     * SEE comments for a general idea of which lines are intended to execute which rules
     * concerning the conversion from infix to postfix as listed in the textbook
     *
     * @param infixExp the expression, read in from a text file, that needs to be converted.
     * @return the String now converted to postfix notation
     */
    String infixToPostfix(String infixExp) {
        postfixExp = new StringBuilder();

        infixExp = deleteSpaces(infixExp); //delete spaces from infix

        for (int i = 0; i < infixExp.length(); i++) {
            char c = infixExp.charAt(i);

            if (priority(c) >= 2) {
                if (postStack.isEmpty()) //Rule 2
                    postStack.push(c); //push operators onto stack
                else { //Rule 5
                    char currentChar = (char) postStack.top();
                    while (!postStack.isEmpty() && currentChar != '(' && priority(currentChar) > 1) { //either stack is empty, ( is encountered, or lower priority
                        postfixExp.append(postStack.pop()); //pop operators from stack and append to expression
                        if (postStack.isEmpty());
                        else
                            currentChar = (char) postStack.top();
                    }
                    postStack.push(c);
                }
            } else if (priority(c) == 1) { //Rule 2
                if (postStack.isEmpty())
                    postStack.push(c);
                else { //Rule 5
                    char temp = (char) postStack.top();
                    while (!postStack.isEmpty() && temp != '(') { //either stack is empty or ( is encountered
                        postfixExp.append(postStack.pop()); //pop operators from stack and append to expression
                        if (postStack.isEmpty());
                        else
                            temp = (char) postStack.top();

                    }
                    postStack.push(c);
                }
            } else if (c == '(') //Rule 5
                postStack.push(c);
            else if (c == ')') { //Rule 6
                char temp = (char) postStack.top();
                while (!postStack.isEmpty() && temp != '(') { //Rule 5
                    postfixExp.append(postStack.pop()); //pop operators from stack and append to expression
                    if (postStack.isEmpty());
                    else
                        temp = (char) postStack.top();
                }
                postStack.pop();
            } else //Rule 1
                postfixExp.append(c);
        }
        while (!postStack.isEmpty()) { //Rule 3
            postfixExp.append(postStack.pop()); //entire infix is scanned, place remaining stack elements in postfix
        }
        insertSpaces(postfixExp); //insert spaces to expression

        return postfixExp.toString();
    }

    /**
     * Determines the priority between operators
     *
     * @param op the character whose precedence will be determined
     * @return the corresponding number to the precedence of the operator
     */
    private int priority(char op) {
        switch (op) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }

    /**
     * For easier handling,
     * Deletes any spaces that may be in the original expression that is read in
     *
     * @param inFix the String expression that has yet to be converted to postfix notation
     * @return the same String, without any spaces between characters
     */
    private String deleteSpaces(String inFix) {
        StringBuilder temp = new StringBuilder(inFix);
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == ' ') {
                temp.deleteCharAt(i);
            }
        }
        return temp.toString();
    }

    /**
     * For easier viewing,
     * Adds spaces back into the postfix expression to maintain original format
     *
     * @param postFix the String now converted to postfix notation, that needs spaces between each character
     * @return void
     */
    private void insertSpaces(StringBuilder postFix) {
        for (int i = 0; i < postFix.length(); i++) {
            if (i % 2 != 0) {
                postFix.insert(i, ' ');
            }
        }
    }
}
