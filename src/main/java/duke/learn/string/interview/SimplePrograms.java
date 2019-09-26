/**
 * 
 */
package duke.learn.string.interview;

import java.math.BigInteger;

/**
 * @author Kazi
 *
 */
public class SimplePrograms {

    private static int loopCount = 0;

    /**
     * A word is palindrome if the reverse of the word is same as the word itself
     * <br>
     * <b>O(n) =n/2 </b> where n is the length of the word
     * 
     * @param word
     * @return
     */
    public static boolean isPalindrome(String word) {
	loopCount = 0;
	if (word != null) {
	    int len = word.length();
	    System.out.println("length : " + len);
	    char[] chars = word.toCharArray();
	    for (int i = 0; i < len / 2; i++) {
		if (chars[i] != chars[len - 1 - i]) {
		    return false;
		}
		loopCount++;
	    }
	    return true;
	}
	return false;
    }

    /**
     * A number is armstrong if the sum of cubes of all the digits is equal to the
     * number
     * 
     * @param num
     * @return
     */
    public static boolean isArmstrongNumber(int num) {
	if (num > 0) {
	    int temp = num;
	    int sum = 0;
	    while (temp > 0) {
		int n = temp % 10;
		sum += (n * n * n);
		temp = temp / 10;
	    }
	    if (sum == num) {
		return true;
	    }
	}
	return false;
    }

    public static int diff(String s1, String s2) {
	int diff = 0;

	return diff;
    }

    /**
     * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 . . . . . . <br>
     * 
     * @param len
     */
    public static void generateFibanacciNumbers(int len) {
	BigInteger a = new BigInteger("0");
	BigInteger b = new BigInteger("1");
	System.out.println();
	System.out.print(a + ", " + b + ", ");
	for (int i = 2; i <= len; i++) {
	    BigInteger c = a.add(b);
	    System.out.print(c + ", ");
	    a = b;
	    b = c;
	}
    }

    public static void main(String[] args) {
	// String word = "malayalammalayalammalayalammalayalammalayalam";
	// System.out.println(isPalindrome(word));
	// System.out.println("loop count : " + loopCount);
	// for (int i = 153; i < 1000000000; i++) {
	// // System.out.println("checking for " + i);
	// if (isArmstrongNumber(i)) {
	// System.out.println(i + " is an armstring number");
	// }
	// }
	generateFibanacciNumbers(15000);
    }

}
