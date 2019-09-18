/**
 * 
 */
package duke.learn.search;

/**
 * @author Kazi
 *
 */
public class BinarySearch {

    /**
     * Return the index position of the key
     * 
     * @param arr
     * @param key
     * @return
     */
    public static int search(int[] arr, int key) {
	int lowIndex = 0;
	int highIndex = arr.length - 1;
	int currIndex;
	while (true) {
	    currIndex = (lowIndex + highIndex) / 2; // Middle index
	    if (arr[currIndex] == key) { // found the key
		return currIndex;
	    } else if (lowIndex > highIndex) { // cant find the key
		return -1;
	    } else { // divide and rule
		if (arr[currIndex] < key) {
		    lowIndex = currIndex + 1;
		} else {
		    highIndex = currIndex - 1;
		}
	    }
	}
    }

    public static int searchRecursive(int[] arr, int key) {
	return recursiceSearch(arr, key, 0, arr.length - 1);
    }

    private static int recursiceSearch(int[] arr, int key, int lowIndex, int highIndex) {
	int currIndex = (lowIndex + highIndex) / 2;
	if (arr[currIndex] == key) {
	    return currIndex;
	} else if (lowIndex > highIndex) {
	    return -1;
	} else {
	    if (arr[currIndex] < key) {
		return recursiceSearch(arr, key, currIndex + 1, highIndex);
	    } else {
		return recursiceSearch(arr, key, lowIndex, currIndex - 1);
	    }
	}
    }

    public static void main(String[] args) {
	int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
	// System.err.println(search(arr, 15));
	System.err.println(searchRecursive(arr, 12));
    }

}
