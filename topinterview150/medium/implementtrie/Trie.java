package topinterview150.medium.implementtrie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private static final Character HEAD_NODE_VAL = '!';
    private TrieNode headNode;

    public Trie() {
        headNode = new TrieNode(HEAD_NODE_VAL);
    }

    public void insert(String word) {
        TrieNode runner = headNode;
        for(int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            runner = runner.addNode(c);
        }

        runner.markEndWord();
    }

    public boolean search(String word) {
        TrieNode trieNode = travelTreeForPrefix(word);
        return trieNode != null && trieNode.getIsWord();
    }

    public boolean startsWith(String prefix) {
        return travelTreeForPrefix(prefix) != null;
    }

    private TrieNode travelTreeForPrefix(String prefix) {
        TrieNode runner = headNode;
        int currentChar = 0;
        while(runner != null && currentChar < prefix.length()) {
            runner = runner.getNodeAtChar(prefix.charAt(currentChar));
            currentChar++;
        }

        return runner;
    }

    private static class TrieNode {

        private boolean isWord = false;
        private final char c;
        private final Map<Character, TrieNode> nextNodes;

        public TrieNode(char c) {
            this.c = c;
            this.nextNodes = new HashMap<>();
        }

        public TrieNode getNodeAtChar(char c) {
            return nextNodes.get(c);
        }

        public void markEndWord() {
            isWord = true;
        }

        public boolean getIsWord () {
            return isWord;
        }

        public TrieNode addNode(char c) {
            return nextNodes.computeIfAbsent(c, TrieNode::new);
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
        trie.search("app");
        trie.startsWith("app");
        trie.insert("app");
        trie.search("app");
    }
}