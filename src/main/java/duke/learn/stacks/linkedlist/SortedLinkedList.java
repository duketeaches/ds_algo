/**
 * 
 */
package duke.learn.stacks.linkedlist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Kazi
 *
 */
public class SortedLinkedList<T extends Comparable<T>> implements Iterable<T> {

    private Link<T> first;

    public SortedLinkedList() {
	this.first = null;
    }

    public SortedLinkedList(List<T> arr) {
	if (arr != null) {
	    arr.forEach(l -> insert(l));
	}
    }

    public void insert(T data) {
	Link<T> newLink = new Link<>(data);
	Link<T> curr = first;
	Link<T> prev = null;
	while (curr != null && data.compareTo(curr.data) > 0) {
	    prev = curr;
	    curr = curr.next;
	}
	if (prev == null)
	    first = newLink;
	else
	    prev.next = newLink;

	newLink.next = curr;
    }

    public Link<T> deleteFirst() {
	Link<T> temp = first;
	first = first.next;
	return temp;
    }

    public Link<T> find(T key) {
	Link<T> current = first;
	while (!current.data.equals(key)) {
	    if (current.next == null) {
		return null;
	    }
	    current = current.next;
	}
	return current;
    }

    public Link<T> delete(T key) {
	Link<T> current = first;
	Link<T> previous = first;
	while (!current.data.equals(key)) {
	    if (current.next == null) {
		return null;
	    } else {
		previous = current;
		current = current.next;
	    }
	}
	// key is found
	if (current.equals(first)) {
	    first = first.next;
	} else {
	    previous.next = current.next;
	}
	return current;
    }

    public void printList() {
	System.out.println("First - > Last");
	Link<T> current = first;
	while (current != null) {
	    current.printLink();
	    current = current.next;
	}
	System.out.println("-------");
    }

    private static class Link<T> {
	private T data;
	private Link<T> next;

	/**
	 * @param data
	 */
	public Link(T data) {
	    super();
	    this.data = data;
	}

	public void printLink() {
	    System.out.println("{" + data.toString() + "}");
	}
    }

    public static void main(String[] args) {
	// SortedLinkedList<Integer> list = new SortedLinkedList<>();
	// list.insert(5);
	// list.insert(1);
	// list.insert(6);
	// list.insert(2);
	// list.insert(10);
	// list.insert(7);
	// list.insert(8);
	// list.insert(3);
	// list.insert(4);
	// list.insert(9);
	//
	// list.printList();
	// list.delete(6);
	// list.printList();
	//
	// list.find(3).printLink();
	List<Integer> list = Arrays.asList(5, 4, 8, 1, 9, 12, 1, 3, 2);
	SortedLinkedList<Integer> sortedLinkedList = new SortedLinkedList<>(list);
	sortedLinkedList.printList();

    }

    @Override
    public Iterator<T> iterator() {
	// TODO Auto-generated method stub
	return null;
    }
}
