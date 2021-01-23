package main

import (
	"errors"
	"fmt"
)

func makeConnected(n int, connections [][]int) int {
	if len(connections) < n-1 {
		return -1
	}
	fa := make([]int, n)
	for i := range fa {
		fa[i] = i
	}
	var find func(int) int
	find = func(x int) int {
		if fa[x] == x {
			return x
		}
		fa[x] = find(fa[x])
		return fa[x]
	}
	union := func(x, y int) {
		yfa := find(y)
		xfa := find(x)
		fa[xfa] = yfa
	}
	getValue := func(edges [][]int, n int) (int, error) {
		var k int
		var value int

		for _, edge := range edges {
			x := edge[0]
			y := edge[1]
			if find(x) != find(y) {
				union(x, y)
				k += 1
			}
			if k == n-1 {
				break
			}
		}
		if k < n-1 {
			return value, errors.New("no")
		}
		return value, nil
	}
	_, _ = getValue(connections, n)
	a := make(map[int]int)
	for i := range fa {
		fa[i] = find(i)
		a[fa[i]] += 1
	}
	return len(a) - 1
}
func main() {
	n := 6
	connections := [][]int{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}}
	fmt.Println(makeConnected(n, connections))
}
