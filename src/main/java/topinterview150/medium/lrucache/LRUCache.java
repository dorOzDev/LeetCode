package topinterview150.medium.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, Node> map;
    private LinkedList linkedList;
    private int capacity;


    public LRUCache(int capacity) {
        map = new HashMap<>();
        linkedList = new LinkedList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            linkedList.updateLeastRecentlyUsed(node);
            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            linkedList.updateLeastRecentlyUsed(node);
            node.val = value;
        } else {
            if (map.size() == capacity) {
                map.remove(linkedList.detachHead());
            }
            map.put(key, linkedList.put(key, value));
        }
    }

    public class Node {

        private Node prev;
        private Node next;
        private int key;
        private int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public Node getPrev() {
            return prev;
        }

        public Node getNext() {
            return next;
        }

        public int getKey() {
            return key;
        }

        public int getVal() {
            return val;
        }
    }

    public class LinkedList {
        private Node head;
        private Node lastNode;

        public Node put(int key, int val) {
            Node node = new Node(key, val);
            if (head == null) {
                head = node;
                lastNode = head;
            } else {
                lastNode.next = node;
                node.prev = lastNode;
                lastNode = node;
            }

            return node;
        }

        public void updateLeastRecentlyUsed(Node node) {
            detachNode(node);
            lastNode.next = node;
            node.prev = lastNode;
            lastNode = node;
            if (head == null) {
                head = node;
            }
        }

        public int detachHead() {
            int headIndex = head.key;
            detachNode(head);
            return headIndex;
        }

        private void detachNode(Node node) {
            if (node == head) {
                Node tempNext = head.next;
                if (tempNext != null) {
                    tempNext.prev = null;
                }
                head.next = null;
                head = tempNext;
            } else if (node == lastNode) {
                Node temp = lastNode.prev;
                temp.next = null;
                lastNode.prev = null;
                lastNode = temp;
            } else {
                Node tempPrev = node.prev;
                Node tempNext = node.next;

                if (tempNext != null) {
                    tempNext.prev = tempPrev;
                }

                tempPrev.next = tempNext;
                node.prev = null;
                node.next = null;
            }
        }
    }
}
