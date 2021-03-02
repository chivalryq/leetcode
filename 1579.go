package main

import "fmt"

func maxNumEdgesToRemove(n int, edges [][]int) int {
	for i := range edges {
		edges[i][1]--
		edges[i][2]--
	}
	fa := make([]int, n)
	for i := range fa {
		fa[i] = i
	}
	part := n
	var rem int
	var find func(int, []int) int
	find = func(x int, fa []int) int {
		if fa[x] == x {
			return x
		}
		fa[x] = find(fa[x], fa)
		return fa[x]
	}
	union := func(x, y int, fa []int) {
		yfa := find(y, fa)
		xfa := find(x, fa)
		fa[xfa] = yfa
	}
	for _, edge := range edges {
		if edge[0] != 3 {
			continue
		}
		x := edge[1]
		y := edge[2]
		if find(x, fa) != find(y, fa) {
			union(x, y, fa)
			part -= 1
		} else {
			rem += 1
		}
	}

	conA := make([]int, n)
	conB := make([]int, n)
	copy(conA, fa)
	copy(conB, fa)
	partA := part
	partB := part

	for _, edge := range edges {
		if edge[0] != 1 {
			continue
		}
		x := edge[1]
		y := edge[2]
		if find(x, conA) != find(y, conA) {
			union(x, y, conA)
			partA -= 1
		} else {
			rem += 1
		}
	}
	for _, edge := range edges {
		if edge[0] != 2 {
			continue
		}
		x := edge[1]
		y := edge[2]
		if find(x, conB) != find(y, conB) {
			union(x, y, conB)
			partB -= 1
		} else {
			rem += 1
		}
	}
	if partA != 1 || partB != 1 {
		return -1
	}
	return rem
}
func main() {
	n := 4
	edges := [][]int{{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}}
	edges = [][]int{{3, 1, 2}, {3, 2, 3}, {1, 1, 4}, {2, 1, 4}}
	edges = [][]int{{3, 2, 3}, {1, 1, 2}, {2, 3, 4}}
	fmt.Println(maxNumEdgesToRemove(n, edges))
}
