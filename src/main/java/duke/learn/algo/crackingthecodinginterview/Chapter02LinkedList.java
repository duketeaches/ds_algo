/**
 * 
 */
package duke.learn.algo.crackingthecodinginterview;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import duke.learn.algo.crackingthecodinginterview.Chapter02LinkedList.LinkedList.Node;

/**
 * @author Kazi
 *
 */
public class Chapter02LinkedList {

    /**
     * Write code to remove duplicates from an unsorted linked list <br>
     * time : <b>O(N)</b> , space : <b>O(N)</b>
     * 
     */
    public static void removeDups(LinkedList list) {
	Node n = list.head;
	Set<Integer> elements = new HashSet<>();
	Node prev = null;
	while (n != null) {
	    if (elements.contains(n.data)) {
		prev.next = n.next;
	    } else {
		elements.add(n.data);
		prev = n;
	    }
	    n = n.next;
	}
	System.out.println(list);
    }

    /**
     * Write code to remove duplicates from an unsorted linked list <b>Without any
     * buffer</b><br>
     * time : <b>O(N<sup>2</sup>)</b> , space : <b>O(1)</b>
     * 
     */
    public static void removeDupsNoBuffer(LinkedList list) {
	Node current = list.head;
	while (current != null) {
	    // remove all the future nodes with this value..
	    Node runner = current;
	    while (runner.next != null) {
		if (runner.next.data == current.data)
		    runner.next = runner.next.next;
		else
		    runner = runner.next;
	    }
	    current = current.next;
	}
	System.out.println(list);
    }

    /**
     * Implement an algorithm to find kth of the last element of a singly linked
     * list ><br>
     * time : <b>O(n)</b> , space : <b>O(n)</b>
     */
    public static void findKthLastElementRec(LinkedList list, int k) {
	Node node = kthToLast(list.head, k, new Index());
	System.out.println(node.data);
    }

    private static class Index {
	private int val = 0;
    }

    private static Node kthToLast(Node head, int k, Index index) {
	if (head == null)
	    return head;
	Node node = kthToLast(head.next, k, index);
	index.val = index.val + 1;
	if (k == index.val)
	    return head;
	return node;
    }

    /**
     * Implement an algorithm to find kth of the last element of a singly linked
     * list ><br>
     * Use 2 pointers p1 and p2. Place them k nodes apart by placing p1 at the
     * beginning and p2 and kth position from start.<br>
     * Then move both at same pace until p2 hits the end. Here p1 is the kth
     * element.
     *
     * <br>
     * time : <b>O(n)</b> , space : <b>O(1)</b>
     */
    public static void findKthLastElementItr(LinkedList list, int k) {
	Node p1 = list.head;
	Node p2 = list.head;
	// move p2 at kth position
	for (int i = 0; p2 != null && i < k; i++) {
	    p2 = p2.next;
	}
	while (p2 != null) {
	    p1 = p1.next;
	    p2 = p2.next;
	}
	System.out.println(p1.data);
    }

    /**
     * Write a program to partition a linked list around a value x, such that all
     * nodes less that x come before all nodes greater than or equal to x
     * 
     * @param list
     * @param partition
     */
    public static void partitionList(LinkedList list, int partition) {
	LinkedList left = new LinkedList();
	LinkedList right = new LinkedList();
	Node head = list.head;
	while (head != null) {
	    int data = head.data;
	    if (data < partition)
		left.add(data);

	    else if (data >= partition)
		right.add(data);
	    head = head.next;
	}
	Node r = right.head;
	while (r != null) {
	    left.add(r.data);
	    r = r.next;
	}
	System.out.println(left);

    }

    /**
     * <b>Sum Lists:</b> You have two numbers represented by a linked list, where
     * each node contains a single<br>
     * digit. The digits are stored in reverse order, such that the 1 's digit is at
     * the head of the list. Write a<br>
     * function that adds the two numbers and returns the sum as a linked list.<br>
     * EXAMPLE<br>
     * Input: (7-> 1 -> 6) + (5 -> 9 -> 2) .Thatis,617 + 295.<br>
     * Output: 2 -> 1 -> 9. That is, 912.<br>
     * FOLLOW UP<br>
     * Suppose the digits are stored in forward order. Repeat the above problem.<br>
     * EXAMPLE<br>
     * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.<br>
     * Output: 9 -> 1 -> 2. That is, 912.<br>
     * 
     * @param list1
     * @param list2
     */
    public static void sumList(LinkedList list1, LinkedList list2) {
	Node head = addLists(list1.head, list2.head, 0);
	LinkedList addedList = new LinkedList();
	addedList.add(head);
	System.out.println(addedList);
    }

