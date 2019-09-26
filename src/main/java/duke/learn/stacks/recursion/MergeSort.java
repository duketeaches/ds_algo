/**
 * 
 */
package duke.learn.stacks.recursion;

/**
 * @author Kazi
 *
 */
public class MergeSort {

    private static int[] array = null;

    /**
     * Time Complexity -<b> O(N * logN)</b><br>
     * space complexity is <b>O(2N)</b> - It requires an additional array in memory
     * equal to the size of the original array<br>
     * Where N is the number of elements to be sorted.
     */
    public static void sort(int[] arr) {
	array = arr;
	int[] workspace = new int[arr.length];
	mergeSort(workspace, 0, arr.length - 1);
    }

    private static void printArray() {
	System.out.println();
	for (int i = 0; i < array.length; i++) {
	    System.out.print(array[i] + "  ");
	}
	System.out.println();
    }

    private static void mergeSort(int[] workspace, int lowerbound, int upperbound) {
	if (lowerbound == upperbound) {
	    return;
	}
	int mid = (upperbound + lowerbound) / 2; // find the middle point
	mergeSort(workspace, lowerbound, mid); // sort the lower half of the array
	mergeSort(workspace, mid + 1, upperbound); // sort the upper half of the array

	// merge the arrays back
	merge(workspace, lowerbound, mid + 1, upperbound);
    }

    /**
     * 
     * @param workspace
     * @param lowPtr
     *                       - Position of the first half array
     * @param highPtr
     *                       - Position of the 2nd half of the array
     * @param upperBound
     *                       - max position of the array
     */
    private static void merge(int[] workspace, int lowPtr, int highPtr, int upperBound) {
	int j = 0;
	int lowerbound = lowPtr;
	int mid = highPtr - 1;
	int n = upperBound - lowerbound + 1;// number of elements
	// merge the two halfs untill one of them exhausts
	while (lowPtr <= mid && highPtr <= upperBound) {
	    if (array[lowPtr] < array[highPtr])
		workspace[j++] = array[lowPtr++];
	    else
		workspace[j++] = array[highPtr++];

	}
	// merge the remaining lower half if any
	while (lowPtr <= mid)
	    workspace[j++] = array[lowPtr++];
	// merge the remaining upper half if any
	while (highPtr <= upperBound)
	    workspace[j++] = array[highPtr++];

	for (j = 0; j < n; j++)
	    array[lowerbound + j] = workspace[j];
    }

    /**
     * <b>Practice merge</b> Merge 2 sorted array into 3rd array in sorted order
     * 
     * @param arrA
     * @param arrB
     * @return
     */
    public static int[] merge(int[] arrA, int[] arrB) {
	int aSize = arrA.length;
	int bSize = arrB.length;
	int[] arrC = new int[aSize + bSize];
	int aDex = 0, bDex = 0, cDex = 0;
	// merging the two arrays till one of them is exhausted
	while (aDex < aSize && bDex < bSize)
	    if (arrA[aDex] < arrB[bDex])
		arrC[cDex++] = arrA[aDex++];
	    else
		arrC[cDex++] = arrB[bDex++];

	// merge the remaining elements from ArrA if any
	while (aDex < aSize)
	    arrC[cDex++] = arrA[aDex++];

	// merge the remaining elements from arrB id any
	while (bDex < bSize)
	    arrC[cDex++] = arrB[bDex++];
	return arrC;
    }

    public static void main(String[] args) {
	// int[] a = new int[] { 2, 3, 4 };
	// int[] b = new int[] { 1 };
	// int[] sorted = merge(a, b);
	// System.out.println();
	// for (int i = 0; i < sorted.length; i++) {
	// System.out.print(sorted[i] + " ");
	// }
	int arr[] = new int[] { 10, 8, 9, 7, 5, 6, 4, 1, 3, 2 };
	sort(arr);
	printArray();
    }
}
