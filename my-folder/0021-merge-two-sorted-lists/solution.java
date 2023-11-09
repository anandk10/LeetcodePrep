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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = null;
        // Iterate until both the lists have been exhausted.
        ListNode tmpNode = null;
        while (list1 != null || list2 != null) {

            // if list1 was empty, the remainder of the list2 becomes part of the mergedList
            if (list1 == null) {
                if (tmpNode == null) {
                    tmpNode = list2;
                    mergedList = tmpNode;
                } else {
                    tmpNode.next = list2;
                }
                break;
               
            }
            
            // if list2 was empty, the remainder of the list1 becomes part of the mergedList

            if (list2 == null) {
                if (tmpNode == null) {
                    tmpNode = list1;
                    mergedList = tmpNode;
                } else {
                    tmpNode.next = list1;
                }
                break;
            }

            if (list1.val <= list2.val) {
                if (tmpNode == null) {
                    tmpNode = list1;
                    mergedList = tmpNode;
                } else {
                    tmpNode.next = list1;
                    tmpNode = tmpNode.next;
                    
                }
                list1 = list1.next; 
                tmpNode.next = null;
                
            } else {
                if (tmpNode == null) {
                    tmpNode = list2;
                    mergedList = tmpNode;
                } else {
                    tmpNode.next = list2;
                    tmpNode = tmpNode.next;
                }
                list2 = list2.next; 
                tmpNode.next = null;
                
            }

            
        }

        return mergedList;
    }
}
