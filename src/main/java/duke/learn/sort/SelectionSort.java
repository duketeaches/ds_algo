/**
 * 
 */
package duke.learn.sort;

import duke.learn.util.Util;

/**
 * @author Kazi
 *
 */
public class SelectionSort {

    public static int[] sort(int[] input) {
	int i, j, min;
	int len = input.length;
	for (i = 0; i < len; i++) {
	    min = i;
	    for (j = i + 1; j < len; j++)
		if (input[j] < input[min])
		    min = j;
	    Util.swap(input, i, min);
	}
	return input;
    }

    public static int[] sortDesc(int[] input) {
	int i, j, max;
	int len = input.length;
	for (i = 0; i < len; i++) {
	    max = i;
	    for (j = i + 1; j < len; j++)
		if (input[j] > input[max])
		    max = j;
	    Util.swap(input, i, max);
	}
	return input;
    }

    public static void main(String[] args) {
	int[] arr = { 77, 99, 44, 55, 22, 88, 11, 0, 66, 33 };
	Util.printArray(arr);
	// swap(arr, 1, 2);
	sort(arr);
	Util.printArray(arr);
	sortDesc(arr);
	Util.printArray(arr);
    }
}
