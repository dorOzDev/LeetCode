package dailyquestions.medium.addtwonumbers;

import utils.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumListDummy = new ListNode();
        ListNode sumListRunner = sumListDummy;
        ListNode l1Runner = l1;
        ListNode l2Runner = l2;
        int remainder = 0;

        while(l1Runner != null && l2Runner != null) {
            int total = l1Runner.val + l2Runner.val + remainder;
            ListNode nextNode = new ListNode(total % 10);
            remainder = total / 10;
            sumListRunner.next = nextNode;
            sumListRunner = sumListRunner.next;
            l1Runner = l1Runner.next;
            l2Runner = l2Runner.next;
        }

        while(l1Runner != null) {
            int total = l1Runner.val + remainder;
            ListNode nextNode = new ListNode(total % 10);
            remainder = total / 10;
            sumListRunner.next = nextNode;
            sumListRunner = sumListRunner.next;
            l1Runner = l1Runner.next;
        }

        while(l2Runner != null) {
            int total = l2Runner.val + remainder;
            ListNode nextNode = new ListNode(total % 10);
            remainder = total / 10;
            sumListRunner.next = nextNode;
            sumListRunner = sumListRunner.next;
            l2Runner = l2Runner.next;
        }

        if (remainder > 0) {
            sumListRunner.next = new ListNode(remainder);
        }

        return sumListDummy.next;
    }
}
