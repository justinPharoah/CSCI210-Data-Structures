/**
 * ObjectStack class
 *
 * @author Richard Stegman
 */
public class ObjectStack implements ObjectStackInterface {
    private Object[] item;
    private int top;

    /**
     * Constructor
     */
    ObjectStack() {
        item = new Object[1];
        top = -1;
    }

    /**
     * Determines whether or not the stack is empty
     *
     * @return true if stack is empty, false if stack is not empty
     */
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Determines whether or not the stack has reached its maximum capacity
     *
     * @return true if stack is full, false if stack is not full
     */
    @Override
    public boolean isFull() {
        return top == item.length - 1;
    }

    /**
     * Removes all elements from the stack
     *
     * @return void
     */
    @Override
    public void clear() {
        item = new Object[1];
        top = -1;
    }

    /**
     * Adds an element to the top of the stack
     *
     * @param o Object that will be pushed onto the top of the stack
     * @return void
     */
    @Override
    public void push(Object o) {
        if (isFull())
            resize(2 * item.length);
        item[++top] = o;
    }

    /**
     * Resizes the array if the stack becomes full
     *
     * @param size the size desired for the array (should be twice the original size)
     * @return void
     */
    private void resize(int size) {
        Object[] temp = new Object[size];
        for (int i = 0; i <= top; i++)
            temp[i] = item[i];
        item = temp;
    }

    /**
     * Removes and returns the top element of the stack
     *
     * @return the top element of the Object stack
     */
    @Override
    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow.");
            System.exit(1);
        }
        Object temp = item[top];
        item[top--] = null;
        if (top == item.length / 4)
            resize(item.length / 2);
        return temp;
    }

    /**
     * Returns the top element of the stack without deleting the element
     *
     * @return the top element of the Object stack
     */
    @Override
    public Object top() {
        if (isEmpty()) {
            System.out.println("Stack Underflow.");
            System.exit(1);
        }
        return item[top];
    }
}
