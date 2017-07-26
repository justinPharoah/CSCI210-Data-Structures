
public interface ObjectStackInterface {
    boolean isEmpty();

    boolean isFull();

    void clear();

    void push(Object o);

    Object pop();

    Object top();
}
