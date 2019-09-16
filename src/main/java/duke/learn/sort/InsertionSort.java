package duke.learn.sort;

import duke.learn.util.Util;

/**
 * 
 * @author Kazi
 *
 */
public class InsertionSort {

    /**
     * Tutorials :<br>
     * <a href= "https://www.youtube.com/watch?v=lCzQvQr8Utw" >Khan academy
     * video</a> <br>
     * <a href="https://www.youtube.com/watch?v=Kg4bqzAqRBM" >MIT video</a>
     * 
     * @param input
     * @return
     */
    public static int[] sort(int[] input) {
	int len = input.length;
	for (int i = 1; i < len; i++) {
	    int min = input[i];
	    int j = i - 1;
	    while (j >= 0) {
		if (min < input[j]) {
		    input[j + 1] = input[j]; // shift the number in slot j right to slot j+1
		    input[j] = min; // shift the value left into slot j
		    j--;
		} else
		    break;
	    }
	}
	return input;
    }

    public static int[] sortDesc(int[] input) {
	int len = input.length;
	for (int i = 1; i < len; i++) {
	    int max = input[i];
	    int j = i - 1;
	    while (j >= 0) {
		if (max > input[j]) {
		    input[j + 1] = input[j]; // shift the number in slot j right to slot j+1
		    input[j] = max; // shift the value left into slot j
		    j--;
		} else
		    break;
	    }
	}
	return input;
    }

    public static void main(String[] args) {

	int[] arr = { 77, 99, 44, 55, 22, 88, 11, 0, 66, 33 };
	// swap(arr, 1, 2);
	sort(arr);
	Util.printArray(arr);
	sortDesc(arr);
	Util.printArray(arr);
    }
}
