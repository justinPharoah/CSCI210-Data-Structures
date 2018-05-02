/**
 * ObjectQueue Class
 *
 * @author Richard Stegman
 */
public class ObjectQueue implements ObjectQueueInterface {

    private Object[] item;
    private int front;
    private int rear;
    private int count;

    /**
     * Constructor
     */
    ObjectQueue() {
        item = new Object[1];
        front = 0;
        rear  = -1;
        count = 0;
    }

    /**
     * Determines whether or not the queue is empty
     *
     * @return true if queue is empty, false if queue is not empty
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Determines whether or not the queue is full
     *
     * @return true if queue is full, false if queue is not full
     */
    @Override
    public boolean isFull() {
        return count == item.length;
    }

    /**
     * Removes all elements from the queue
     *
     * @return void
     */
    @Override
    public void clear() {
        item = new Object[1];
        front = 0;
        rear  = -1;
        count = 0;
    }

    /**
     * Adds an element to the rear of the queue (FIFO)
     *
     * @param o Object that will be inserted onto the rear of the queue
     * @return void
     */
    @Override
    public void insert(Object o) {
        if (isFull())
            resize(2 * item.length);
        rear = (rear+1) % item.length;
        item[rear] = o;
        ++count;
    }

    /**
     * Removes and returns the front element of the queue
     *
     * @return the front element of the Object queue
     */
    @Override
    public Object remove() {
        if (isEmpty()) {
            new Exception("Remove Runtime Error: Queue Underflow").printStackTrace();
            System.exit(1);
        }
        Object temp = item[front];
        item[front] = null;
        front = (front+1) % item.length;
        --count;
        if (count == item.length/4 && item.length != 1)
            resize(item.length/2);
        return temp;
    }

    /**
     * Returns the front element of the queue without deleting the element
     *
     * @return the front element of the Object queue
     */
    @Override
    public Object query() {
        if (isEmpty()) {
            new Exception("Query Runtime Error: Queue Underflow").printStackTrace();
            System.exit(1);
        }
        return item[front];
    }

    /**
     * Resize the array if the queue becomes full
     *
     * @param size the size desired for the array
     * @return void
     */
    private void resize(int size) {
        Object[] temp = new Object[size];
        for (int i = 0; i < count; ++i) {
            temp[i] = item[front];
            front = (front+1) % item.length;
        }
        front = 0;
        rear = count-1;
        item = temp;
    }
}

