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

    /**
    -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
                           s,                  f
     */
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode();

        ListNode tail = dummyNode;

        // walk through both the head1 and head2
        // at the same time
        while (head1 != null && head2 != null) {
            tail.next = head1;
            head1 = head1.next;
            tail = tail.next;

            tail.next = head2;
            head2 = head2.next;
            tail = tail.next;
        }

        // get the remaining head1 list
        if (head1 != null) {
            tail.next = head1;
        }
        // get the remaining head2 list
        if (head2 != null) {
            tail.next = head2;
        }

        return dummyNode.next;
    }

    public void reorderList(ListNode head) {
        
        // find the middle node
        ListNode middleNode = findMiddle(head);
        ListNode head2 = middleNode.next;
        middleNode.next = null;

        // reverse the second list
        head2 = reverseList(head2);

        // merge the two lists
        head = mergeList(head, head2);
    }
}
