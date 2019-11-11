package duke.learn.algo.crackingthecodinginterview;

public class Chapter01BigO {

    /**
     * <b>O(log 2<sup>N</sup>)</b>
     * 
     * @param n
     */
    static void fibonacciRec(int n) {
	for (int i = 0; i < n; i++)
	    fibRec(i);// System.out.print(fib(i) + ", ");
    }

    private static int fibRec(int n) {
	if (n <= 0)
	    return 0;
	if (n == 1)
	    return 1;
	return (fibRec(n - 1) + fibRec(n - 2));
    }

    /**
     * <b>O(N)</b>
     * 
     * @param n
     */
    static void fibonacciMemo(int n) {
	int[] memo = new int[n + 1];
	for (int i = 0; i < n; i++)
	    fibMemo(i, memo);// System.out.print(fibMemo(i, memo) + ", ");
    }

    private static int fibMemo(int n, int[] memo) {
	if (n <= 0)
	    return 0;
	if (n == 1)
	    return 1;
	else {
	    if (memo[n] > 0)
		return memo[n];
	}
	memo[n] = (fibMemo(n - 1, memo) + fibMemo(n - 2, memo));
	return memo[n];
    }

    static void fibonacci(int n) {
	long a = 0, b = 1;
	if (n <= 0)
	    System.out.println(a);
	if (n == 1)
	    System.out.print(" " + b);
	else {
	    System.out.print(a + ", " + b);
	    for (int i = 0; i < n - 2; i++) {
		System.out.print(", " + (a + b));
		b = a + b;
		a = b - a;
	    }
	}
    }

    /**
     * The following function prints the powers of 2 from 1 through n (inclusive).
     * For example, if n is 4, it would print 1,2, and 4. What is its runtime? <br>
     * <b>O(log n)</b>
     * 
     * @param n
     * @return
     */
    static int powerOf2(int n) {
	if (n < 1)
	    return 0;
	else if (n == 1) {
	    System.out.println(1);
	    return 1;
	} else {
	    int prev = powerOf2(n / 2);
	    int curr = prev * 2;
	    System.out.println(curr);
	    return curr;
	}
    }

    /**
     * <b>O(log n)</b>
     * 
     * @param n
     */
    static void powerOf2Loop(int n) {
	if (n < 1)
	    System.out.println(0);
	else {
	    for (int i = 1; i <= n; i = i * 2) {
		System.out.println(i);
	    }
	}
    }

    /**
     * The following code computes a % b. What is its runtime?<br>
     * <b>O(1)
     * 
     * @param a
     * @param b
     * @return
     */
    static int modulo(int a, int b) {
	if (b < 0)
	    return -1;
	int dividend = a / b;
	return a - (dividend * b);
    }

    /**
     * The following code performs integer division(a/b). What is its runtime
     * (assume a and b are both positive)?<bR>
     * <b>O(a/b)</b>
     * 
     * @param a
     * @param b
     * @return
     */
    static void divInt(int a, int b) {
	int quotient = 0;
	int sum = b;
	while (sum <= a) {
	    sum += b;
	    quotient++;
	}
	System.out.println(a + "/" + b + " = " + quotient);

    }

    /**
     * The following code computes the [integer) square root of a number. If the
     * number is not a perfect square (there is no integer square root), then it
     * returns -1 .It does this by successive guessing. If n is 100, it first
     * guesses SO. Too high? Try something lower - halfway between 1 and SO. What is
     * its runtime? <br>
     * <b>O(log N)</b>
     * 
     * @param n
     */
    static void sqrtRec(int n) {
	System.out.println(sqrtHelper(n, 0, n));
    }

    static int sqrtHelper(int n, int min, int max) {
	if (max < min)
	    return -1;
	int guess = (max + min) / 2;
	int powerVal = guess * guess;
	if (powerVal == n)
	    return guess;
	else if (powerVal < n)// too low
	    return sqrtHelper(n, guess + 1, max);
	else // too high
	    return sqrtHelper(n, min, guess - 1);
    }

    /**
     * The following code computes the [integer) square root of a number. If the
     * number is not a perfect square (there is no integer square root), then it
     * returns -1. It does this by trying increasingly large numbers until it finds
     * the right value (or is too high). What is its runtime? <br>
     * <b> O(&#8730; n)</b>
     * 
     * @param n
     */
    static void sqrt(int n) {
	for (int guess = 1; guess * guess <= n; guess++) {
	    if (guess * guess == n) {
		System.out.println(guess);
		return;
	    }
	}
	System.out.println(-1);
    }

