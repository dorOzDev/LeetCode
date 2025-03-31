package utils;

import java.util.List;

public class ListNode {

    int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode() {

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
}
