/**
 * ObjectStackInterface Interface Class
 *
 * @author Richard Stegman
 */
public interface ObjectStackInterface {
    /**
     * Determines whether or not the stack is empty
     *
     * @return true if stack is empty, false if stack is not empty
     */
    boolean isEmpty();

    /**
     * Determines whether or not the stack has reached its maximum capacity
     *
     * @return true if stack is full, false if stack is not full
     */
    boolean isFull();

    /**
     * Removes all elements from the stack
     *
     * @return void
     */
    void clear();

    /**
     * Adds an element to the top of the stack
     *
     * @param o Object that will be pushed onto the top of the stack
     * @return void
     */
    void push(Object o);

    /**
     * Removes and returns the top element of the stack
     *
     * @return the top element of the Object stack
     */
    Object pop();

    /**
     * Returns the top element of the stack without deleting the element
     *
     * @return the top element of the Object stack
     */
    Object top();
}
