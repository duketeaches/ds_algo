package duke.learn.algo.crackingthecodinginterview;

/**
 * 
 * @author Kazi
 *
 */
public class Chapter02ArraysNString {

    /**
     * <b>1. </b> Implement an algorithm to determine if a string has all unique
     * characters. What if you cannot use additional data structure?<br>
     * Time :<b> O(N) </b>- we can also argue <b>O(1) </b>because the for loop will
     * never exceed 128 iterations <br>
     * Space : <b>O(1) </b>
     * 
     * @param input
     * @return
     */
    public static boolean isUnique(String input) {
	int[] allChars = new int[128];
	char[] inputChars = input.toCharArray();
	for (int i = 0; i < inputChars.length; i++) {
	    char c = inputChars[i];
	    if (allChars[c] > 0)
		return false;
	    allChars[c] = c;
	}
	return true;
    }

    /**
     * <b>2. </b>Given 2 Strings, write a method to decide if one is permutation of
     * another <br>
     * 
     * @param str1
     * @param str2
     * @return
     */
    public static boolean checkPermutation(String str1, String str2) {
	if (str1.length() != str2.length())
	    return false;
	int[] chars = new int[128];
	char[] sChars = str1.toCharArray();
	for (char c : sChars)
	    chars[c]++;
	sChars = str2.toCharArray();
	for (char c : sChars) {
	    chars[c]--;
	    if (chars[c] < 0)
		return false;
	}
	return true;
    }

    /**
     * <b>3. </b> Write a method to replace all spaces in a String with '%20'. You
     * may assume that the string has sufficient spaces at the end to hold the
     * additional characters, and that you are given the true length of the String.
     * 
     * @param url
     * @return
     */
    public static String urlify(String url) {
	int len = url.length();
	char[] chars = url.trim().toCharArray();
	char[] out = new char[len];
	for (int i = 0, j = 0; i < chars.length; i++) {
	    if (chars[i] == ' ') {
		out[j++] = '%';
		out[j++] = '2';
		out[j++] = '0';
	    } else
		out[j++] = chars[i];
	}
	return new String(out);
    }

    public static boolean oneEditAway(String first, String second) {
	if (first.length() == second.length())
	    return oneEditReplaceAway(first, second);
	else if (first.length() - second.length() == 1)
	    return oneEditInsert(second, first);
	else if (second.length() - first.length() == 1)
	    return oneEditInsert(first, second);
	return false;
    }

    private static boolean oneEditReplaceAway(String s1, String s2) {
	boolean foundDifference = false;
	for (int i = 0; i < s1.length(); i++) {
	    if (s1.charAt(i) != s2.charAt(i)) {
		if (foundDifference)
		    return false;
		foundDifference = true;
		;
	    }
	}
	return true;
    }

    /**
     * Check whether insert 1 char in s1 makes it equal to s2
     * 
     * @param s1
     * @param s2
     * @return
     */
    private static boolean oneEditInsert(String s1, String s2) {
	int i1 = 0, i2 = 0;
	while (i1 < s1.length() && i2 < s2.length()) {
	    if (s1.charAt(i1) != s2.charAt(i2)) {
		if (i1 != i2)
		    return false;
		i2++;
	    } else {
		i1++;
		i2++;
	    }
	}
	return true;
    }

