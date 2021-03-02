package main

import "fmt"

func minOperations(s string) int {
	next := map[int32]int32{48: 49, 49: 48}
	a := func(s string) int {
		now := int32(48) //0
		ret := 0
		for _, ch := range s {
			if ch != now {
				ret++
			}
			now=next[now]
		}
		return ret
	}
	b := func(s string) int {
		now := int32(49) //0
		ret := 0
		for _, ch := range s {
			if ch != now {
				ret++
			}
			now=next[now]
		}
		return ret
	}
	ans1:=a(s)
	ans2:=b(s)
	if ans1<ans2{
		return ans1
	}
	return ans2
}

func main() {
	s:="0100"
	s="1111"
	fmt.Println(minOperations(s))
}
