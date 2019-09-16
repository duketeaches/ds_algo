package duke.learn.stacks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class StackOps {

    public static String reverseWord(String word) {
	Stack<Character> charStack = new Stack<>(word.length());
	for (int i = 0; i < word.length(); i++)
	    charStack.push(word.charAt(i));
	StringBuilder builder = new StringBuilder();
	while (!charStack.isEmpty())
	    builder.append(charStack.pop());
	return builder.toString();
    }

    public static boolean validateDelimeters(String brackets) {
	return validateDelimeters(brackets, false);
    }

    public static boolean validateDelimeters(String brackets, boolean debug) {
	Stack<Character> bracketStack = new Stack<>(brackets.length());

	brackets.chars().anyMatch(c -> {
	    boolean doNoContinue = false;
	    char ch = (char) c;
	    switch (ch) {
	    case '{':
	    case '(':
	    case '[':
		if (debug)
		    System.out.println("checking " + ch);
		bracketStack.push((char) ch);
		break;
	    case '}':
	    case ')':
	    case ']':
		if (debug)
		    System.out.println("checking " + ch);
		if (!bracketStack.isEmpty()) {
		    char chx = bracketStack.pop();
		    if ((ch == ')' && chx != '(') ||

			    (ch == '}' && chx != '{') ||

			    (ch == ']' && chx != '[')) {
			doNoContinue = true;
			bracketStack.push(ch);
			break;
		    }
		} else {
		    bracketStack.push(ch);
		    doNoContinue = true;
		    break;
		}
		break;
	    }
	    if (doNoContinue) {
		return true;
	    }
	    return false;
	});
	if (bracketStack.isEmpty())
	    return true;
	return false;

    }

    public static void main(String[] args) throws IOException {
	// System.out.println(reverseWord("WHAT"));
	File file = new File(
		"D:\\works\\workspaces\\EclipseWorkspaces\\POC\\data-structures\\src\\main\\java\\duke\\learn\\sort\\InsertionSort.java");
	String javaCode = new String(Files.readAllBytes(file.toPath()));
	// System.out.println(javaCode);
	System.out.println(validateDelimeters(javaCode, true));
    }
}
