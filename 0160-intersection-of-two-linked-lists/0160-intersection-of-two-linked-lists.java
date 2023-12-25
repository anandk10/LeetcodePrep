/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        /** 
        
        Very nice trick : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/discuss/932914/Java-in-6-lines
        
        The concept is 
        
        start traversing both lists at the same time (use two diff pointers, 
        one of them will exhaust, lets say list1, then the pointer running list1, 
        should now start from list2. Meanwhile the list2 runner pointer is exactly
        at a node such that the distance between this node and the end is equal to 
        the difference of number of nodes in both the lists. When runner pointer
        on the list2 runs out, reset it to list1.
        
        So iteration 1:
        runner 1 runs with list 1
        runner 2 runs with list 2
        
        either list is exhauted
        reset runner 1 to list 2
        reset runner 2 to list 1
        
        keep looping until runner 1 != runner 2
        
        
                                      
                       2-->3
                            \b                    
        10->20->30->40->50->60->70
                                                                  
                            a       
                            
    headA              headB      
        10->20->30->40->50->60->70
                        a            
                        b                            
        */
        
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            if (a == null) {
                a = headB; //  a was shorter list, now start consuming with headB
            } else {
                a = a.next;
            }
            
            if (b == null) {
                b = headA; // b was shorter list, now start consuming with headA
            } else {
                b = b.next;
            }
        }
        return a;
    }
}