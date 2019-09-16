/**
 * 
 */
package duke.learn.util;

/**
 * @author Kazi
 *
 */
public class Util {

    public static void printArray(int[] array) {
	if (array != null) {
	    System.out.println();
	    for (int object : array) {
		System.out.print(object + " ");
	    }
	}
    }

    public static void printArray(Object[] array) {
	if (array != null) {
	    System.out.println();
	    for (Object object : array) {
		System.out.print(object + " ");
	    }
	}
    }

    public static void swap(int[] arr, int a, int b) {
	int temp = arr[b];
	arr[b] = arr[a];
	arr[a] = temp;
    }

}
