/**
 * 
 */
package duke.learn.linkedlist;

/**
 * @author Kazi
 *
 */
public class LinkedList<T> {

    private Link<T> first;

    public LinkedList() {
	this.first = null;
    }

    public void insertFirst(T data) {
	Link<T> link = new Link<>(data);
	link.setNext(first);
	first = link;
    }

    public Link<T> deleteFirst() {
	Link<T> temp = first;
	first = first.getNext();
	return temp;
    }

    public Link<T> find(T key) {
	Link<T> current = first;
	while (!current.getData().equals(key)) {
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
	while (!current.getData().equals(key)) {
	    if (current.next == null) {
		return null;
	    } else {
		previous = current;
		current = current.next;
	    }
	}
	// key is found
	if (current.equals(first)) {
	    first = first.getNext();
	} else {
	    previous.setNext(current.getNext());
	}
	return current;
    }

    public void printList() {
	System.out.println("First - > Last");
	Link<T> current = first;
	while (current != null) {
	    current.printLink();
	    current = current.getNext();
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

	public T getData() {
	    return data;
	}

	@SuppressWarnings("unused")
	public void setData(T data) {
	    this.data = data;
	}

	public Link<T> getNext() {
	    return next;
	}

	public void setNext(Link<T> next) {
	    this.next = next;
	}

	public void printLink() {
	    System.out.println("{" + data.toString() + "}");
	}
    }

    public static void main(String[] args) {
	LinkedList<Integer> list = new LinkedList<>();
	list.insertFirst(1);
	list.insertFirst(2);
	list.insertFirst(3);
	list.insertFirst(4);
	list.insertFirst(5);
	list.insertFirst(6);
	list.insertFirst(7);
	list.insertFirst(8);
	list.insertFirst(9);
	list.insertFirst(10);
	list.printList();
	list.delete(6);
	list.printList();

	list.find(3).printLink();
    }
}
