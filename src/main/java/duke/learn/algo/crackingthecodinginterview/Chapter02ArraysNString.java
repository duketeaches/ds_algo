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
    static boolean isUnique(String input) {
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
    static boolean checkPermutation(String str1, String str2) {
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
    static String urlify(String url) {
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

    public static void main(String[] args) {
	// System.out.println(isUnique("Kazi biid"));
	// System.out.println(checkPermutation("kazii", "zikai"));
	System.out.println(urlify("Mr John Smiths    "));
    }
}
