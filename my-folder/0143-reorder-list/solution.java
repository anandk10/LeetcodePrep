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
    public void reorderList(ListNode head) {
        List<ListNode> arrayLinkedList = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            arrayLinkedList.add(tmp);
            tmp = tmp.next;
        }



        int i = 0;
        int j = arrayLinkedList.size() - 1;
        ListNode newList = null;
        arrayLinkedList.stream().forEach(node -> node.next = null);
  

        while (i < j) {
            if (newList == null) {
                tmp = arrayLinkedList.get(i);
                newList = tmp;
                System.out.println(tmp.val);
                tmp.next = arrayLinkedList.get(j);
                tmp = tmp.next;
                System.out.println(tmp.val);
            } else {
                tmp.next = arrayLinkedList.get(i);
                tmp = tmp.next;
                tmp.next = arrayLinkedList.get(j);
                tmp = tmp.next;
            }
            
            i++; j--;
        }

        if (i == j) {
            if (newList == null) {
                tmp = arrayLinkedList.get(i);
                newList = tmp;
            } else { 
                tmp.next = arrayLinkedList.get(i);
            }
            
        }
        head = newList;
    }
}
