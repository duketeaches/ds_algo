/**
 * 
 */
package duke.learn.recursion;

/**
 * Partition is the most important part of quick sort. So I have dedicated this
 * class to partition concept
 * 
 * @author Kazi
 *
 */
public class Partition {

    public static int testPartition(int[] array, int left, int right, int pivot) {
	int leftPtr = left - 1;
	int rightPtr = right + 1;
	while (true) {
	    // find the bigger item in left
	    while (leftPtr < right && array[++leftPtr] < pivot) {
		;// NOP - No Operation
	    }
	    // find the smaller item in right
	    while (rightPtr > left && array[--rightPtr] > pivot)
		; // NOP
	    if (leftPtr >= rightPtr) // if pointers cross, then partition is done
		break;
	    else // not crossed, so swap elements
		swap(array, leftPtr, rightPtr);
	}
	return leftPtr;
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
	int temp = array[firstIndex];
	array[firstIndex] = array[secondIndex];
	array[secondIndex] = temp;
    }

    public static void main(String[] args) {
	int[] arr = new int[] { 169, 93, 111, 171, 165, 12, 85, 3, 46, 164, 114, 15, 35, 162, 72, 198 };
	System.out.println("array: ");
	System.out.println();

	for (int i = 0; i < 16; i++) {
	    System.out.print(arr[i] + "   ");
	}
	System.out.println();
	int pivot = 100;
	int pivotIndex = testPartition(arr, 0, 15, pivot);
	System.out.println("Pivot Index = " + pivotIndex);
	for (int i = 0; i < arr.length; i++) {
	    System.out.print(arr[i] + "   ");
	}
    }

}
