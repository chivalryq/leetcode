# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        if not head:
            return None
        sm_ptr=None
        bg_ptr=None
        sm=None
        bg=None
        while head:
            if head.val<x:
                if not sm:
                    sm=ListNode(head.val)
                    sm_ptr=sm
                else:
                    sm_ptr.next=ListNode(head.val)
                    sm_ptr=sm_ptr.next
            else:
                if not bg:
                    bg=ListNode(head.val)
                    bg_ptr=bg
                else:
                    bg_ptr.next=ListNode(head.val)
                    bg_ptr=bg_ptr.next
            head=head.next
        if sm:
            ans=sm
            if bg:
                sm_ptr.next=bg
            return ans
        elif bg:
            return bg







if __name__ == '__main__':
    h1=ListNode(1)
    h2=ListNode(4)
    h3=ListNode(3)
    h4=ListNode(2)
    h5=ListNode(5)
    h6=ListNode(2)
    h1.next=h2
    h2.next=h3
    h3.next=h4
    h4.next=h5
    h5.next=h6
    Solution().partition(h1,3)
