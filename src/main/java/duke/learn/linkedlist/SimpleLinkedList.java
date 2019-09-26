/**
 * 
 */
package duke.learn.linkedlist;

/**
 * @author Kazi
 *
 */
public class SimpleLinkedList {

    private SimpleLink first;

    public SimpleLinkedList() {
	first = null;
    }

    public void insertFirst(int data) {
	SimpleLink link = new SimpleLink(data);
	link.setNext(first);
	first = link;
    }

    public SimpleLink deleteFirst() {
	SimpleLink temp = first;
	first = first.getNext();
	return temp;
    }

    public void printList() {
	System.out.println("First - > Last");
	SimpleLink current = first;
	while (current != null) {
	    current.displayLink();
	    current = current.next;
	}
	System.out.println("-------");
    }

    public boolean isEmpty() {
	return first == null;
    }

    public class SimpleLink {
	private int data;
	private SimpleLink next;

	/**
	 * 
	 * @param data
	 */
	public SimpleLink(int data) {
	    this.data = data;
	}

	public int getData() {
	    return data;
	}

	public void setData(int data) {
	    this.data = data;
	}

	public SimpleLink getNext() {
	    return next;
	}

	public void setNext(SimpleLink simpleLink) {
	    this.next = simpleLink;
	}

	public void displayLink() {
	    System.out.println("{" + data + "}");
	}

    }

    public static void main(String[] args) {
	SimpleLinkedList list = new SimpleLinkedList();
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
	list.deleteFirst();
	list.deleteFirst();
	list.deleteFirst();
	list.printList();

    }
}
