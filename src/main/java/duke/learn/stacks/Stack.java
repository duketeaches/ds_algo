package duke.learn.stacks;

/**
 * 
 * @author Kazi
 *
 */
public class Stack<T> {

    private final int size;

    private int top;

    private Object[] arr;

    public Stack(int size) {
	this.size = size;
	this.top = -1;
	arr = new Object[this.size];
    }

    public void push(T t) {
	arr[++top] = t;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
	T elem = (T) arr[top];
	arr[top--] = null;
	return elem;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
	return (T) arr[top];
    }

    public boolean isEmpty() {
	return top == -1;
    }

    public boolean isFull() {
	return top == size - 1;
    }

    @SuppressWarnings("unchecked")
    public void printStack() {
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
	Stack<Integer> stack = new Stack<>(10);
	stack.push(10);
	stack.push(3);
	stack.push(3);
	stack.push(2);
	stack.push(6);
	stack.printStack();
	System.out.println("popping : " + stack.pop());
	System.out.println("popping : " + stack.pop());
	System.out.println("popping : " + stack.pop());
	stack.printStack();
    }
}
