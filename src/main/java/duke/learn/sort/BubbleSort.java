/**
 * 
 */
package duke.learn.sort;

import duke.learn.util.Util;

/**
 * @author Kazi
 *
 */
public class BubbleSort {

    public BubbleSort() {
    }

    /**
     * 
     * @param input
     * @return
     */
    public static int[] sort(int[] input) {
	int len = input.length;
	// int out[] = new int[len];
	for (int i = 0; i < len; i++) // loop forward
	    for (int j = len - 1; j > i; j--) // loop backwards
		if (input[j] < input[j - 1])
		    Util.swap(input, j, j - 1);
	return input;
    }

    public static int[] sortDesc(int[] input) {
	int len = input.length;
	// int out[] = new int[len];
	for (int i = 0; i < len; i++) // loop forward
	    for (int j = len - 1; j > i; j--) // loop backwards
		if (input[j] > input[j - 1])
		    Util.swap(input, j, j - 1);
	return input;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	int[] arr = { 77, 99, 44, 55, 22, 88, 11, 0, 66, 33 };
	// swap(arr, 1, 2);
	sort(arr);
	Util.printArray(arr);
	sortDesc(arr);
	Util.printArray(arr);

    }
}
