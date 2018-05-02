/**
 * ObjectListNode Interface
 *
 * @author Justin Ferrell
 */
public interface ObjectListNodeInterface {
    void setInfo(Object o);

    Object getInfo();

    void setNext(ObjectListNode p);

    ObjectListNode getNext();
}
