package main

import (
	"fmt"
)

func findLengthOfLCIS(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	pre := nums[0]
	ans := make([]int, 0)
	ans = append(ans, 1)
	pt := 0
	for _, i := range nums[1:] {
		if i > pre {
			ans[pt] += 1
			pre = i
		} else {
			pre = i
			pt += 1
			ans = append(ans, 1)
		}
	}
	a := ans[0]
	for _, v := range ans {
		if v > a {
			a = v
		}
	}
	return a
}
func main() {
	nums := []int{1, 3, 5, 4, 7, 2, 3, 4, 5}
	fmt.Println(findLengthOfLCIS(nums))
}
