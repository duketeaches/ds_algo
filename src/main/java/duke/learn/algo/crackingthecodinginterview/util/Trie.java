package duke.learn.algo.crackingthecodinginterview.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Kazi
 *
 */
public class Trie {
    private Node root;

    public Trie(List<String> words) {
	root = new Node();
	for (String word : words) {
	    root.addWord(word);
	}
    }

    public Trie(String[] words) {
	root = new Node();
	for (String word : words) {
	    root.addWord(word);
	}
    }

    public boolean contains(String prefix, boolean exact) {
	Node lastNode = root;
	int i = 0;
	for (i = 0; i < prefix.length(); i++) {
	    lastNode = lastNode.getChild(prefix.charAt(i));
	    if (lastNode == null) {
		return false;
	    }
	}
	return !exact || lastNode.terminates;
    }

    public boolean contains(String prefix) {
	return contains(prefix, false);
    }

    public Node getRoot() {
	return this.root;
    }

    public static class Node {
	private Map<Character, Node> children;
	private boolean terminates;
	private Character character;

	/**
	 * Constructs an empty Trie Node with the list of children. This is only used to
	 * construct the Root element.
	 */
	public Node() {
	    this.children = new HashMap<>();
	}

	/**
	 * @param children
	 * @param terminates
	 */
	public Node(char character) {
	    this();
	    this.character = character;
	}

	public void addWord(String word) {
	    if (word == null || word.isEmpty())
		return;

	    char firstChar = word.charAt(0);
	    Node child = getChild(firstChar);
	    if (child == null) {
		child = new Node(firstChar);
		children.put(firstChar, child);
	    }
	    if (word.length() > 1)
		child.addWord(word.substring(1));
	    else
		child.setTerminates(true);
	}

	public Node getChild(char c) {
	    return children.get(c);
	}

	public boolean isTerminates() {
	    return terminates;
	}

	public void setTerminates(boolean terminates) {
	    this.terminates = terminates;
	}

	public Character getCharacter() {
	    return character;
	}

    }
}
