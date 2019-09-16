/**
 * 
 */
package duke.learn.stacks;

/**
 * @author Kazi
 *
 */
public class Queue<T> {

    private int size;
    private Object[] arr;
    private int front;
    private int rear;
    private int nItems;

    /**
     * 
     */
    public Queue(int size) {
	this.size = size;
	arr = new Object[size];
	front = 0;
	rear = -1;
	nItems = 0;
    }

    public void insert(T t) {
	if (rear == size - 1)
	    rear = -1;
	arr[++rear] = t;
	nItems++;
    }

    @SuppressWarnings("unchecked")
    public T remove() {
	T t = (T) arr[front];
	arr[front++] = null;
	if (front == size) {
	    front = 0;
	}
	nItems--;
	return t;
    }

    @SuppressWarnings("unchecked")
    public T peekFront() {
	return (T) arr[front];
    }

    public boolean isEmpty() {
	return nItems == 0;
    }

    public boolean isFull() {
	return nItems == size;
    }

    public int size() {
	return nItems;
    }

    @SuppressWarnings("unchecked")
    public void printQ() {
	for (int i = size - 1; i >= 0; i--) {
	    T elem = (T) arr[i];
	    if (elem == null) {
		System.out.println("|__|");
	    } else {
		System.out.println("|" + elem + "|");
	    }
	}
    }

    public static void main(String[] args) {
	Queue<Integer> queue = new Queue<>(10);
	queue.insert(1);
	queue.insert(2);
	queue.insert(3);
	queue.insert(4);
	queue.insert(5);
	queue.insert(6);
	queue.insert(7);
	queue.insert(8);
	queue.insert(9);
	queue.insert(10);
	queue.printQ();
	System.out.println("-----------------");
	queue.remove();
	queue.remove();
	queue.remove();
	queue.insert(11);
	queue.insert(12);
	queue.insert(13);
	queue.insert(14);
	queue.printQ();
    }
}
