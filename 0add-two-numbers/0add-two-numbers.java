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
    
    
//     6  6   6
//     6  6   6
//     12 13(1) 
    
//  %10 2 3 3 1
//  /10 0 1 1 1 
        
//  %10 drives new node creation
//         /10 helps in carry over the result
    
    // merge of two lists.
    
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        // 0 -> 2 -> 3 -> 3 -> 1
        
        // 3->2->1
        // 9->9
        // 2->2->2

        // 2-> 2 -> 
        // c = 1
        
        
        ListNode dummyNode = new ListNode();
        ListNode tail = dummyNode;
        if (l1 == null)
            tail.next = l2;
        if (l2 == null)
            tail.next = l1;
        int carry = 0;
        int rem = 0;
        
        while (l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val;
            rem = sum % 10; // 3
            carry = sum / 10; // 1
            
            l1 = l1.next;
            l2 = l2.next;
            
            tail.next = new ListNode(rem);
            tail = tail.next;
        }
        

        if (l1 != null) {
            while (l1 != null) {
                int sum = carry + l1.val;
                rem = sum % 10;
                carry = sum / 10;
                l1 = l1.next;
                
                tail.next = new ListNode(rem);
                tail = tail.next;            
            }
            
            if (carry != 0) {
                tail.next = new ListNode(carry);
                tail = tail.next;
                carry = 0 ; //resetting
            }
        }
        
        if (l2 != null){
            while (l2 != null) {
                int sum = carry + l2.val;
                rem = sum % 10;
                carry = sum / 10;
                l2 = l2.next;
                
                tail.next = new ListNode(rem);
                tail = tail.next;            
            }
            
            
        }        
        if (carry != 0) {
            tail.next = new ListNode(carry);
            tail = tail.next;
        }
        
        
        return dummyNode.next;
  
    }
}