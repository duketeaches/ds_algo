/**
 * 
 */
package duke.learn.tree.demo.binarytree;

/**
 * @author Kazi
 *
 */
public interface Tree<T> {

    Node<T> getRoot();

    Node<T> insert(int key, T value);

    Node<T> find(int key);

    boolean delete(int key);

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

	Node<T> setLeft(int key, T value);

	Node<T> getRight();

	Node<T> setRight(Node<T> right);

	Node<T> setRight(int key, T value);

	int getKey();
    }
}
