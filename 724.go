package main

import "fmt"

func pivotIndex(nums []int) int {
	leftSum := 0.0
	sum := 0
	for _, n := range nums {
		sum += n
	}
	for i, n := range nums {
		if leftSum == (float64(sum)-float64(n))/2 {
			return i
		}
		leftSum += float64(n)
	}
	return -1
}

func main() {
	nums := []int{1, 7, 3, 6, 5, 6}
	//nums = []int{1, 2, 3}
	//nums = []int{2, 1, -1}
	//nums = []int{0, 0, 0, 0, 1}

	fmt.Println(pivotIndex(nums))
}
