/**
 * TreeComparable interface
 *
 * @author Justin Ferrell
 */
public interface TreeComparable {
    int compareTo(Object o);

    void operate(Object o);

    void visit();
}
