/**
 * 
 */
package duke.learn.algo.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Kazi
 *
 */
@SuppressWarnings("unused")
public class Chapter08RecursioAndDynamicProgramming {

    public static void fibonacci(int n) {
	System.out.println("Printing " + n + "th fibanacci number with various techniques");
	// Using basic recursion
	System.out.println(fibWithRecursion(n));
	// Using Dynamic/Memoization - Top Down
	System.out.println(fibWithMemo(n, new int[n + 1]));
	// Using Dynamic - Bottom Up
	System.out.println(fibWithMemoItr(n));
    }

    /**
     * Fibonacci with basic recursion <br>
     * Time: <b>O(2<sup>N</sup>)</b>
     */
    private static int fibWithRecursion(int n) {
	if (n == 0)
	    return 0;
	if (n == 1)
	    return 1;
	return fibWithRecursion(n - 1) + fibWithRecursion(n - 2);
    }

    /**
     * Fibonacci with memoization/Dynamic Programming <br>
     * Time:<b>O(N)</b>
     */
    private static int fibWithMemo(int n, int[] memo) {
	if (n == 0 || n == 1)
	    return n;
	if (memo[n] == 0)
	    memo[n] = fibWithMemo(n - 1, memo) + fibWithMemo(n - 2, memo);
	return memo[n];
    }

    /**
     * Dynamic Programming without Recursion<br>
     * Time:<b>O(N)</b>
     */
    private static int fibWithMemoItr(int n) {
	if (n == 0)
	    return 0;
	int a = 0;
	int b = 1;
	for (int i = 2; i < n; i++) {
	    int c = a + b;
	    a = b;
	    b = c;
	}
	return a + b;
    }

    /**
     * <b>Triple Step:</b> A child is running up a staircase with n steps and can
     * hop either 1 step, 2 steps, or 3 steps at a time. Implement a method to count
     * how many possible ways the child can run up the stairs.
     * 
     * @param n
     */
    public static void tripleStep(int n) {
	// Using Basic recursion/ Brute Force
	System.out.println(countWays(n));
	// Using memoization
	int[] memo = new int[n + 1];
	Arrays.fill(memo, -1);
	System.out.println(countWays(n, memo));
    }

    /**
     * Using Brute force - Recursion <br>
     * Time: <b>O(3<sup>N</sup>)</b>
     * 
     * @return
     */
    private static int countWays(int n) {
	if (n < 0)
	    return 0;
	if (n == 0)
	    return 1;
	else
	    return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }

    /**
     * With Memoization<br>
     * Time:<b>O(N)</b>
     */
    private static int countWays(int n, int[] memo) {
	if (n < 0)
	    return 0;
	if (n == 0)
	    return 1;
	else if (memo[n] > 0)
	    return memo[n];
	else {
	    memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
	    return memo[n];
	}
    }

    /**
     * <b>Robot in a Grid:</b> Imagine a robot sitting on the upper left corner of
     * grid with r rows and c columns. The robot can only move in two directions,
     * right and down, but certain cells are "off limits" such that the robot cannot
     * step on them. Design an algorithm to find a path for the robot from the top
     * left to the bottom right.
     */
    public static void solvePathForRobotInAGrid() {

	boolean[][] grid = {

		{ true, true, true, true, true },

		{ false, true, true, true, true },

		{ false, false, true, false, true },

		{ true, true, true, false, true },

		{ true, true, true, true, true } };
	// Simple recursion
	System.out.println(getPath(grid));
	// With memo
	System.out.println(getPathMemo(grid));

    }

    /**
     * <b>O(2<sup>(r+c)</sup>), since each path has r+c steps and there are two
     * choices we can make at each step.</b>
     */
    private static List<Point> getPath(boolean[][] matrix) {
	if (matrix == null || matrix.length == 0)
	    return null;
	List<Point> path = new ArrayList<>();
	HashSet<Point> failedPoints = new HashSet<>();
	if (getPath(matrix, matrix.length - 1, matrix[0].length - 1, path, failedPoints))
	    return path;
	return null;
    }

