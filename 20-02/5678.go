package main

import "fmt"

func minimumSize(nums []int, maxOperations int) int {
	//二分查找答案
	//O(n) 内验证答案
	check := func(limit int) bool {
		op := 0
		for _, num := range nums {
			if num > limit {
				op += num / limit
				if num%limit == 0 {
					op--
				}
			}
			if op > maxOperations {
				return false
			}
		}
		return true
	}
	l := 1
	r := 1000000000
	ans := 1000000000
	for ; l <= r; {
		mid := (l + r) / 2
		if check(mid) {
			if mid < ans {
				ans = mid
			}
			r = mid - 1
		} else {
			l = mid + 1
		}
	}
	return ans
}

func main() {
	nums := []int{7, 17}
	nums = []int{2, 4, 8, 2}
	op := 4
	fmt.Println(minimumSize(nums, op))
}
