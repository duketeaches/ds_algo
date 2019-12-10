/**
 * 
 */
package duke.learn.algo.crackingthecodinginterview;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * @author Kazi
 *
 */
public class Chapter03StacksAndQueues {

    /**
     * How would you design a stack which, in addition to push and pop, has a
     * funtion min() which returns the minimum element? <code>push()</code>,
     * <code>pop()</code> and <code>min()</code> should all operate in <b>O(1)</b>
     * time
     */
    public static void stackWithMin() {
	StackWithMin stackWithMin = new StackWithMin();
	stackWithMin.push(5);
	stackWithMin.push(6);
	stackWithMin.push(7);
	// System.out.println(stackWithMin.min());
	stackWithMin.push(1);
	stackWithMin.push(3);
	stackWithMin.push(2);
	// System.out.println(stackWithMin.min());
	stackWithMin.push(9);
	stackWithMin.push(1);
	// System.out.println(stackWithMin.min());
	stackWithMin.pop();
	stackWithMin.pop();
	stackWithMin.pop();
	stackWithMin.pop();
	stackWithMin.pop();
	System.out.println(stackWithMin.min());
	System.out.println(stackWithMin);

    }

    public static void main(String[] args) {
	stackWithMin();
    }

    private static class StackWithMin {
	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();

	public void push(int i) {
	    if (minStack.isEmpty())
		minStack.push(i);
	    else {
		int min = minStack.peek();
		if (i <= min)
		    minStack.push(i);
	    }
	    stack.push(i);

	}

	public void pop() {
	    int popped = stack.pop();
	    if (popped == minStack.peek())
		minStack.pop();
	}

	public int min() {
	    return minStack.peek();
	}

	@Override
	public String toString() {
	    return stack.toString();
	}

    }

    private static class Queue<T> {

	private QueueNode<T> first;
	private QueueNode<T> last;

	public void add(T item) {
	    QueueNode<T> t = new QueueNode<>(item);
	    if (last != null)
		last.next = t;
	    last = t;
	    if (first == null)
		first = last;
	}

	public T remove() {
	    if (first == null)
		throw new NoSuchElementException();
	    T data = first.data;
	    first = first.next;
	    if (first == null)
		last = null;
	    return data;
	}

	public T peek() {
	    if (first == null)
		throw new NoSuchElementException();
	    return first.data;

	}

	public boolean isEmpty() {
	    return first == null;
	}

	private static class QueueNode<T> {
	    private T data;
	    private QueueNode<T> next;

	    public QueueNode(T data) {
		super();
		this.data = data;
	    }
	}
    }

}
