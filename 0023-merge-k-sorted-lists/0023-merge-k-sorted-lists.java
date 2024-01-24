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

import java.util.AbstractMap;

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        Comparator<Map.Entry<Integer, ListNode>> comparator = (a, b) -> {
            if (a.getKey() == b.getKey()) return 0;
            else if (a.getKey() < b.getKey()) return -1;
            else return 1;
        };
    
        Queue<Map.Entry<Integer, ListNode>> minLength = new PriorityQueue<>(comparator);
        
        for (ListNode list : lists) {
            if (list != null) {
                minLength.offer(new AbstractMap.SimpleEntry<>(getLength(list), list));
            }
        }

        while (!minLength.isEmpty() && minLength.size() >= 2) {
            Map.Entry<Integer, ListNode> minList1 = minLength.poll();
            Map.Entry<Integer, ListNode> minList2 = minLength.poll();

            ListNode mergedList = mergeList(minList1.getValue(), minList2.getValue());
            int mergedLength = minList1.getKey() + minList2.getKey();
            minLength.offer(new AbstractMap.SimpleEntry<>(mergedLength, mergedList));

        }

        if (minLength.size() != 0) {
            return minLength.poll().getValue();
        }

        return null;
    }

    private ListNode mergeList(ListNode list1, ListNode list2) {
        ListNode finalMerge = new ListNode(-1);
        ListNode tmp = finalMerge;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tmp.next = list1;
                list1 = list1.next;
            } else {
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }

        tmp.next = list1 == null ? list2 : list1;
        return finalMerge.next;
    }


    private int getLength(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len += 1;
        }
        return len;
    }
}