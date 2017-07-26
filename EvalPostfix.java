/**
 * EvalPostfix Class
 *
 * @author Justin Ferrell
 * @version 2.0 - July 15, 2017
 */
class EvalPostfix {
    private ObjectStack postStack;

    /**
     * Takes the postfix expression and evaluates it, returning an int
     *
     * @param postFixExp the String, in postfix notation, that now needs to be evaluated
     * @return the int answer to the given expression
     */
    int evaluate(String postFixExp) {
        postStack = new ObjectStack();
        int interAns; //will hold the value of the "intermediate answer" of an operation

        postFixExp = deleteSpaces(postFixExp); //deletes spaces from postfix

        for (int i = 0; i < postFixExp.length(); i++) {
            char ch = postFixExp.charAt(i);

            if (ch >= '0' && ch <= '9')
                postStack.push(ch - '0'); //must always push operands onto stack
            else { //executes when an operator is encountered
                int operand1 = (int) postStack.pop();
                int operand2 = (int) postStack.pop();
                switch (ch) { //determines what operation to perform
                    case '^':
                        interAns = (int) Math.pow(operand2, operand1);
                        break;
                    case '+':
                        interAns = operand1 + operand2;
                        break;
                    case '-':
                        interAns = operand2 - operand1;
                        break;
                    case '*':
                        interAns = operand1 * operand2;
                        break;
                    case '/':
                        interAns = operand2 / operand1;
                        break;
                    default:
                        interAns = 0;
                }
                postStack.push(interAns); //push intermediate answer onto stack
            }
        }
        return (int) postStack.pop(); //returns final answer
    }

    /**
     * For easier handling,
     * Deletes the spaces in the postfix expression
     *
     * @param postFix the postfix expression that has yet to be evaluated
     * @return the postfix expression without any spaces between characters
     */
    private String deleteSpaces(String postFix) {
        StringBuilder temp = new StringBuilder(postFix);
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == ' ') {
                temp.deleteCharAt(i);
            }
        }
        return temp.toString();
    }
}
