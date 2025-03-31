package topinterview150.medium.removenthnodefromendoflist;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> indexedList = new ArrayList<>();
        ListNode runner = head;

        while(runner != null) {
            indexedList.add(runner);
            runner = runner.next;
        }

        int indexNodeToRemove = indexedList.size() - n;

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
