//在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
//
// 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两
//个平台。假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
//
// 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？
//
//
//
// 示例 1:
//
//
//输入: [[0,2],[1,3]]
//输出: 3
//解释:
//时间为0时，你位于坐标方格的位置为 (0, 0)。
//此时你不能游向任意方向，因为四个相邻方向平台的高度都大于当前时间为 0 时的水位。
//
//等时间到达 3 时，你才可以游向平台 (1, 1). 因为此时的水位是 3，坐标方格中的平台没有比水位 3 更高的，所以你可以游向坐标方格中的任意位置
//
//
// 示例2:
//
//
//输入: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6
//]]
//输出: 16
//解释:
// 0  1  2  3  4
//24 23 22 21  5
//12 13 14 15 16
//11 17 18 19 20
//10  9  8  7  6
//
//最终的路线用加粗进行了标记。
//我们必须等到时间为 16，此时才能保证平台 (0, 0) 和 (4, 4) 是连通的
//
//
//
//
// 提示:
//
//
// 2 <= N <= 50.
// grid[i][j] 是 [0, ..., N*N - 1] 的排列。
//
// Related Topics 堆 深度优先搜索 并查集 二分查找
// 👍 129 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
package main

import (
	"fmt"
	"math"
	"sort"
)

func min(a int, b int) int {
	return int(math.Min(float64(a), float64(b)))
}
func max(a int, b int) int {
	return int(math.Max(float64(a), float64(b)))
}

type Edges [][3]int

func (e Edges) Len() int { return len(e) }

func (e Edges) Less(i, j int) bool { return e[i][2] < e[j][2] }

func (e Edges) Swap(i, j int) { e[i], e[j] = e[j], e[i] }

func swimInWater(grid [][]int) int {
	n := len(grid)
	m := len(grid[0])
	if n == m && n == 1 {
		return 0

	}
	fa := make([]int, n*m)
	edges := make(Edges, 0, 2*n)
	//node#i*n+j
	walk := [2][2]int{{1, 0}, {0, 1} }
	edgesExist := make(map[[2]int]bool)
	for i := range grid {
		for j := range grid[i] {
			num1 := i*m + j
			fa[num1] = num1
			for _, w := range walk {
				node1 := grid[i][j]
				num1 = i*m + j
				ni := i + w[0]
				nj := j + w[1]
				if ni < 0 || ni >= n || nj < 0 || nj >= m {
					continue
				}
				num2 := ni*m + nj
				num1, num2 = min(num1, num2), max(num1, num2)
				if edgesExist[[2]int{num1, num2}] {
					continue
				}
				edgesExist[[2]int{num1, num2}] = true
				node2 := grid[ni][nj]
				e := max(node1 , node2)
				edges = append(edges, [3]int{num1, num2, e})
			}
		}
	}
	for i := 0; i < n*m; i++ {
		fa[i] = i
	}
	fmt.Println(edges)
	fmt.Println(fa)

	var find func(int) int
	find = func(x int) int {
		if fa[x] == x {
			return x
		}
		fa[x] = find(fa[x])
		return fa[x]
	}
	union := func(x, y int) {
		xfa := find(x)
		yfa := find(y)
		fa[yfa] = xfa
	}
	sort.Sort(edges)
	for _, e := range edges {
		fmt.Println(e)
		if find(e[0]) != find(e[1]) {
			union(e[0], e[1])
		}

		if find(0) == find(n*m-1) {
			return e[2]
		}
	}
	return -1
}

//leetcode submit region end(Prohibit modification and deletion)