    private static Node addLists(Node n1, Node n2, int carry) {
	if (n1 == null && n2 == null && carry == 0)
	    return null;
	Node result = new Node(0);
	int value = carry;
	if (n1 != null)
	    value += n1.data;
	if (n2 != null)
	    value += n2.data;
	result.data = (value % 10);// second digit
	// recurse
	if (n1 != null || n2 != null) {
	    Node more = addLists(n1 != null ? n1.next : null, n2 != null ? n2.next : null, value >= 10 ? 1 : 0);
	    result.next = (more);
	}
	return result;
    }

    public static void sumListItr(LinkedList l1, LinkedList l2) {
	Node n1 = l1.head;
	Node n2 = l2.head;
	LinkedList sum = new LinkedList();
	int carry = 0;
	while (n1 != null && n2 != null) {
	    int value = carry + n1.data + n2.data;
	    sum.add(value % 10);
	    carry = value >= 10 ? 1 : 0;
	    n1 = n1.next;
	    n2 = n2.next;
	}
	if (n1 != null) {
	    while (n1 != null) {
		int value = n1.data + carry;
		sum.add(value % 10);
		carry = value >= 10 ? 1 : 0;
		n1 = n1.next;
	    }
	    if (carry == 1) {
		sum.add(carry);
		carry = 0;
	    }
	}
	if (n2 != null) {
	    while (n2 != null) {
		int value = n2.data + carry;
		sum.add(value % 10);
		carry = value >= 10 ? 1 : 0;
		n2 = n2.next;
	    }
	    if (carry == 1) {
		sum.add(carry);
		carry = 0;
	    }
	}
	System.out.println(sum);
    }

    /**
     * Implement a function to check if a linked list is palindrome
     * 
     * @param list
     */
    public static void palindromeWithReverse(LinkedList list) {
	LinkedList reversedList = new LinkedList();
	Node runner = list.head;
	Node reversedHead = null;
	while (runner != null) {
	    Node node = new Node(runner.data);
	    node.next = reversedHead;
	    reversedHead = node;
	    runner = runner.next;
	}
	reversedList.add(reversedHead);
	System.out.println(reversedList);
	// check the two list
	Node n1 = list.head;
	Node n2 = reversedHead;
	boolean isPalindrome = true;
	while (n1 != null && n2 != null) {
	    if (n1.data != n2.data) {
		isPalindrome = false;
		break;
	    }
	    n1 = n1.next;
	    n2 = n2.next;
	}
	if (isPalindrome) {
	    System.out.println("palindrome");
	} else
	    System.out.println("Not Palindrome");
    }

    public static void palindromeWithItr(LinkedList list) {
	Node slow = list.head;
	Node fast = list.head;
	Stack<Integer> stack = new Stack<>();
	while (fast != null && fast.next != null) {
	    stack.push(slow.data);
	    slow = slow.next;
	    fast = fast.next.next;
	}
	// if there are odd number of elements
	if (fast != null)
	    slow = slow.next;// skip the middle element
	boolean palindrome = true;
	while (slow != null) {
	    if (slow.data != stack.pop()) {
		palindrome = false;
		break;
	    }
	    slow = slow.next;

	}
	if (palindrome) {
	    System.out.println("palindrome");
	} else
	    System.out.println("Not Palindrome");
    }

    /**
     * Given 2 singly list lists, determine whether the two lists intersect. Return
     * the intersecting node.<br>
     * Time <b>O(A+b)</b> where A and B are the lengths of the lists. <br>
     * Space <b>O(1)</b>
     * 
     * @param list1
     * @param list2
     */
    public static void findIntersection(LinkedList list1, LinkedList list2) {
	TailnSizeResult result1 = geTailnSizeResult(list1);
	TailnSizeResult result2 = geTailnSizeResult(list2);
	boolean intersectionPresent = true;
	if (result1.tail != result2.tail)
	    intersectionPresent = false;
	if (intersectionPresent) {
	    Node shortHead = result1.size < result2.size ? list1.head : list2.head;
	    Node longHead = result1.size < result2.size ? list2.head : list1.head;
	    int diff = Math.abs(result1.size - result2.size);
	    // advance the long head to the diff position
	    longHead = getKthElem(longHead, diff);
	    while (longHead != shortHead) {
		shortHead = shortHead.next;
		longHead = longHead.next;
	    }

	    System.out.println("INtersection point =>" + shortHead.data);
	} else {
	    System.out.println("No Intersection point");
	}

    }

    private static TailnSizeResult geTailnSizeResult(LinkedList list) {
	int size = 0;
	Node tail = list.head;
	while (tail != null) {
	    tail = tail.next;
	    size++;
	}
	return new TailnSizeResult(tail, size);
    }

    private static Node getKthElem(Node head, int k) {
	int count = 0;
	Node current = head;
	while (current != null && count < k) {
	    count++;
	    current = current.next;
	}
	return current;
    }

    /**
     * This class is used to store the tail node and size of a linked list
     * 
     * @author Kazi
     *
     */
    private static class TailnSizeResult {
	public Node tail;
	public int size;

