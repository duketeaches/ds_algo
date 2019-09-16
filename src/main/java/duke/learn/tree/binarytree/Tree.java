/**
 * 
 */
package duke.learn.tree.binarytree;

/**
 * @author Kazi
 *
 */
public interface Tree<T extends Comparable<T>> {

    Node<T> getRoot();

    Node<T> insert(T value);

    Node<T> find(T value);

    boolean delete(T value);

    T findMin();

    T findMax();

    /**
     * Represents a node of the Tree
     * 
     * @param <T>
     */
    interface Node<T> extends Comparable<Node<T>> {

	boolean hasLeft();

	boolean hasRight();

	T getValue();

	Node<T> setValue(T value);

	Node<T> getLeft();

	Node<T> setLeft(Node<T> left);

	Node<T> setLeft(T value);

	Node<T> getRight();

	Node<T> setRight(Node<T> right);

	Node<T> setRight(T value);

    }
}
