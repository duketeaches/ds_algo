/**
 * 
 */
package duke.learn.algo.crackingthecodinginterview;

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
}