	public TailnSizeResult(Node tail, int size) {
	    super();
	    this.tail = tail;
	    this.size = size;
	}

    }

    /**
     * GIve a circular linked list, implement an algorithm that returns the node at
     * the beginning of the loop <br>
     * DEFINITION<BR>
     * Circular linked list: A corrupt linked list in which a node's next pointer
     * pointer to an earlier node, so to make a loop in the linked list<br>
     * Example:<br>
     * Input : A -> B -> C -> D -> E -> F -> G -> H -> I -> J -> K -> D <br>
     * Output : D
     * 
     * @param list
     */
    public static void loopDetection(LinkedList list) {
	// step1 find the intersection
	Node fast = list.head;
	Node slow = list.head;
	/* Find meeting point. This will be LOOP_SIZE - k steps into the linked list. */
	while (fast != null && fast.next != null) {
	    slow = slow.next;
	    fast = fast.next.next;
	    if (slow == fast)
		break;
	}
	if (fast == null || fast.next == null)
	    System.out.println("No intersection point");
	/*
	 * Move slow to Head. Keep fast at Meeting Point. Each are k steps from the Loop
	 * Start. If they move at the same pace, they must meet at Loop Start.
	 */
	else {
	    slow = list.head;
	    while (slow != fast) {
		slow = slow.next;
		fast = fast.next;
	    }
	    System.out.println("Intersection point:  " + fast.data);
	}
    }

    public static void main(String[] args) {

	LinkedList linkedList = new LinkedList();
	// for (int i = 0; i < 10; i++) {
	// linkedList.add(i);
	// }
	// linkedList.add(2);
	// linkedList.add(3);
	// linkedList.add(4);
	// linkedList.add(9);
	// linkedList.add(2);
	// linkedList.add(12);
	// linkedList.add(11);
	// linkedList.add(10);
	// linkedList.add(9);
	// linkedList.add(8);
	// linkedList.add(7);
	// linkedList.add(6);
	// System.out.println(linkedList);
	// linkedList.deleteNode(linkedList.head);
	// removeDups(linkedList);
	// removeDupsNoBuffer(linkedList);
	// findKthLastElementItr(linkedList, 3);
	// partitionList(linkedList, 9);
	// LinkedList l1 = new LinkedList();
	// l1.add(7);
	// l1.add(1);
	// l1.add(6);
	// LinkedList l2 = new LinkedList();
	// l2.add(5);
	// l2.add(9);
	// l2.add(2);
	// sumList(l1, l2);
	// sumListItr(l1, l2);
	// linkedList.add(6);
	// linkedList.add(2);
	// linkedList.add(3);
	// linkedList.add(6);
	// linkedList.add(3);
	// linkedList.add(2);
	// linkedList.add(6);
	// linkedList.add(2);
	// palindromeWithReverse(linkedList);
	// palindromeWithItr(linkedList);
	LinkedList loopedList = createLoopedList(25);
	// System.out.println(loopedList);
	loopDetection(loopedList);
    }

    private static LinkedList createLoopedList(int size) {
	LinkedList list = new LinkedList();
	Node loopNode = null;
	Node node = null;
	for (int i = 1; i <= size; i++) {
	    node = new Node(i);
	    if (i == size / 2)
		loopNode = node;
	    list.add(node);
	}
	node.next = loopNode;

	return list;
    }

    static class LinkedList {

	Node head;

	// public LinkedList(int data) {
	// Node node = new Node(data);
	// this.head = node;
	// }

	public void add(int data) {
	    Node end = new Node(data);
	    Node n = head;
	    if (n != null) {
		while (n.next != null) {
		    n = n.next;
		}
		n.next = end;
	    } else {
		head = end;
	    }
	}

	public void add(Node node) {
	    if (head == null)
		head = node;
	    else {
		Node n = head;
		while (n.next != null)
		    n = n.next;
		n.next = node;
	    }
	}

	public void delete(int data) {
	    Node n = head;
	    if (data == n.data) {
		head = head.next;
		return;
	    }
	    while (n.next != null) {
		if (n.next.data == data) {
		    n.next = n.next.next;
		    return;
		}
		n = n.next;
	    }
	}

	public void deleteNode(Node n) {
	    if (n == head) {
		head = head.next;
		return;
	    }
	    if (n != null) {
		if (n.next != null) {
		    n.data = n.next.data;
		    n.next = n.next.next;
		} else
		    n = null;
	    }
	}

	static class Node {
	    Node next = null;
	    int data;

	    Node(int data) {
		this.data = data;
	    }

	}

	@Override
	public String toString() {
	    String list = null;
	    StringBuilder builder = new StringBuilder();
	    Node pointer = head;
	    if (pointer != null) {
		builder.append(pointer.data);
		while (pointer.next != null) {
		    builder.append(" -> ");
		    pointer = pointer.next;
		    builder.append(pointer.data);
		}
	    }
	    list = builder.toString();
	    return list;

	}
    }

}
