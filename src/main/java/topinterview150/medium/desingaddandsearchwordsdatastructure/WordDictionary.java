package topinterview150.medium.desingaddandsearchwordsdatastructure;

import java.util.*;

public class WordDictionary {

    private static final Character HEAD_NODE_VAL = '!';
    private TrieNode headNode;

    public WordDictionary() {
        headNode = new TrieNode(HEAD_NODE_VAL);
    }

    public void addWord(String word) {
        TrieNode runner = headNode;
        for(int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            runner = runner.addNode(c);
        }

        runner.markEndWord();
    }

    public boolean search(String word) {
        Queue<TrieNode> trieNode = travelTreeForPrefix(word);
        for(TrieNode node : trieNode) {
            if(node.isWord) {
                return true;
            }
        }

        return false;
    }

    private Queue<TrieNode> travelTreeForPrefix(String prefix) {
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(headNode);
        int charIndex = 0;
        while(!queue.isEmpty() && charIndex < prefix.length()) {
            Queue<TrieNode> nextLevelQueue = new LinkedList<>();
            char currChar = prefix.charAt(charIndex);
            for(TrieNode currNode : queue) {
                if(currChar == '.') {
                    nextLevelQueue.addAll(currNode.getAllNodes().values());
                } else {
                    TrieNode nodeAtChar = currNode.getNodeAtChar(currChar);
                    if(nodeAtChar != null) {
                        nextLevelQueue.add(nodeAtChar);
                    }
                }
            }
            queue = nextLevelQueue;
            charIndex++;
        }

        return queue;
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

        public Map<Character, TrieNode> getAllNodes() {
            return nextNodes;
        }
    }

    public static void main(String[] args) {
        WordDictionary trie = new WordDictionary();
        trie.addWord("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        trie.addWord("app");
        System.out.println(trie.search("app"));
        System.out.println(trie.search(".pp.e"));
    }
}