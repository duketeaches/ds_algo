/**
 * 
 */
package duke.learn.algo.GfG;

import java.util.HashSet;

/**
 * @author Kazi
 *
 */
public class C01Array {

    /**
     * Given an array A[] and a number x, check for pair in A[] with sum as x <br>
     * <b>O(n)</b>
     * 
     * @param a
     * @param sum
     */
    public static void printPairs(int[] a, int sum) {
	HashSet<Integer> set = new HashSet<>();

	for (int i = 0; i < a.length; i++) {
	    int temp = sum - a[i];
	    if (set.contains(temp))
		System.out.println("Pair with given sum (" + a[i] + ", " + temp + ") = " + sum);
	    set.add(a[i]);
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	printPairs(new int[] { -8, 1, 4, 6, 10, 45, 6, 12 }, 16);

    }

}
