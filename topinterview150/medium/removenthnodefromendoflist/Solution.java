package topinterview150.medium.removenthnodefromendoflist;

import utils.ListNode;

import java.util.List;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode runner = head;
        ListNode slowRunner = head;
        ListNode prev = slowRunner;
        int countNodes = 0;
        while(runner != null) {
            if(countNodes < n) {
                countNodes++;
            } else {
                prev = slowRunner;
                slowRunner = slowRunner.next;
            }

            runner = runner.next;
        }

        if(prev == slowRunner) {
            ListNode ans = prev.next;
            prev.next = null;

            return  ans;
        }

        prev.next = slowRunner.next;
        slowRunner.next = null;
        return head;
    }

    public static void main(String[] args) {
        new Solution().removeNthFromEnd(ListNode.generateList(List.of(1)), 1);
    }
}
