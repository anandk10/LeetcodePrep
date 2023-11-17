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


    private ListNode reverseListUntil(ListNode head, ListNode reverseUntil) {
        if (head == null) {
            return head;
        }

        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        // 1.<- 2 <- 3
        while(curr != reverseUntil) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode getKthNode(ListNode head, int k) {

        while (k > 0 && head != null) {
            head = head.next;
            k--;
        }
        return head;

    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        ListNode groupPrev = dummyNode;
        ListNode groupNext = null;
        ListNode tmp = null;

        while (true) {

            ListNode kthNode = getKthNode(groupPrev, k);

            if (kthNode == null) { break; }

            groupNext = kthNode.next;

            ListNode reverseHead = reverseListUntil(groupPrev.next, groupNext);
            tmp = groupPrev.next; // this will be the next iteration's groupPrev
            groupPrev.next.next = groupNext;
            groupPrev.next = reverseHead;
            groupPrev = tmp;
        }

        return dummyNode.next;
        // 1 - 2 - 3 - 4 - 5
        // k = 2
        // split the lists
        // into k groups
        // reverse those lists
        // and then merge it all together
        // if k is 1
        // then return head

        // split the lists = traversal - O(N)
        // reversing each sub lists - O(k) * #group - O(N)
        // store the split list heads -O(N/2) O(N)
        // 1-2 3-4 5
        // 2-1 4-3 5

        // 1--2--3--4--5

        // dummyNode--1--2--3--4--5
        // groupPrev     k  groupNext(3)

        // dummyNode--2--1--3--4--5
        // groupPrev     k  groupNext(3)


        // dummyNode--2--1--3--4--5
        //               groupPrev(1) k (4)  groupNext(5)
        
                        // 1--3--4--5
                        // 1--\ /--3---5
                        //     4

                        //     tmp = 3
                        //     3.next (null)
                        //     3.next = 5

        // dummyNode--2--1--4--3--5
        //               groupPrev(3) k (4)  groupNext(5)
    }
}
