/**
 * 
 */
package duke.learn.recursion;

/**
 * @author Kazi
 *
 */
public class RecursiceMethods {

    /**
     * Triangle numbers: 1,3,6,10,15,21,28....<br>
     * mathematical induction : <br>
     * <code>
     * tri(1) =1<br>
     * tri(n) = n+tri(n-1)
     * </code>
     * 
     * 
     * @param n
     * @return
     */
    public static int triangle(int n) {
	System.out.println("Entering n= " + n);
	if (n == 1) {
	    System.out.println("returning 1");
	    return 1;
	} else {
	    int temp = n + triangle(n - 1);
	    System.out.println("returning " + temp);
	    return temp;
	}
    }

    public static int factorial(int n) {
	System.out.println("Entering n= " + n);
	if (n == 0) {
	    System.out.println("Returning " + 1);
	    return 1;
	} else {
	    int temp = n * factorial(n - 1);
	    System.out.println("Returning " + temp);
	    return temp;
	}
    }

    public static void main(String[] args) {
	// System.out.println(triangle(7));
	System.out.println(factorial(9));
    }

}
