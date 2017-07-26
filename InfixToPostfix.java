class InfixToPostfix {
    private StringBuilder postFix;
    private ObjectStack stack;

    InfixToPostfix() {
        stack = new ObjectStack();
    }

    String infixToPostfix(String exp) {
        postFix = new StringBuilder();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == ' ')
                continue;
            else if (priority(c) == 3) {
                if (stack.isEmpty())
                    stack.push(c);
                else {
                    char temp = (char) stack.top();
                    while (temp != '(' && priority(temp) > 2) {
                        postFix.append(stack.pop());
                        if (stack.isEmpty())
                            break;
                        temp = (char) stack.top();
                    }
                    stack.push(c);
                }
            } else if (priority(c) == 2) {
                if(stack.isEmpty())
                    stack.push(c);
                else {
                    char temp = (char) stack.top();
                    while(temp != '(' && priority(temp) > 1) {
                        postFix.append(stack.pop());
                        if(stack.isEmpty())
                            break;
                        temp = (char) stack.top();
                    }
                    stack.push(c);
                }
            } else if (priority(c) == 1) {
                if (stack.isEmpty())
                    stack.push(c);
                else {
                    char temp = (char) stack.top();
                    while(temp != '(') {
                        postFix.append(stack.pop());
                        if (stack.isEmpty())
                            break;
                        temp = (char) stack.top();
                    }
                    stack.push(c);
                }
            } else if (c == '(')
                stack.push(c);
            else if(c == ')') {
                char temp = (char) stack.top();
                while (temp != '(') {
                    postFix.append(stack.pop());
                    if (stack.isEmpty())
                        break;
                    temp = (char) stack.top();
                }
                stack.pop();
            } else
                postFix.append(c);
        }
        while (!stack.isEmpty()) {
            postFix.append(stack.pop());
        }
        return postFix.toString();
    }

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

    private boolean erroneous(String exp) {
        return true;
    }
}
