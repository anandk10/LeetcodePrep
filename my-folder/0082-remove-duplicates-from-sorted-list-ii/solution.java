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
            t != null && t.next != null
            
            dummy-1-2-3-3-4-4-5
                    p   t
            
            
            duplicate
            p.next = t.next
            
            3-4-4-5
            t
            
            reset t = p.next
            
            dummy-1-2-4-4-5
                    p   t
                    
            p.next = t.next
            
            reset t = p.next
            dummy-1-2-5
                    p t           
            
        N nodes
        O(N)
        
        deletion - skipping duplicate nodes
        
    */
    
    private ListNode dropDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        // dummy - 1 - 2 - 3 - 4 - 5 - 6 - 6 -6 -6 -7 - 8 - 9 - 10 - 10;
             //                    p             t
        
        // dummy - 1 - 2 - 3 - 4 - 5 - 7 - 8 - 9 - 10 - 10;
     //                                        p         t
        
        // dummy - 1 - 2 - 3 - 4 - 5 - 7 - 8 - 9 ;
     //                                        p  t;
        // previous to actual node
        ListNode prev = dummy;
        // first actual node
        ListNode tmp = dummy.next;
        
        while (tmp != null && tmp.next != null) {
            
            while (tmp != null && 
                   tmp.next != null && 
                   tmp.val != tmp.next.val) {
                prev = tmp;
                tmp = tmp.next;   
            }
            
            if (tmp != null && 
                  tmp.next != null && 
                  tmp.val == tmp.next.val) {
                while(tmp != null && 
                  tmp.next != null && 
                  tmp.val == tmp.next.val) {
                    tmp = tmp.next;
                }
                prev.next = tmp.next;
                tmp = prev.next;
            }
            
        }
        
        
        
        return dummy.next;
    }
        
    public ListNode deleteDuplicates(ListNode head) {
        return dropDuplicates(head);
    }
}
