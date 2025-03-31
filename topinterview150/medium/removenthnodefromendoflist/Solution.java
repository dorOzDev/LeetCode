package topinterview150.medium.removenthnodefromendoflist;

import utils.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> indexedList = new HashMap<>();
        ListNode runner = head;
        int counter = 0;

        while(runner != null) {
            indexedList.put(counter, runner);
            counter++;
            runner = runner.next;
        }

        int indexNodeToRemove = counter - n;

        ListNode toRemoveNode = indexedList.get(indexNodeToRemove);

        if(indexNodeToRemove == 0) {
            ListNode ans = toRemoveNode.next;
            toRemoveNode.next = null;
            return ans;
        }

        ListNode prevNode = indexedList.get(indexNodeToRemove - 1);
        prevNode.next = toRemoveNode.next;
        toRemoveNode.next = null;

        return head;
    }

    public static void main(String[] args) {
        new Solution().removeNthFromEnd(ListNode.generateList(List.of(1,2,3,4,5)), 2);
    }
}
