package dailyquestions.medium.longestsubstrwithoutrepeatingchars;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Window window = new Window();
        int maxWindow = 0;
        int size = 0;
        for(Character c : s.toCharArray()) {
            window.addNode(c);
            maxWindow = Math.max(maxWindow, window.getCounter());
        }

        return maxWindow;
    }

    private static class Window {
        Node head = new Node('$', null, null);
        Node lastNode = head;
        Set<Character> charsSet = new HashSet<>(256);
        int counter = 0;

        public void addNode(char nodeVal) {
            if(charsSet.contains(nodeVal)) {
                Node runner = head.next;
                while(runner.val != nodeVal) {
                    charsSet.remove(runner.val);
                    counter--;
                    Node temp = runner.next;
                    runner.next = null;
                    runner.prev = null;
                    runner = temp;
                }
                head.next = runner.next;
                counter--;
            }
            charsSet.add(nodeVal);
            counter++;
            Node newNode = new Node(nodeVal, null, lastNode);
            lastNode.next = newNode;
            lastNode = newNode;
            if(counter == 1) {
                head.next = lastNode;
            }
        }

        public int getCounter() {
            return counter;
        }
    }

    private static class Node {
        char val;
        Node next;
        Node prev;

        public Node(char val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

        public char getVal() {
            return val;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setVal(char val) {
            this.val = val;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }
}
