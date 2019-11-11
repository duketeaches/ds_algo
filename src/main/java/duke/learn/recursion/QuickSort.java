/**
 * 
 */
package duke.learn.recursion;

import java.util.Random;

/**
 * @author Kazi
 *
 */
public class QuickSort {

    private static int[] array;

    /**
     * Time Complexity : average:<b> O(N*logN) </b><br>
     * <code> where N is the number of elements to be sorted </code><br>
     * <br>
     * This is more memory efficient than Merge Sort since it does not create any
     * duplicate array during the sorting process.
     * 
     * @param unsortedArray
     * @return sorted array
     */
    public static int[] sort(int[] unsortedArray) {
	array = unsortedArray;
	quickSort(0, unsortedArray.length - 1);
	return array;
    }

    private static void quickSort(int left, int right) {
	if (right - left <= 0) // size <=1 means already sorted
	    return;
	int pivot = array[right]; // right most element as pivot
	int partitionIndex = partition(left, right, pivot);
	// during partitioning, we have already found the final position of the pivot,
	// so partition index is getting excluded in the subsequent calls
	quickSort(left, partitionIndex - 1); // sort the left side
	quickSort(partitionIndex + 1, right);// sort the right side

    }

    private static int partition(int left, int right, int pivot) {
	int leftPtr = left - 1;
	int rightPtr = right; // We are not moving it to right most because pivot is the last element
	while (true) {

	    // get the value bigger than the pivot in the left
	    while (leftPtr < right && array[++leftPtr] < pivot)
		;
	    // get the value lower than the pivot in the right
	    while (rightPtr > left && array[--rightPtr] > pivot)
		;
	    if (leftPtr >= rightPtr)
		break;
	    else
		swap(leftPtr, rightPtr);
	}
	swap(leftPtr, right); // swapping the pivot to its position
	return leftPtr;
    }

    private static void swap(int firstIndex, int secondIndex) {
	int temp = array[firstIndex];
	array[firstIndex] = array[secondIndex];
	array[secondIndex] = temp;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	int N = 10000000;
	Random random = new Random();
	// 169, 93, 111, 171, 165, 12, 85, 3, 46, 164, 114, 15, 35, 162, 72, 198
	int[] arr = new int[N];
	// seeding the array
	for (int i = 0; i < N; i++) {
	    arr[i] = random.nextInt(N);
	}
	// System.out.println();
	// for (int i = 0; i < arr.length; i++) {
	// System.out.print(arr[i] + ", ");
	// }
	long start = System.nanoTime();
	sort(arr);
	long end = System.nanoTime();
	System.out.println();
	// for (int i = 0; i < arr.length; i++) {
	// System.out.print(arr[i] + ", ");
	// }
	System.out.println("Sorted " + N + " numbers in " + ((end - start) / 1000000) + " milli");
    }

}