    /**
     * The appendToNew method appends a value to an array by creating a new, longer
     * array and returning this longer array. You've used the appendToNew method to
     * create a copyArray function that repeatedly calls appendToNew. How long does
     * copying an array take?<br>
     * <b>O(n<sup>2</sup>)</b>
     * 
     * @param array
     * @return
     */
    static int[] copyArray(int[] array) {
	int[] copy = new int[0];
	for (int i : array) {
	    copy = appendToNew(copy, i);
	}
	return copy;
    }

    private static int[] appendToNew(int[] array, int element) {
	int[] largerArray = new int[array.length + 1];
	for (int i = 0; i < array.length; i++) {
	    largerArray[i] = array[i];
	}
	largerArray[largerArray.length - 1] = element;
	return largerArray;
    }

    /**
     * The following code sums the digits in a number. What is its big 0 time? <br>
     * <b>Ans:</b> O( log n). The runtime will be the number of digits in the
     * number. A number with d digits can have a value up to led. If n = led, then d
     * = log n. Therefore, the runtime is <b> O( log n).
     * 
     * @param n
     * @return
     */
    static int sumOfDigits(int n) {
	int sum = 0;
	while (n > 0) {
	    sum += n % 10;
	    n = n / 10;
	}
	return sum;
    }

    /**
     * Given a smaller string 5 and a bigger string b, design an algorithm to find
     * all permutations of the shorter string within the longer one. Print the
     * location of each permutation.<br>
     * Note permutations are rearrangements of the string, so the characters in 5
     * can appear in any order in b. They must be contiguous though (not split by
     * other characters).<br>
     * 
     * @param longString
     * @param shortString
     */
    static void findPermutations(String longString, String shortString) {
	int lenS = shortString.length();
	int lenL = longString.length();

	for (int i = 0; i < lenL - lenS; i++) {
	    int matches = 0;
	    for (int j = 0; j < lenS; j++) {
		for (int k = 0; k < lenS; k++) {
		    if (longString.charAt(i + k) == shortString.charAt(j)) {
			matches++;
			break;
		    }
		}
	    }
	    if (matches == lenS)
		System.out.println("found at pos " + (i));
	}
    }

    /**
     * Given two sorted arrays, find the number of elements in common. The arrays
     * are the same length and each has all distinct elements<br>
     * <b> BCR - Best Conceivable Runtime - O(2N) = O(N) <br>
     * Optimal Runtime - O(N)
     * 
     * @param A
     * @param B
     */
    static void printOverlappingItems(int[] A, int[] B) {
	for (int i = 0; i < A.length; i++) {
	    int a = A[i];
	    int j = 0;
	    while (j < B.length) {
		int b = B[j];
		if (a == b) {
		    System.out.println(b);
		    ++j;
		    break;
		} else if (a < b) {
		    break;
		} else {
		    ++j;
		}
	    }
	}

    }

    public static void main(String[] args) {
	// long memoStart = System.nanoTime();
	// fibonacciMemo(47);
	// long memoEnd = System.nanoTime();
	// System.out.println("memo time: " + (memoEnd - memoStart) + " ns");
	// long start = System.nanoTime();
	// fibonacci(47);
	// long end = System.nanoTime();
	// System.out.println("fib time: " + (end - start) + " ns");

	// powerOf2Loop(100);
	// System.out.println(modulo(7, 4));
	// divInt(15000, 4);
	// long start = System.nanoTime();
	// sqrtRec(43046721);
	// long end = System.nanoTime();
	// System.out.println("rec time: " + (end - start) + " ns");
	// start = System.nanoTime();
	// sqrt(43046721);
	// end = System.nanoTime();
	// System.out.println("looper time: " + (end - start) + " ns");
	// Util.printArray(copyArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 }));
	// System.out.println(sumOfDigits(12345));
	// findPermutations("cbabadebbabbebabaabcebabe", "abbc");
	printOverlappingItems(new int[] { 13, 27, 35, 40, 49, 55, 59 }, new int[] { 17, 35, 39, 40, 55, 58, 60 });
    }

}
