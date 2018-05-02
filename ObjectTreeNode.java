/**
 * ObjectTreeNode Class
 *
 * @author Richard Stegman
 */
public class ObjectTreeNode implements ObjectTreeNodeInterface {
    private Object info;
    private ObjectTreeNode left;
    private ObjectTreeNode right;

    /**
     * ObjectTreeNode Default Constructor
     */
    ObjectTreeNode() {
        info = null;
        left = null;
        right = null;
    }

    /**
     * ObjectTreeNode, one-arg constructor
     *
     * @param o Object to assign to 'info'
     */
    ObjectTreeNode(Object o) {
        info = o;
        left = null;
        right = null;
    }

    /**
     * Sets info based off Object parameter
     *
     * @param o Object to be assigned to info
     * @return void
     */
    public void setInfo(Object o) {
        info = o;
    }

    /**
     * Gets and returns Object info
     *
     * @return Object 'info'
     */
    public Object getInfo() {
        return info;
    }

    /**
     * Sets Left node of tree node
     *
     * @param p ObjectTreeNode to be set
     * @return void
     */
    public void setLeft(ObjectTreeNode p) {
        left = p;
    }

    /**
     * Gets and returns left node
     *
     * @return ObjectTreeNode 'left'
     */
    public ObjectTreeNode getLeft() {
        return left;
    }

    /**
     * Sets Right node of tree node
     *
     * @param p ObjectTreeNode to be set
     * @return void
     */
    public void setRight(ObjectTreeNode p) {
        right = p;
    }

    /**
     * Gets and returns right node
     *
     * @return ObjectTreeNode 'right'
     */
    public ObjectTreeNode getRight() {
        return right;
    }
}

