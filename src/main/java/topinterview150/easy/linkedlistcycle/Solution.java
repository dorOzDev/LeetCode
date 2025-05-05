package topinterview150.easy.linkedlistcycle;

import utils.ListNode;


public class Solution {

    public boolean hasCycle(ListNode head) {

        ListNode slowRunner = head;
        ListNode fastRunner = head;

        while(fastRunner != null) {
            fastRunner = fastRunner.next;
            if(fastRunner == null) {
                return false;
            }

            if(slowRunner == fastRunner) {
                return true;
            }
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next;
        }
        return false;
    }
}