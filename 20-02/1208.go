package main

import "fmt"

func equalSubstring(s string, t string, maxCost int) int {
	costs := make([]int, len(s), len(s))
	for i := range costs {
		var sub int
		if s[i] > t[i] {
			sub = int(s[i] - t[i])
		} else {
			sub = int(t[i] - s[i])
		}
		costs[i] = int(sub)
	}
	left := 0
	right := 0
	nowCost := 0
	nowLen := 0
	ans := 0
	for ; right < len(s); {
		nowCost += costs[right]
		if nowCost > maxCost {
			nowCost-=costs[left]
			left++
		}
		nowLen = right - left + 1
		if nowLen > ans {
			ans = nowLen
		}
		right++
	}
	return ans
}

func main() {
	s := "abcd"
	t := "cdef"
	s = "krrgw"
	t = "zjxss"
	cost := 19
	fmt.Println(equalSubstring(s, t, cost))
}
