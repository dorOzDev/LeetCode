package topinterview150.medium.copylistwithrandompointer;

import java.util.HashMap;

public class Solution {

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> mapOriginToCopy = new HashMap<>();
        Node newHeadNode = null;
        Node runnerNode = head;

        while(runnerNode != null) {

            Node copiedNode = mapOriginToCopy.getOrDefault(runnerNode, new Node(runnerNode.val));
            mapOriginToCopy.put(runnerNode, copiedNode);

            if(runnerNode.next != null) {
                Node nextNodeCopy = mapOriginToCopy.getOrDefault(runnerNode.next, new Node(runnerNode.next.val));
                mapOriginToCopy.put(runnerNode.next, nextNodeCopy);
                copiedNode.next = nextNodeCopy;
            }
            if( runnerNode.random != null) {
                Node randomNodeCopy = mapOriginToCopy.getOrDefault(runnerNode.random, new Node(runnerNode.random.val));
                mapOriginToCopy.put(runnerNode.random, randomNodeCopy);
                copiedNode.random = randomNodeCopy;
            }
            runnerNode = runnerNode.next;

            if(newHeadNode == null) {
                newHeadNode = copiedNode;
            }
        }

        return newHeadNode;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
