# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:

    def findMiddle(self, head) -> ListNode:
        slow, fast = head, head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        return slow

    def reverseList(self, head) -> ListNode:
        prev, curr = None, head
        while curr:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        return prev

    def mergeLists(self, head1, head2) -> ListNode:
        dummyNode = ListNode()
        tail = dummyNode

        while head1 and head2:
            tail.next = head1
            head1 = head1.next
            tail = tail.next

            tail.next = head2
            head2 = head2.next
            tail = tail.next
        print(head1)
        if head1:
            tail.next = head1

        if head2:
            tail.next = head2
        
        return dummyNode.next

    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """

        middleNode = self.findMiddle(head)
        head2 = middleNode.next
        middleNode.next = None
        head2 = self.reverseList(head2)
        head = self.mergeLists(head, head2)


        
