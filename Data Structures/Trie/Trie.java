/* Jordan Brengman
	ENGR 143
	Final */

/**
* @author Jordan Brengman
*/

public class Trie {


// Fields

    private static int NUM_CHILDREN = 26; // Number of possible child nodes, 1 per character of String code.
    private static String code = "abcdefghijklmnopqrstuvwxyz"; // Possible characters found in this trie.
    Node bigRoot; // Overall root of the trie.
	 

// Constructor

    public Trie() {
        bigRoot = new Node();
    }


// Methods

	/**
	* @param word The word to be added to the trie.
	*/
    public void add(String word) {
        Node root = bigRoot;
        add(bigRoot, word);
    }

	/**
	* @param root The current node to whose child node word.charAt(0) will be added, if it does not already exist.
	* @param word The remaining characters of the word being added to the trie.
	*/
    private void add(Node root, String word) {
        if (word.length() > 0) {
            int i = code.indexOf(word.charAt(0)); 	// Index of first character of word within String code.
            if (root.child[i] == null) { 				// If there is no child node containing the current first 
                root.child[i] = new Node();			// character of word, create a new child node containing
                root.child[i].character = word.charAt(0);	// that character.
            }
            add(root.child[i], word.substring(1, word.length())); // Call add on child node containing first
            ++root.child[i].prefixes;									// character of word and substring(1, length).
        } else {
            root.endOfWord = true; // word.length = 0, reached the end of word.
        }
    }

	/**
	*
	*/
    public void printWords() {
        String word = "";
        for (int i = 0; i < NUM_CHILDREN; ++i) { // Iterate over the number of possible characters in String code.
            if (bigRoot.child[i] != null) {				// If bigRoot[i] contains a child node...
                printWords(bigRoot.child[i], word);
            }
        }
    }

	/**
	* @param t The current node being searched for characters to add to String s.
	* @param s The string being built that is to eventually be printed once the end of the word has been reached.
	*/
    private void printWords(Node t, String s) {
        if (t == null) {	// Break out of current method call if node t is null.
            return;
        }

        s += t.character;				// Add character found at this node to String s.
        if (t.endOfWord) {				// If the end of the words has been reached,
            System.out.println(s);	// Print String s.
        }

        for (int i = 0; i < NUM_CHILDREN; ++i) {	// Iterate over possible child nodes to search
            if (t.child[i] != null) {					// for nodes that are not null.
                printWords(t.child[i], s);
            }
        }
    }
	
	/**
	* @param s The word being searched for within this trie.
	* @return Returns true if this trie contains String s, returns false otherwise.
	*/
	public boolean contains(String s) {
		return contains(bigRoot, s);
	}
	
	/**
	* @param root The current node being searched for String s.
	* @param s The string being searched for within Node root.
	* @return Returns true is String s is found within Node root, false otherwise.
	*/
	public boolean contains(Node root, String s) {
		if (s.length() > 0) {
			int i = code.indexOf(s.charAt(0));	// Index of first character of s within String code.
			if (root.child[i] == null) {			// Return false if there is no child node within root
				return false;							// containing the current first character of s.
			}
			return contains(root.child[i], s.substring(1, s.length()));
		}
		return root.endOfWord; // s.length() = 0, returns true if this node is the end of a word, false otherwise.
	}
	
	/**
	* @return Returns the number of words found within this trie.
	*/
	public int wordCount() {
		int count = 0;
		for (int i = 0; i < NUM_CHILDREN; i++) {		// Iterate over possible child nodes to search for nodes
			if (bigRoot.child[i] != null) {				// that are not null.
				count += wordCount(bigRoot.child[i]);	// Add to total count the number of words in each child node.
			}
		}
		return count; // Return the total word count.
	}
	
	/**
	* @param root The node currently whose word count is to be found.
	* @return Returns the number of words found within Node root.
	*/
	private int wordCount(Node root){
		int count = 0;
		for (int i = 0; i < NUM_CHILDREN; i++) {	// Iterate over possible child nodes of root to search for nodes
			if (root.child[i] != null) {				// that are not null.
				count += wordCount(root.child[i]);	// Add the word count of each child node to total count for root. 
			}
		}
		if (root.endOfWord) {	// If root is the end of the word, count = count + 1
			count++;
		}
		return count;	// Return the word count for Node root.
	}
	
	/**
	* @param s The word to be removed from this trie.
	*/
	public void remove(String s) {
		remove(bigRoot, s);
	}
	
	/**
	* @param root The node currently being searched for the first character of String s (s.charAt(0)).
	* @param s The String containing remaining characters of the word to be removed from the trie.
	*/
	private void remove(Node root, String s) {
		if (s.length() == 0) {		// If the end of the word to be removed has been reached, set endOfWord
			root.endOfWord = false; // for Node root to false.
		} else {
			int i = code.indexOf(s.charAt(0));	// Index of first character of s within String code.
			if (root.child[i] != null) {			// If there is a child node containing the next character of String s
				remove(root.child[i], s.substring(1, s.length()));
			}
		}
	}


    private class Node {

        public Node child[];			// Child nodes of this node.
        public char character; 		// Character contained within this node.
        public boolean endOfWord;	// True if this node marks the end of a word, false otherwise.
        public int prefixes;			// Number of nodes "higher" up the tree from this node.

        public Node() {
            child = new Node[NUM_CHILDREN];
            endOfWord = false;
            prefixes = 0;
        }
    }
}
