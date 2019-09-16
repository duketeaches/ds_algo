/**
 * 
 */
package duke.learn.tree.binarytree;

/**
 * @author Kazi
 *
 */
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    /**
     * @param root
     */
    public BinarySearchTree(Node<T> root) {
	this.root = root;
    }

    /**
     * 
     */
    public BinarySearchTree(T value) {
	this.root = new TreeNode<T>(value);
    }

    @Override
    public Node<T> getRoot() {
	return this.root;
    }

    @Override
    public Node<T> insert(T value) {
	Node<T> newNode = new TreeNode<>(value);
	if (root == null) {
	    root = newNode;
	} else {
	    Node<T> currentNode = root;
	    Node<T> parent;
	    while (true) {
		parent = currentNode;
		if (value.compareTo(currentNode.getValue()) < 0) {
		    currentNode = currentNode.getLeft();
		    if (currentNode == null) {
			parent.setLeft(newNode);
			break;
		    }
		} else {
		    currentNode = currentNode.getRight();
		    if (currentNode == null) {
			parent.setRight(newNode);
			break;
		    }
		}
	    }
	}
	return newNode;
    }

    @Override
    public Node<T> find(T value) {
	Node<T> current = root;
	while (!value.equals(current.getValue())) {
	    if (value.compareTo(current.getValue()) < 0) {
		current = current.getLeft();
	    } else {
		current = current.getRight();
	    }
	    if (current == null) {
		return null;
	    }
	}
	return current;
    }

    public void traverseInorder() {
	traverseInorder(root);
    }

    public void traverseInorder(Node<T> localRoot) {
	if (localRoot != null) {
	    traverseInorder(localRoot.getLeft());
	    System.out.println(localRoot.getValue());
	    traverseInorder(localRoot.getRight());
	}
    }

    @Override
    public boolean delete(T value) {
	Node<T> current = root;
	Node<T> parent = root;
	boolean isLeftChild = true;
	Node<T> deletedNode = null;

	// search for key
	while (!value.equals(current.getValue())) {
	    parent = current;
	    if (value.compareTo(current.getValue()) < 0) {
		isLeftChild = true;
		current = current.getLeft();
	    } else {
		isLeftChild = false;
		current = current.getRight();
	    }
	    if (current == null) {
		return false;
	    }
	}

	// Node to be deleted is found
	// If no children, simply delete it
	if (!current.hasLeft() && !current.hasRight()) {
	    if (current == root)// if root, tree is empty.
		root = null;
	    else if (isLeftChild)// disconnect from parent
		parent.setLeft(deletedNode);
	    else
		parent.setRight(deletedNode);
	} else if (current.hasLeft() && !current.hasRight()) {
	    // One Child case1: only left child
	    // if no right child, then replace with the left subtree
	    if (current == root)
		root = current.getLeft();// left child of parent
	    else if (isLeftChild)
		parent.setLeft(current.getLeft());// left child of parent
	    else
		parent.setRight(current.getLeft());// left child of parent
	} else if (!current.hasLeft() && current.hasRight()) {
	    // One Child case2: only right child
	    // If no left child, then replace with the right tree
	    if (current == root)
		root = current.getRight();// left child of parent
	    else if (isLeftChild)
		parent.setLeft(current.getRight());// left child of parent
	    else
		parent.setRight(current.getRight());// left child of parent
	} else {
	    // Node to be deleted has both left and right child
	    // get successor of the node
	    Node<T> successor = findSuccessor(current);
	    // connect parent of current to successor instead
	    if (current == root)
		root = successor;
	    else if (isLeftChild)
		parent.setLeft(successor);
	    else
		parent.setRight(successor);
	    successor.setLeft(current.getLeft());
	}

	return true;
    }

    /**
     * 
     * @param successor
     *                      {@link Node}
     * @return next minimum value greater than the current node using in-order
     */
    private Node<T> findSuccessor(Node<T> node) {
	Node<T> parentOfSuccessor = node;
	Node<T> successor = node;
	Node<T> current = node.getRight(); // go right
	while (current != null) { // until no more children left
	    parentOfSuccessor = successor;
	    successor = current;
	    current = current.getLeft();
	}
	if (successor != (node.getLeft())) {
	    parentOfSuccessor.setLeft(successor.getRight());
	    successor.setRight(node.getRight());
	}
	return successor;
    }

    @Override
    public T findMin() {
	Node<T> last = null;
	Node<T> current = root;
	while (current != null) {
	    last = current;
	    current = current.getLeft();
	}
	return last.getValue();
    }

    @Override
    public T findMax() {
	Node<T> last = null;
	Node<T> current = root;
	while (current != null) {
	    last = current;
	    current = current.getRight();
	}
	return last.getValue();
    }

    public class TreeNode<N extends Comparable<N>> implements Tree.Node<T> {

	private T data;
	private Node<T> left;
	private Node<T> right;

	/**
	 * @param data
	 */
	public TreeNode(T data) {
	    this.data = data;
	}

	@Override
	public int compareTo(Node<T> o) {
	    return this.compareTo(o);
	}

	@Override
	public boolean hasLeft() {
	    return this.left != null;
	}

	@Override
	public boolean hasRight() {
	    return this.right != null;
	}

	@Override
	public T getValue() {
	    return this.data;
	}

	@Override
	public Node<T> setValue(T value) {
	    this.data = value;
	    return this;
	}

	@Override
	public Node<T> getLeft() {
	    return this.left;
	}

	@Override
	public Node<T> setLeft(Node<T> left) {
	    this.left = left;
	    return this;
	}

	@Override
	public Node<T> setLeft(T value) {
	    this.left = new TreeNode<T>(value);
	    return this;
	}

	@Override
	public Node<T> getRight() {
	    return this.right;
	}

	@Override
	public Node<T> setRight(Node<T> right) {
	    this.right = right;
	    return this;
	}

	@Override
	public Node<T> setRight(T value) {
	    this.right = new TreeNode<T>(value);
	    return this;
	}

	@Override
	public String toString() {
	    return "TreeNode [data=" + data + ", left=" + left + ", right=" + right + "]";
	}

    }

    public static void main(String[] args) {
	BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(5);
	tree.insert(3);
	tree.insert(2);
	tree.insert(1);
	tree.insert(4);
	tree.insert(8);
	tree.insert(7);
	tree.insert(6);
	tree.insert(12);
	tree.insert(11);
	tree.insert(10);
	tree.insert(9);
	tree.traverseInorder();
	System.out.println("deleting 5...");
	tree.delete(5);
	System.out.println("**********");
	tree.traverseInorder();
	System.out.println("deleting 6...");
	tree.delete(6);
	System.out.println("**********");
	tree.traverseInorder();
	System.out.println("deleting 11...");
	tree.delete(11);
	System.out.println("**********");
	tree.traverseInorder();
    }

}
