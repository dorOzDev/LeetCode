package topinterview150.medium.removeduplicatefromsortedlist2;

import utils.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode lastDiffNode = dummyHead;
        ListNode current = head;
        ListNode next = current.next;

        while(next != null) {
            while(next != null && next.val == current.val) {
                next = next.next;
            }

            if(next == null || next != current.next) {
                lastDiffNode.next = next;
                current = next;
            } else {
                lastDiffNode = current;
                current = next;
            }
            next = next != null ? next.next : null;
        }

        return dummyHead.next;
    }
}