    private static boolean getPath(boolean[][] matrix, int row, int col, List<Point> path, Set<Point> failedPoints) {
	/*
	 * If Out of bound or path not allowed return
	 */
	if (col < 0 || row < 0 || !matrix[row][col])
	    return false;

	Point point = new Point(row, col);

	if (failedPoints.contains(point))
	    return false;

	boolean atOrigin = row == 0 && col == 0;
	// uncomment the first getPath if diagonal traversal is allowed, then the time
	// will 3 power(r+c)
	if (atOrigin // || getPath(matrix, row - 1, col - 1, path, failedPoints)
		|| getPath(matrix, row, col - 1, path, failedPoints)
		|| getPath(matrix, row - 1, col, path, failedPoints)) {
	    path.add(point);
	    return true;
	}

	return false;
    }

    /**
     * <b>O(rc))</b>
     */
    private static List<Point> getPathMemo(boolean[][] matrix) {
	if (matrix == null || matrix.length == 0)
	    return null;
	List<Point> path = new ArrayList<>();
	HashSet<Point> failedPoints = new HashSet<>();
	Map<Point, Boolean> cache = new HashMap<Chapter08RecursioAndDynamicProgramming.Point, Boolean>();
	if (getPathMemo(matrix, matrix.length - 1, matrix[0].length - 1, path, failedPoints, cache))
	    return path;
	return null;
    }

    private static boolean getPathMemo(boolean[][] matrix, int row, int col, List<Point> path, Set<Point> failedPoints,
	    Map<Point, Boolean> cache) {
	if (row < 0 || col < 0 || !matrix[row][col])
	    return false;

	Point point = new Point(row, col);
	if (cache.containsKey(point))
	    return cache.get(point);

	boolean atOrigin = row == 0 && col == 0;
	boolean success = false;
	if (atOrigin || getPathMemo(matrix, row - 1, col, path, failedPoints, cache)
		|| getPathMemo(matrix, row, col - 1, path, failedPoints, cache)) {
	    success = true;
	    path.add(point);
	}
	cache.put(point, success);
	return success;
    }

    /**
     * <b> Magic Index:</b> A magic index in an array A [1. .. n -1] is defined to
     * be an index such that A[ i] i. Given a sorted array of distinct integers,
     * write a method to find a magic index, if one exists, in array A.<br>
     * <br>
     * <b>Follow Up:</b><br>
     * What if the values are not distinct
     */
    public static void magicIndex() {
	int arr[] = { -40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13 };
	System.out.println(magicIndex(arr, 0, arr.length - 1));
	int arr2[] = { -10, -5, 2, 2, 2, 3, 4, 7, 9, 8 };
	System.out.println(magicIndexWithDups(arr2, 0, arr2.length - 1));
    }

    /**
     * This works if the elements are distinc<br>
     * Time: <b>O(logN)</b> - Binary searh algorithm
     */
    private static int magicIndex(int[] array, int start, int end) {
	if (end < start)
	    return -1;
	int mid = (start + end) / 2;
	if (array[mid] == mid)
	    return mid;
	else if (array[mid] < mid)
	    return magicIndex(array, mid + 1, end);
	else
	    return magicIndex(array, start, mid - 1);
    }

    private static int magicIndexWithDups(int[] array, int start, int end) {
	if (end < start)
	    return -1;
	int midIndex = (start + end) / 2;
	int midElement = array[midIndex];
	if (midElement == midIndex)
	    return midElement;
	// solve for left
	int leftIndex = Math.min(midElement, midIndex - 1);
	int left = magicIndexWithDups(array, 0, leftIndex);
	if (left > 0)
	    return left;

	// solve for right
	int rightIndex = Math.max(midElement, midIndex + 1);
	int right = magicIndexWithDups(array, rightIndex, end);
	return right;
    }

    /**
     * Power Set: Write a method to return all subsets of a set.
     */
    public static void powerSet() {
	System.out.println(powerSet(new int[] { 1, 2, 3 }));
    }

    private static List<List<Integer>> powerSet(int[] array) {
	List<List<Integer>> allSets = new ArrayList<>();
	powerSet(allSets, new ArrayList<>(), array, 0);
	return allSets;
    }

    private static void powerSet(List<List<Integer>> allSets, List<Integer> subset, int[] array, int start) {
	allSets.add(new ArrayList<>(subset));
	for (int i = start; i < array.length; i++) {
	    // add
	    subset.add(array[i]);
	    // explore
	    powerSet(allSets, subset, array, i + 1);
	    // remove the extra element
	    subset.remove(subset.size() - 1);
	}
    }

