package utils;

import java.util.List;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode() {

    }

    public static ListNode generateList(List<Integer> numbers) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        for(Integer num : numbers) {
            current.next = new ListNode(num);
            current = current.next;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode runner = head;

        while(runner != null) {
            System.out.printf("%s, ", runner.val);
            runner = runner.next;
        }
        System.out.println();
    }
}
