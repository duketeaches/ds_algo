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
		System.out.println("Number of steps: " + i);
		return false;
	    }
	}
	System.out.println("Number of steps: " + i);
	return !exact || lastNode.terminates;
    }

    public boolean contains(String prefix) {
	return contains(prefix, false);
    }

    public TrieResult search(String prefix) {
	boolean found = true;
	Node lastNode = root;
	int i = 0;
	for (; i < prefix.length(); i++) {
	    lastNode = lastNode.getChild(prefix.charAt(i));
	    if (lastNode == null)
		found = false;
	}
	return new TrieResult(found, lastNode.totalSubWords);

    }

    public Node getRoot() {
	return this.root;
    }

    public static class Node {
	private Map<Character, Node> children;
	private boolean terminates;
	private Character character;
	private int totalSubWords = 0;

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
	    totalSubWords++;
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

    public static void main(String[] args) {
	Trie trie = new Trie(new String[] { "Maryam Kenpi", "keter Gamlin", "kazi abid azad", "kazi tanvir azad",
		"imanoor rahman", "Nira rahman", "Immaculate", "India", "kazi anoushka", "kazi zico", "kazi tauhid" });
	System.out.println(trie.contains("kazi"));
	System.out.println(trie.search("k"));
    }

    private static class TrieResult {
	boolean contains;
	int numberOfContacts;

	/**
	 * @param contains
	 * @param numberOfContacts
	 */
	public TrieResult(boolean contains, int numberOfContacts) {
	    super();
	    this.contains = contains;
	    this.numberOfContacts = numberOfContacts;
	}

	@Override
	public String toString() {
	    return "TrieResult [contains=" + contains + ", numberOfContacts=" + numberOfContacts + "]";
	}

    }
}
