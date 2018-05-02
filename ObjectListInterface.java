/**
 * ObjectList Interface
 *
 * @author Justin Ferrell
 */
public interface ObjectListInterface {
    ObjectListNode getFirstNode();

    ObjectListNode getLastNode();

    Object getFirst();

    Object getLast();

    void addFirst(Object o);

    void addFirst(ObjectListNode p);

    void addLast(Object o);

    void addLast(ObjectListNode p);

    Object removeFirst();

    Object removeLast();

    void insertAfter(ObjectListNode p, Object o);

    void insertAfter(ObjectListNode p, ObjectListNode q);

    Object deleteAfter(ObjectListNode p);

    void insert(Object o);

    void insert(ObjectListNode r);

    Object remove(Object o);

    boolean contains(Object o);

    ObjectListNode select(Object o);

    boolean isEmpty();

    void clear();

    int size();

    ObjectList copyList();

    void reverse();
}