    public static List<String> getPerms(String str) {
	if (str == null)
	    return null;
	List<String> perms = new ArrayList<>();
	if (str.length() == 0) {
	    perms.add("");
	    return perms;
	}
	char first = str.charAt(0);
	String remainder = str.substring(1);// remainder of the string
	List<String> words = getPerms(remainder);
	for (String word : words) {
	    for (int i = 0; i < word.length(); i++) {
		perms.add(insertCharAt(word, first, i));
	    }
	}
	return perms;

    }

    private static String insertCharAt(String word, char letter, int pos) {
	String start = word.substring(0, pos);
	String end = word.substring(pos);
	return start + letter + end;
    }

    private static enum Color {
	BLUE, GREEN, RED, YELLOW
    }

    public static void paintFill() {
	Color[][] screen = new Color[][] {
		{ Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN },

		{ Color.GREEN, Color.RED, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN },

		{ Color.GREEN, Color.RED, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN },

		{ Color.GREEN, Color.GREEN, Color.RED, Color.GREEN, Color.GREEN, Color.GREEN },

		{ Color.GREEN, Color.GREEN, Color.RED, Color.RED, Color.GREEN, Color.GREEN },

		{ Color.GREEN, Color.GREEN, Color.GREEN, Color.RED, Color.GREEN, Color.GREEN },

		{ Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN }

	};

	paintFill(screen, 1, 1, Color.RED, Color.YELLOW);
	for (int i = 0; i < screen.length; i++) {
	    for (int j = 0; j < screen[i].length; j++) {
		System.out.print(screen[i][j] + "      ");
	    }
	    System.out.println();
	}

    }

    private static boolean paintFill(Color[][] screen, int row, int col, Color oColor, Color nColor) {
	if (row < 0 || row > screen.length || col < 0 || col > screen[0].length)
	    return false;
	if (screen[row][col] == oColor) {
	    screen[row][col] = nColor;
	    paintFill(screen, row + 1, col + 1, oColor, nColor);
	    paintFill(screen, row - 1, col - 1, oColor, nColor);
	    paintFill(screen, row - 1, col + 1, oColor, nColor);
	    paintFill(screen, row + 1, col - 1, oColor, nColor);
	    paintFill(screen, row + 1, col, oColor, nColor);
	    paintFill(screen, row, col + 1, oColor, nColor);
	    paintFill(screen, row - 1, col, oColor, nColor);
	    paintFill(screen, row, col - 1, oColor, nColor);
	}
	return true;
    }

    /**
     * Coins: Given an infinite number of quarters (25 cents), dimes (10 cents),
     * nickels (5 cents), and pennies (1 cent), write code to calculate the number
     * of ways of representing n cents.
     */
    public static int makeChange(int amount, int[] denoms, int index) {
	if (index >= denoms.length - 1)
	    return 1; // last denom
	int denomAmount = denoms[index];
	int ways = 0;
	for (int i = 0; i * denomAmount <= amount; i++) {
	    int remainingAmount = (amount - 1) * denomAmount;
	    ways += makeChange(remainingAmount, denoms, index + 1);
	}
	return ways;
    }

    public static void main(String[] args) {
	// fibonacci(45);
	// tripleStep(35);
	// solvePathForRobotInAGrid();
	// magicIndex();
	// powerSet();
	// System.out.println(32 << 1);
	// System.out.println(getPerms("abc"));
	// paintFill();
	System.out.println(makeChange(50, new int[] { 1, 5, 10, 25 }, 0));
    }

    private static class Point {
	private int rowIndex, columnIndex;

	public Point(int rowIndex, int columnIndex) {
	    super();
	    this.rowIndex = rowIndex;
	    this.columnIndex = columnIndex;
	}

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + columnIndex;
	    result = prime * result + rowIndex;
	    return result;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
		return true;
	    if (obj == null)
		return false;
	    if (getClass() != obj.getClass())
		return false;
	    Point other = (Point) obj;
	    if (columnIndex != other.columnIndex)
		return false;
	    if (rowIndex != other.rowIndex)
		return false;
	    return true;
	}

	@Override
	public String toString() {
	    return "(" + rowIndex + "," + columnIndex + ")";
	}

    }
}
