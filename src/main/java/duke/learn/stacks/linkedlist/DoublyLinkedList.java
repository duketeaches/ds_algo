/**
 * 
 */
package duke.learn.stacks.linkedlist;

import java.util.Iterator;

/**
 * @author Kazi
 *
 */
public class DoublyLinkedList<T> implements Iterable<T> {

    private Link<T> first;
    private Link<T> last;

    public DoublyLinkedList() {
	first = null;
	last = null;
    }

    public boolean isEmpty() {
	return first == null;
    }

    public void insertFirst(T data) {
	// insert at front of list
	Link<T> newlink = new Link<T>(data); // make new link
	if (isEmpty()) // if empty list,
	    last = newlink; // newLink <-- last
	else
	    first.prev = newlink; // newLink <-- old first
	newlink.next = first;// newLink --> old first
	first = newlink; // first --> newLink

    }

    public void insertLast(T data) {
	Link<T> newlink = new Link<T>(data);
	if (isEmpty())
	    first = newlink;
	else {
	    last.next = newlink;
	    newlink.prev = last;
	}
	last = newlink;
    }

    /**
     * Insert "newData" after "data"
     * 
     * @param data
     * @param newData
     * @return true if inserted, false if "data" is not found
     */
    public boolean insertAfter(T data, T newData) {
	Link<T> curr = first;
	while (!curr.data.equals(data)) {
	    curr = curr.next;
	    if (curr == null) {
		return false;
	    }
	}
	Link<T> newlink = new Link<T>(newData);
	if (curr == last) {
	    newlink.next = null;
	    last = newlink;
	} else {
	    newlink.next = curr.next;
	    curr.next.prev = newlink;
	}
	newlink.prev = curr;
	curr.next = newlink;
	return true;
    }

    public Link<T> deleteFirst() {
	Link<T> temp = first;
	if (first.next == null) {
	    last = null;
	} else {
	    first.next.prev = null;
	}
	first = first.next;
	return temp;
    }

    public Link<T> deleteLast() {
	Link<T> temp = last;
	if (first.next == null) {
	    first = null;
	} else {
	    last.prev.next = null;
	}
	last = last.prev;
	return temp;
    }

    public Link<T> delete(T data) {
	Link<T> curr = first;
	while (!curr.data.equals(data)) {
	    curr = curr.next;
	    if (curr == null) {
		return null;
	    }
	}
	if (curr == first) {
	    first = null;
	} else {
	    curr.prev.next = curr.next;
	}
	if (curr == last) {
	    last = curr.prev;
	} else {
	    curr.next.prev = curr.prev;
	}
	return curr;
    }

    public void displayForward() {
	System.out.println("---------");
	Link<T> curr = first;
	while (curr != null) {
	    curr.printLink();
	    curr = curr.next;
	}
	System.out.println("---------");
    }

    public void displayBackward() {
	System.out.println("---------");
	Link<T> curr = last;
	while (curr != null) {
	    curr.printLink();
	    curr = curr.prev;
	}
	System.out.println("---------");
    }

    @Override
    public Itr<T> iterator() {
	return new Itr<T>(this);
    }

    private static class Link<T> {
	private T data;
	private Link<T> next;
	private Link<T> prev;

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

    public static class Itr<T> implements Iterator<T> {

	private Link<T> current;
	private Link<T> previous;
	private DoublyLinkedList<T> list;

	public Itr(DoublyLinkedList<T> list) {
	    this.list = list;
	    reset();
	}

	private void reset() {
	    current = null;
	    previous = null;
	}

	@Override
	public boolean hasNext() {
	    if (current == null && list.first != null) {
		return true;
	    } else if (current == null) {
		return false;
	    }
	    return current.next != null;
	}

	@Override
	public T next() {
	    if (current == null && list.first != null) {
		current = list.first;
		return current.data;
	    }
	    previous = current;
	    current = current.next;
	    return current.data;
	}

	public boolean hasPrevious() {
	    return previous != null;
	}

	public T previous() {
	    if (previous != null)
		return previous.data;
	    return null;
	}

	private boolean atEnd() {
	    return current.next == null;
	}

	@Override
	public void remove() {
	    if (previous == null) {
		list.first = current.next;
		reset();
	    } else {
		previous.next = current.next;
		if (atEnd()) {
		    reset();
		} else {
		    current = current.next;
		}
	    }
	}

    }

    public static void main(String[] args) {
	DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
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
	linkedList.displayForward();
	linkedList.displayBackward();
	linkedList.insertAfter(6, 12);
	linkedList.displayForward();
	linkedList.delete(16);
	linkedList.displayForward();

	Itr<Integer> iterator = linkedList.iterator();
	while (iterator.hasNext()) {
	    Integer integer = (Integer) iterator.next();
	    System.err.println(integer);
	    if (integer >= 10) {
		iterator.remove();
	    }
	}
	linkedList.displayForward();
    }
}
