/**
 * 
 */
package duke.learn.tree.demo.binarytree;

/**
 * @author Kazi
 *
 */
public class DemoBinarySearchTree<T> implements Tree<T> {

    private Node<T> root;
    int numberOfSteps = 0;

    public DemoBinarySearchTree(int key, T rootValue) {
	this.root = new TreeNode<T>(key, rootValue, null, null);
    }

    public DemoBinarySearchTree() {
    }

    @Override
    public Node<T> insert(int key, T value) {
	Node<T> newNode = new TreeNode<>(key, value);
	if (root == null) {
	    root = newNode;
	} else {
	    Node<T> currentNode = root;
	    Node<T> parentNode;
	    while (true) {
		parentNode = currentNode;
		if (key < currentNode.getKey()) {
		    currentNode = currentNode.getLeft();
		    if (currentNode == null) {
			parentNode.setLeft(newNode);
			break;
		    }
		} else {
		    currentNode = currentNode.getRight();
		    if (currentNode == null) {
			parentNode.setRight(newNode);
			break;
		    }
		}
	    }
	}
	return newNode;
    }

    @Override
    public Node<T> find(int key) {
	Node<T> currentNode = root;
	// System.out.println("Searching Node -> " + currentNode.getKey());
	numberOfSteps = 1;
	while (key != currentNode.getKey()) {
	    numberOfSteps += 1;
	    if (key < currentNode.getKey()) {
		// System.out.println("going left");
		currentNode = currentNode.getLeft();
	    } else {
		// System.out.println("going right");
		currentNode = currentNode.getRight();
	    }
	    if (currentNode == null) {
		return null;
	    }
	    // System.out.println("Next Node -> " + currentNode.getKey());
	}
	return currentNode;
    }

    public void traverseInorder() {
	traverseInorder(root);
    }

    public void traverseInorder(Node<T> localRoot) {
	if (localRoot != null) {
	    traverseInorder(localRoot.getLeft());
	    System.out.println(localRoot.getKey() + "  :  " + localRoot.getValue());
	    traverseInorder(localRoot.getRight());
	}
    }

    @Override
    public T findMax() {
	Node<T> current, last = null;
	current = root;
	while (current != null) {
	    last = current;
	    current = current.getRight();
	}
	return last.getValue();
    }

    @Override
    public T findMin() {
	Node<T> current, last = null;
	current = root;
	while (current != null) {
	    last = current;
	    current = current.getLeft();
	}
	return last.getValue();
    }

    @Override
    public boolean delete(int key) {

	Node<T> current = root;
	Node<T> parent = root;
	boolean isLeftChild = true;

	while (key != current.getKey()) { // search for node
	    parent = current;
	    if (key < current.getKey()) { // go left?
		isLeftChild = true;
		current = current.getLeft();
	    } else { // go right?
		isLeftChild = false;
		current = current.getRight();
	    }
	    if (current == null) // end of line, didn't find it
		return false;
	}
	// Node to be deleted is found
	// If no children, simply delete it
	if (!current.hasRight() && !current.hasLeft()) {
	    if (current == root) // if root, tree is empty.
		root = null;
	    else if (isLeftChild) // disconnect from parent
		parent.setLeft(null);
	    else
		parent.setRight(null);

	} else if (current.hasLeft() && !current.hasRight()) {
	    // One Child case1: only left child
	    // if no right child, then replace with the left subtree
	    if (current == root) // for root node
		root = current.getLeft();
	    else if (isLeftChild) // left child of parent
		parent.setLeft(current.getLeft());
	    else // left child of parent
		parent.setRight(current.getLeft());
	} else if (current.hasRight() && !current.hasLeft()) {
	    // One Child case2: only right child
	    // If no left child, then replace with the right tree
	    if (current == root)// for root node
		root = current.getRight();
	    else if (isLeftChild)// left child of parent
		parent.setLeft(current.getRight());
	    else // left child of parent
		parent.setRight(current.getRight());
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
	    // current the left child
	    successor.setLeft(current.getLeft());
	}
	return true;
    }

