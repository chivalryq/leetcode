package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func rotateRight(head *ListNode, k int) *ListNode {
	var f *ListNode
	f = head
	for i := 0; i < k; i++ {
		if f.Next == nil {
			f = head
			continue
		}
		f = f.Next
	}
	//copy
	var s *ListNode
	s = head
	f.Val = s.Val
	for s != nil {
		if f.Next == nil {
			f = head
		} else {
			f = f.Next
		}
		s = s.Next
		f.Val = s.Val
	}
	return head

}
