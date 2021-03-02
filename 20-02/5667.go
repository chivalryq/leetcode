package main

import "fmt"

func canEat(candiesCount []int, queries [][]int) []bool {
	ans := make([]bool, 0, len(queries))
	ccSum := make([]int, len(candiesCount))
	// ccsum[i]表示包括第i类糖果，之前共多少个
	for i, c := range candiesCount {
		if i == 0 {
			ccSum[0] = c
		} else {
			ccSum[i] = ccSum[i-1] + c
		}
	}
	for _, query := range queries {
		favType := query[0]
		favDay := query[1]
		dayCap := query[2]
		//0~favDay 一共favDay+1天
		if ccSum[favType] < favDay+1 {
			ans = append(ans, false)
		} else if favType > 0 && ccSum[favType-1] >= (favDay+1)*dayCap {
			ans = append(ans, false)
		} else {
			ans = append(ans, true)
		}
	}
	return ans
}

func main() {
	c := []int{7, 4, 5, 3, 8}
	q := [][]int{{0, 2, 2}, {4, 2, 4}, {2, 13, 1000000000}}
	c = []int{5, 2, 6, 4, 1}
	q = [][]int{{3, 1, 2}, {4, 10, 3}, {3, 10, 100}, {4, 100, 30}, {1, 3, 1}}
	c=[]int {16,38,8,41,30,31,14,45,3,2,24,23,38,30,31,17,35,4,9,42,28,18,37,18,14,46,11,13,19,3,5,39,24,48,20,29,4,19,36,11,28,49,38,16,23,24,4,22,29,35,45,38,37,40,2,37,8,41,33,8,40,27,13,4,33,5,8,14,19,35,31,8,8}
	q = [][]int{{43, 1054, 49}}
	fmt.Println(canEat(c, q))

}