    /**
     * 
     * @param node
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
	if (successor != node.getRight()) { // If successor is not the right child of the node to be deleted
	    parentOfSuccessor.setLeft(successor.getRight());
	    successor.setRight(node.getRight());
	}
	return successor;

    }

    public void TraverseDFS() {
    }

    public class TreeNode<N> implements Tree.Node<T> {
	private T value;
	private int key;
	private Node<T> left;
	private Node<T> right;

	/**
	 * @param value
	 * @param left
	 * @param right
	 */
	public TreeNode(int key, T value, Node<T> left, Node<T> right) {
	    this.value = value;
	    this.key = key;
	    this.left = left;
	    this.right = right;
	}

	/**
	 * @param value
	 */
	public TreeNode(int key, T value) {
	    this.key = key;
	    this.value = value;
	}

	public boolean hasLeft() {
	    return this.left != null;
	}

	public boolean hasRight() {
	    return this.right != null;
	}

	public T getValue() {
	    return value;
	}

	public Node<T> setValue(T value) {
	    this.value = value;
	    return this;
	}

	public Node<T> getLeft() {
	    return this.left;
	}

	public Node<T> getRight() {
	    return this.right;
	}

	@Override
	public Node<T> setLeft(Node<T> left) {
	    this.left = left;
	    return this;
	}

	@Override
	public Node<T> setRight(Node<T> right) {
	    this.right = right;
	    return this;
	}

	@Override
	public Node<T> setLeft(int key, T value) {
	    this.left = new TreeNode<T>(key, value);
	    return this;
	}

	@Override
	public Node<T> setRight(int key, T value) {
	    this.right = new TreeNode<T>(key, value);
	    return this;
	}

	public int getKey() {
	    return key;
	}

	@Override
	public int compareTo(Node<T> o) {
	    return this.key - o.getKey();
	}

	@Override
	public String toString() {
	    return key + " : " + value;
	}

    }

    public Node<T> getRoot() {
	return this.root;
    }

    public void setRoot(Node<T> root) {
	this.root = root;
    }

    public static void main(String[] args) {
	DemoBinarySearchTree<Integer> binaryTree = new DemoBinarySearchTree<Integer>();
	// Insert random
	/*
	 * Random random = new Random(); Random randomString = new Random(); byte[]
	 * array = new byte[5]; for (int i = 0; i < 20; i++) { int key =
	 * random.nextInt(20); randomString.nextBytes(array); String value = new
	 * String(array, Charset.forName("UTF-8")); binaryTree.insert(key, value); } int
	 * On = 0; Random newRand = new Random(); for (int i = 0; i < 20; i++) { Node
	 * found = binaryTree.find(newRand.nextInt(20)); System.out.println(found !=
	 * null ? "found: " + found : "Not found"); System.out.println("O(n) = " +
	 * binaryTree.numberOfSteps); On += binaryTree.numberOfSteps; } //
	 * System.out.println("Mean O(n) = " + On / 100000);
	 * binaryTree.traverseInorder(binaryTree.root); System.out.println("min: " +
	 * binaryTree.findMin()); System.out.println("max: " + binaryTree.findMax());
	 */
	// Node<String> myNode = binaryTree.find(3);
	// System.out.println(myNode);
	// System.out.println("O(n) = " + binaryTree.numberOfSteps);
	binaryTree.insert(3, 3);
	binaryTree.insert(0, 0);
	binaryTree.insert(10, 10);
	binaryTree.insert(5, 5);
	binaryTree.insert(1, 1);
	binaryTree.insert(2, 2);
	binaryTree.insert(6, 6);
	binaryTree.insert(17, 17);
	binaryTree.insert(15, 15);
	binaryTree.insert(13, 13);
	binaryTree.insert(12, 12);
	binaryTree.insert(14, 14);
	binaryTree.insert(16, 16);
	binaryTree.insert(18, 18);
	binaryTree.insert(19, 19);
	binaryTree.traverseInorder();
	binaryTree.delete(10);
	binaryTree.traverseInorder();
	binaryTree.delete(12);
	binaryTree.traverseInorder();

    }

    @Override
    public String toString() {
	return "BinaryTree [root=" + root + "]";
    }
}
