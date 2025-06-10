package topinterview150.medium.desingaddandsearchwordsdatastructure;

public class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfsSearch(word, 0, root);
    }

    private boolean dfsSearch(String word, int index, TrieNode node) {
        // Base case: reached end of word
        if (index == word.length()) {
            return node.isEndOfWord;
        }

        char c = word.charAt(index);

        if (c == '.') {
            // Try all possible children - EARLY TERMINATION
            for (TrieNode child : node.children) {
                if (child != null && dfsSearch(word, index + 1, child)) {
                    return true; // Early termination!
                }
            }
            return false;
        } else {
            // Regular character
            int charIndex = c - 'a';
            TrieNode child = node.children[charIndex];
            return child != null && dfsSearch(word, index + 1, child);
        }
    }

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26]; // Array instead of HashMap
        boolean isEndOfWord = false;
    }
}