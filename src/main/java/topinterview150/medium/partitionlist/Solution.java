package topinterview150.medium.partitionlist;

import utils.ListNode;

import java.util.List;

public class Solution {


    public ListNode partition(ListNode head, int x) {
        if(head == null) {
            return null;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode leftPtr = null;
        ListNode rightPtr = null;
        ListNode runner = head;
        ListNode lessThanPtr = dummy;

        while(runner != null) {
            if(runner.val >= x) {
                if(leftPtr == null) {
                    leftPtr = runner;
                }
                rightPtr = runner;
            } else {
                if(rightPtr != null) {
                    lessThanPtr.next = runner;
                    lessThanPtr = runner;
                    ListNode temp = runner.next;
                    runner.next = leftPtr;
                    rightPtr.next = temp;
                    runner = rightPtr;
                } else {
                    lessThanPtr = runner;
                }
            }

            runner = runner.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        new Solution().partition(ListNode.generateList(List.of(4, 3, 2, 5 ,2)), 3);
    }
}
