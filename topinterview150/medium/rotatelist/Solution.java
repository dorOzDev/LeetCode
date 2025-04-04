package topinterview150.medium.rotatelist;

import utils.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return null;
        }

        Map<Integer, ListNode> mapNewPositions = new HashMap<>();
        int size = 0;
        ListNode runner = head;
        while(runner != null) {
            size++;
            runner = runner.next;
        }

        runner = head;
        int current = 0;
        while(runner != null) {
            int newPos = (current + k) % size;
            mapNewPositions.put(newPos, runner);
            current++;
            runner = runner.next;
        }

        ListNode dummyHead = new ListNode();
        ListNode prevNode = mapNewPositions.get(0);
        dummyHead.next = prevNode;
        for(int i = 1; i < mapNewPositions.size(); ++i) {
            prevNode.next = mapNewPositions.get(i);
            prevNode = prevNode.next;
        }

        prevNode.next = null;

        return dummyHead.next;
    }
}
