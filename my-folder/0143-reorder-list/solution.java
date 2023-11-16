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

    private ListNode findMiddle(ListNode head) {
        if (head == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        // 1
        // 1 - 2 - 3 - 4
        // 1 - 2 - 3 - 4 - 5
        // 
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
        // even nodes
        // if (fast.next.next == null) {
        //     return slow.next;
        // } else { 
        //     // fast is pointing to the last node
        //     // acc to the problem, for odd it's not exactly the middle node to be returned
        //     // hence returning slow.next
        //     // for 1->2->3->4->5
        //     // fast.next will be false on 5
        //     // slow will be on 3
        //     // but the new list expect to be starting at 4
        //     return slow.next;
        // }
    }



    // 1 - 2 - 3 - 4 .. <- 5

    private ListNode reverseList(ListNode head) {
        if (head == null) return head; //nothing to reverse
        if (head.next == null) {
            // only one node
            return head;
        }
        ListNode newHead = reverseList(head.next);

        ListNode curr = head;
        ListNode next = head.next;
        curr.next = null;
        next.next = head;

        return newHead;
    }

    

    private ListNode mergeLists(ListNode head1, ListNode head2) {

        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        while (head1 != null && head2 != null) {
            tail.next = head1;
            head1 = head1.next;
            tail = tail.next;
            tail.next = head2;
            head2 = head2.next;

            tail = tail.next;
        }

        if (head1 != null) {
            tail.next = head1;
        } else if (head2 != null) {
            tail.next = head2;
        }
        return dummyHead.next;
    }

    public void reorderList(ListNode head) {
        
        // find the middle node
        ListNode slow = findMiddle(head);
        ListNode head2 = slow.next;

        // break the second list
        slow.next = null;

        // reverse the second list
        head2 = reverseList(head2);

        head = mergeLists(head, head2);
    }
}
