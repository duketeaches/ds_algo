/**
 * 
 */
package duke.learn.linkedlist;

/**
 * @author Kazi
 *
 */
public class DoubleEndedLinkedList<T> {

    private Link<T> first;
    private Link<T> last;

    public DoubleEndedLinkedList() {
	this.first = null;
	this.last = null;
    }

    public boolean isEmpty() {
	return first == null;
    }

    public void insertFirst(T data) {
	Link<T> newLink = new Link<>(data);
	if (isEmpty())// if empty list,
	    last = newLink;// newLink <-- last
	newLink.next = first;// newLink --> old first
	first = newLink;// first --> newLink
    }

    public void insertLast(T data) {// insert at end of list
	Link<T> newLink = new Link<T>(data);// make new link
	if (isEmpty())// if empty list,
	    first = newLink;// first --> newLink
	else
	    last.next = newLink;// old last --> newLink
	last = newLink;// newLink <-- last
    }

    public T deleteFirst() {
	T data = first.data;
	if (first.next == null) {
	    last = null;
	}
	first = first.next;
	return data;
    }

    public T deleteLast() {
	T data = last.data;
	Link<T> current = first;
	Link<T> previous = first;
	while (!current.data.equals(data)) {
	    previous = current;
	    if (current.next == null)
		return null;
	    current = current.next;
	}
	previous.next = null;
	last = previous;
	return data;
    }

    public Link<T> find(T data) {
	Link<T> current = first;
	while (!current.data.equals(data)) {
	    if (current.next == null)
		return null;
	    current = current.next;
	}
	return current;

    }

    public void delete(T data) {
	Link<T> current = first;
	Link<T> prev = first;
	while (!current.data.equals(data)) {
	    if (current.next == null)
		return;
	    prev = current;
	    current = current.next;
	}
	if (current == first) {
	    first = first.next;
	}
	if (current == last) {
	    prev.next = null;
	    last = prev;
	}
	prev.next = current.next;
	current = null;
    }

    public Link<T> getFirst() {
	return first;
    }

    public void setFirst(Link<T> first) {
	this.first = first;
    }

    public Link<T> getLast() {
	return last;
    }

    public void setLast(Link<T> last) {
	this.last = last;
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
	    this.data = data;
	}

	public void printLink() {
	    System.out.println("{" + data.toString() + "}");
	}
    }

    public static void main(String[] args) {

	DoubleEndedLinkedList<Integer> linkedList = new DoubleEndedLinkedList<>();
	linkedList.insertFirst(1);
	linkedList.insertFirst(2);
	linkedList.insertFirst(3);
	linkedList.insertFirst(4);
	linkedList.insertFirst(5);
	linkedList.insertFirst(6);
	linkedList.insertFirst(7);
	linkedList.insertFirst(8);
	linkedList.insertFirst(9);
	linkedList.insertFirst(10);

	linkedList.insertLast(15);
	linkedList.insertLast(16);

	System.out.println("First : " + linkedList.first.data);
	System.out.println("Last : " + linkedList.last.data);

	linkedList.printList();
	linkedList.deleteFirst();
	linkedList.deleteFirst();
	linkedList.printList();
	linkedList.deleteLast();
	linkedList.deleteLast();
	linkedList.printList();

	linkedList.find(2).printLink();

	linkedList.delete(5);
	linkedList.printList();
	linkedList.delete(1);
	linkedList.printList();
	linkedList.delete(8);
	linkedList.printList();
	System.out.println(linkedList.first.data);
	System.out.println(linkedList.last.data);
    }
}
