package main

import (
	"fmt"
	"math"
	"sort"
)

type disList []distance

func (p disList) Swap(i, j int)      { p[i], p[j] = p[j], p[i] }
func (p disList) Len() int           { return len(p) }
func (p disList) Less(i, j int) bool { return p[i].val < p[j].val }

type distance struct {
	key [2]int
	val int
}

func minCostConnectPoints(points [][]int) int {
	getDis := func(p1 []int, p2 []int) int {
		return int(math.Abs(float64(p1[0]-p2[0])) + math.Abs(float64(p1[1]-p2[1])))
	}
	var dis disList
	for i := range points {
		for j := range points {
			if i == j {
				break
			}
			dis = append(dis, distance{key: [2]int{i, j}, val: getDis(points[i], points[j])})
		}
	}

	sort.Sort(dis)
	//fmt.Println(dis)
	fa := make([]int, len(points))
	for i := range fa {
		fa[i] = i
	}
	var find func(int) int
	var union func(int, int)
	find = func(x int) (f int) {
		if fa[x] == x {
			f = x
			return
		}
		f = find(fa[x])
		return
	}
	union = func(x int, y int) {
		xfa := find(x)
		yfa := find(y)
		fa[x] = yfa
		for i := range fa {
			if fa[i] == xfa {
				fa[i] = yfa
			}
		}
	}

	var ans int
	//in := make(map[int]bool)
	cnt := 0
	for _, d := range dis {
		a,b:=find(d.key[0]),find(d.key[1])
		if a!=b{
			union(a,b)
			cnt++
			ans+=d.val
		}
		//我是傻逼
		//if in[d.key[0]] && in[d.key[1]] {
		//	if find(d.key[0]) == find(d.key[1]) {
		//		continue
		//	}
		//	//两个联通部分合并
		//	union(d.key[0], d.key[1])
		//	//fmt.Println("merge ", d.key[0], d.key[1])
		//	ans+=d.val
		//	cnt++
		//} else if in[d.key[0]] && !in[d.key[1]] {
		//	//第二个点不在集合里
		//	in[d.key[1]] = true
		//	fa[d.key[1]] = find(d.key[0])
		//	ans += d.val
		//	//fmt.Println(d.key[1])
		//	cnt++
		//} else if !in[d.key[0]] && in[d.key[1]] {
		//	//第一个点不在集合里
		//	in[d.key[0]] = true
		//	fa[d.key[0]] = find(d.key[1])
		//	ans += d.val
		//	//fmt.Println(d.key[0])
		//	cnt++
		//} else {
		//	//两个点都不在集合里
		//	in[d.key[0]] = true
		//	in[d.key[1]] = true
		//	union(d.key[0], d.key[1])
		//	ans += d.val
		//	cnt++
		//	//fmt.Println(d.key[0])
		//	//fmt.Println(d.key[1])
		//}
		if cnt == len(points)+1 {
			break
		}
	}
	return ans
}
func main() {
	points := [][]int{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}
	points = [][]int{{3, 12}, {-2, 5}, {-4, 1}}
	points = [][]int{{2, -3}, {-17, -8}, {13, 8}, {-17, -15}}
	points = [][]int{{5, 8}, {18, -6}, {-18, 13}, {-8, -13}, {-13, 3}, {-15, 2}, {-12, 17}, {14, 16}, {-4, 3}, {-17, -7}, {8, 9}, {17, 14}, {-13, 2}, {-3, -1}, {4, -20}}
	//points = [][]int{{11, -6}, {9, -19}, {16, -13}, {4, -9}, {20, 4}, {20, 7}, {-9, 18}, {10, -15}, {-15, 3}, {6, 6}}

	fmt.Println(minCostConnectPoints(points))
}
