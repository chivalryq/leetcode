package main

import (
	"errors"
	"fmt"
	"sort"
)

type Edges [][]int

func (e Edges) Len() int { return len(e) }
func (e Edges) Less(i, j int) bool {
	return e[i][2] < e[j][2]
} // i, j 是元素的索引
func (e Edges) Swap(i, j int) {
	e[i], e[j] = e[j], e[i]
}
func findCriticalAndPseudoCriticalEdges(n int, edges [][]int) [][]int {
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

	for i := range edges {
		//第四个是原下标
		edges[i] = append(edges[i], i)
	}
	sort.Sort(Edges(edges))
	//标志点的出度
	getValue := func(edges Edges, n int, preEdge []int) (int, error) {
		for i := range fa {
			fa[i] = i
		}
		var k int
		var value int
		//先把边合并了
		if len(preEdge) > 0 {
			k += 1
			union(preEdge[0], preEdge[1])
			value += preEdge[2]
		}

		for _, edge := range edges {
			x := edge[0]
			y := edge[1]
			weight := edge[2]
			if find(x) != find(y) {
				union(x, y)
				k += 1
				value += weight
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
	value, _ := getValue(edges, n, []int{})

	ans := make([][]int, 2)
	ans[0] = make([]int, 0)
	ans[1] = make([]int, 0)
	for i, edge := range edges {
		index := edge[3]
		copyEdges := make([][]int, len(edges))
		//data,_:=json.Marshal(edges)
		//json.Unmarshal(data,&copyEdges)
		for i, edge := range edges {
			copyEdges[i] = make([]int, 3)
			copy(copyEdges[i], edge)
		}
		copyEdges = append(copyEdges[:i], copyEdges[i+1:]...)
		v, err := getValue(copyEdges, n, []int{})
		if err != nil || v > value {
			//不能联通或者生成树更大了说明这是关键边
			ans[0] = append(ans[0], index)
			continue
		}
		v, err = getValue(edges, n, edge)
		if v == value {
			//如果最小生成树的权值没变说明是非关键边
			ans[1] = append(ans[1], index)
		}
	}
	//sort.Ints(ans[0])
	//sort.Ints(ans[1])
	return ans
}
func main() {
	n := 5
	edges := [][]int{{0, 1, 1}, {1, 2, 1}, {2, 3, 2}, {0, 3, 2}, {0, 4, 3}, {3, 4, 3}, {1, 4, 6}}
	n = 6
	edges = [][]int{{0, 1, 2}, {0, 2, 5}, {2, 3, 5}, {1, 4, 4}, {2, 5, 5}, {4, 5, 2}}
	n = 14
	edges = [][]int{{0, 1, 13}, {0, 2, 6}, {2, 3, 13}, {3, 4, 4}, {0, 5, 11}, {4, 6, 14}, {4, 7, 8}, {2, 8, 6}, {4, 9, 6}, {7, 10, 4}, {5, 11, 3}, {6, 12, 7}, {12, 13, 9}, {7, 13, 2}, {5, 13, 10}, {0, 6, 4}, {2, 7, 3}, {0, 7, 8}, {1, 12, 9}, {10, 12, 11}, {1, 2, 7}, {1, 3, 10}, {3, 10, 6}, {6, 10, 4}, {4, 8, 5}, {1, 13, 4}, {11, 13, 8}, {2, 12, 10}, {5, 8, 1}, {3, 7, 6}, {7, 12, 12}, {1, 7, 9}, {5, 9, 1}, {2, 13, 10}, {10, 11, 4}, {3, 5, 10}, {6, 11, 14}, {5, 12, 3}, {0, 8, 13}, {8, 9, 1}, {3, 6, 8}, {0, 3, 4}, {2, 9, 6}, {0, 11, 4}, {2, 5, 14}, {4, 11, 2}, {7, 11, 11}, {1, 11, 6}, {2, 10, 12}, {0, 13, 4}, {3, 9, 9}, {4, 12, 3}, {6, 7, 10}, {6, 8, 13}, {9, 11, 3}, {1, 6, 2}, {2, 4, 12}, {0, 10, 3}, {3, 12, 1}, {3, 8, 12}, {1, 8, 6}, {8, 13, 2}, {10, 13, 12}, {9, 13, 11}, {2, 11, 14}, {5, 10, 9}, {5, 6, 10}, {2, 6, 9}, {4, 10, 7}, {3, 13, 10}, {4, 13, 3}, {3, 11, 9}, {7, 9, 14}, {6, 9, 5}, {1, 5, 12}, {4, 5, 3}, {11, 12, 3}, {0, 4, 8}, {5, 7, 8}, {9, 12, 13}, {8, 12, 12}, {1, 10, 6}, {1, 9, 9}, {7, 8, 9}, {9, 10, 13}, {8, 11, 3}, {6, 13, 7}, {0, 12, 10}, {1, 4, 8}, {8, 10, 2}}
	fmt.Println(findCriticalAndPseudoCriticalEdges(n, edges))
}