    /**
     * Imlement a method to perform basic string using the counts of repeated
     * characters.<br>
     * For example, the string aabcccccaaa would become a2b1c5a3 <br>
     * If the compressed string is longer or equal to the input string then return
     * the original string
     * 
     * @param str
     * @return
     */
    public static String compressString(String str) {
	StringBuilder builder = new StringBuilder();
	int repeatCount = 0;
	for (int i = 0; i < str.length(); i++) {
	    repeatCount++;
	    if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
		builder.append(str.charAt(i));
		builder.append(repeatCount);
		repeatCount = 0;
	    }

	}
	String compressedString = builder.toString();
	if (compressedString.length() < str.length())
	    return compressedString;
	else
	    return str;

    }

    /**
     * Given an image represented by an NxN matrix, where each pixel in the image is
     * 4 byte, write a method to rotate the image by <b> 90<sup>o</sup></b>. <br>
     * Can you do it inplace?
     * 
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
	if (matrix.length != 0 && matrix.length == matrix[0].length) {
	    for (int i = 0; i < matrix.length; i++) {
		System.out.println();
		for (int j = 0; j < matrix.length; j++) {
		    System.out.print(matrix[i][j] + "   ");
		}
	    }
	    System.out.println();
	    int n = matrix.length;
	    for (int layer = 0; layer < n / 2; layer++) {
		int first = layer, last = n - 1 - layer;
		for (int i = first; i < last; i++) {
		    int offset = i - first;
		    int top = matrix[first][i];// save top
		    // top = left
		    matrix[first][i] = matrix[last - offset][first];
		    // left = bottom
		    matrix[last - offset][first] = matrix[last][last - offset];
		    // bottom = right
		    matrix[last][last - offset] = matrix[i][last];
		    // right = top
		    matrix[i][last] = top;
		}
	    }

	    for (int i = 0; i < matrix.length; i++) {
		System.out.println();
		for (int j = 0; j < matrix.length; j++) {
		    System.out.print(matrix[i][j] + "   ");
		}
	    }
	}
    }

    /**
     * Write an algorithm such that if an element in an MxN matrix is 0, it's entire
     * row and column are set to 0.
     * 
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {
	for (int i = 0; i < matrix.length; i++) {
	    System.out.println();
	    for (int j = 0; j < matrix.length; j++) {
		System.out.print(matrix[i][j] + "   ");
	    }
	}
	System.out.println();
	boolean[] row = new boolean[matrix.length];
	boolean[] column = new boolean[matrix[0].length];
	for (int i = 0; i < matrix.length; i++) {
	    for (int j = 0; j < matrix[0].length; j++) {
		if (matrix[i][j] == 0) {
		    row[i] = true;
		    column[j] = true;
		}
	    }
	}
	// Nullify the rows
	for (int i = 0; i < row.length; i++) {
	    if (row[i])
		nullifyRow(matrix, i);
	}
	// Nullify the columns
	for (int i = 0; i < column.length; i++) {
	    if (column[i])
		nullifyCollumn(matrix, i);
	}
	for (int i = 0; i < matrix.length; i++) {
	    System.out.println();
	    for (int j = 0; j < matrix.length; j++) {
		System.out.print(matrix[i][j] + "   ");
	    }
	}
	System.out.println();
    }

    private static void nullifyRow(int[][] matrix, int row) {
	for (int i = 0; i < matrix[0].length; i++) {
	    matrix[row][i] = 0;
	}
    }

    private static void nullifyCollumn(int[][] matrix, int col) {
	for (int i = 0; i < matrix.length; i++) {
	    matrix[i][col] = 0;
	}
    }

    /**
     * Assume you have a method <code>isSubstring</code> which checks if one word is
     * a substring of another.<br>
     * Given 2 String s1 and s2 write code to check if s2 is a rotation of s1 using
     * only one call to <code>substring</code> (ex : <code>"waterbottle</code> is a
     * rotation of <code>erbottlewat</code>)
     * 
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isRotation(String s1, String s2) {
	int len = s1.length();
	if (len == s2.length() && len > 0) {
	    String s1s1 = s1 + s1;
	    if (s1s1.contains(s2))
		return true;
	}

	return false;
    }

    public static void main(String[] args) {
	// System.out.println(isUnique("Kazi biid"));
	// System.out.println(checkPermutation("kazii", "zikai"));
	// System.out.println(urlify("Mr John Smiths "));
	// System.out.println(oneEditAway("pale", "ple"));
	// System.out.println(oneEditAway("pales", "pale"));
	// System.out.println(oneEditAway("pale", "bale"));
	// System.out.println(oneEditAway("pale", "bae"));
	// System.out.println(compressString("aabcccccaaa"));
	// System.out.println(compressString("abcdabcdd"));

	// rotate(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13,
	// 14, 15, 16 } });
	// setZeroes(new int[][] { { 1, 2, 3, 4 }, { 5, 0, 7, 8 }, { 9, 10, 11, 12 }, {
	// 13, 14, 15, 0 } });
	System.out.println(isRotation("waterbottle", "erbottlewat"));

    }
}
