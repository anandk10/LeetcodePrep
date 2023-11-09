/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev_slow = null;

        while(fast != null && n > 0) {
            fast = fast.next;
            n--;
        }

        while(fast != null) {
            prev_slow = slow;
            slow = slow.next;
            fast = fast.next;
        }

        // slow points to the node that is nth from last
        // and should be deleted.
        if (slow == head) {
            // handles case where nth ultimately points to head
            head = head.next;
            slow = null;
        } else {
            prev_slow.next = slow.next;
            slow.next = null;
            slow = null;
        }
        
        return head;
    }
}
