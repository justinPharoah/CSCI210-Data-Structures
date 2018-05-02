/**
 * ObjectListNode Class
 *
 * @author Richard Stegman
 */
public class ObjectListNode implements ObjectListNodeInterface {
    private Object info;
    private ObjectListNode next;

    /**
     * Default Constructor
     */
    public ObjectListNode() {
        info = null;
        next = null;
    }

    /**
     * One Argument Constructor
     *
     * @param o Object object
     */
    ObjectListNode(Object o) {
        info = o;
        next = null;
    }

    /**
     * Two Argument Constructor
     *
     * @param o Object object
     * @param p ObjectListNode object
     */
    ObjectListNode(Object o, ObjectListNode p) {
        info = o;
        next = p;
    }

    /**
     * Sets info field
     *
     * @param o Object object
     */
    @Override
    public void setInfo(Object o) {
        info = o;
    }

    /**
     * Returns object in info field
     *
     * @return Object object
     */
    @Override
    public Object getInfo() {
        return info;
    }

    /**
     * Sets next field
     *
     * @param p ObjectListNode object
     */
    @Override
    public void setNext(ObjectListNode p) {
        next = p;
    }

    /**
     * Returns object in info field
     *
     * @return ObjectListNode object
     */
    @Override
    public ObjectListNode getNext() {
        return next;
    }
}
