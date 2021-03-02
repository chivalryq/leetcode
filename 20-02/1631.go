////你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row,
//// col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你
////每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
////
//// 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
////
//// 请你返回从左上角走到右下角的最小 体力消耗值 。
////
////
////
//// 示例 1：
////
////
////
////
////输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
////输出：2
////解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
////这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
////
////
//// 示例 2：
////
////
////
////
////输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
////输出：1
////解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
////
////
//// 示例 3：
////
////
////输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
////输出：0
////解释：上图所示路径不需要消耗任何体力。
////
////
////
////
//// 提示：
////
////
//// rows == heights.length
//// columns == heights[i].length
//// 1 <= rows, columns <= 100
//// 1 <= heights[i][j] <= 106
////
//// Related Topics 深度优先搜索 并查集 图 二分查找
//// 👍 84 👎 0
//
package main
//
//import (
//	"fmt"
//	"math"
//	"sort"
//)
//
////leetcode submit region begin(Prohibit modification and deletion)
//func min(a int, b int) int {
//	return int(math.Min(float64(a), float64(b)))
//}
//func max(a int, b int) int {
//	return int(math.Max(float64(a), float64(b)))
//}
//func abs(a int) int {
//	return int(math.Abs(float64(a)))
//}
//
//type Edges [][3]int
//
//func (e Edges) Len() int {return len(e) }
//
//func (e Edges) Less(i, j int) bool {return e[i][2] < e[j][2] }
//
//func (e Edges) Swap(i, j int) { e[i], e[j] = e[j], e[i]}
//
//func minimumEffortPath(heights [][]int) int {
//	n := len(heights)
//	m := len(heights[0])
//	if n == m && n == 1 {
//		return 0
//
//	}
//	fa := make([]int, n*m)
//	edges := make(Edges, 0, 2*n)
//	//node#i*n+j
//	walk := [4][2]int{{1, 0}, {0, 1}, {0, -1}, {-1, 0}}
//	edgesExist := make(map[[2]int]bool)
//	for i := range heights {
//		for j := range heights[i] {
//
//			num1 := i*m + j
//			fa[num1] = num1
//			for _, w := range walk {
//				node1 := heights[i][j]
//				num1 = i*m + j
//				ni := i + w[0]
//				nj := j + w[1]
//				if ni < 0 || ni >= n || nj < 0 || nj >= m {
//					continue
//				}
//				num2 := ni*m + nj
//				num1, num2 = min(num1, num2), max(num1, num2)
//				if edgesExist[[2]int{num1, num2}] {
//					continue
//				}
//				edgesExist[[2]int{num1, num2}] = true
//				node2 := heights[ni][nj]
//				e := abs(node1 - node2)
//				edges = append(edges, [3]int{num1, num2, e})
//			}
//		}
//	}
//	for i:=0;i<n*m;i++{
//		fa[i]=i
//	}
//	fmt.Println(edges)
//	fmt.Println(fa)
//
//	var find func(int) int
//	find = func(x int) int {
//		if fa[x] == x {
//			return x
//		}
//		fa[x] = find(fa[x])
//		return fa[x]
//	}
//	union := func(x, y int) {
//		xfa := find(x)
//		yfa := find(y)
//		fa[yfa] = xfa
//	}
//	sort.Sort(edges)
//	for _, e := range edges {
//		fmt.Println(e)
//		if find(e[0]) != find(e[1]) {
//			union(e[0], e[1])
//		}
//		if find(0) == find(n*m-1) {
//			return e[2]
//		}
//	}
//	return -1
//}
//
////leetcode submit region end(Prohibit modification and deletion)
//
////func main() {
////
////	height := [][]int{{1, 10, 6, 7, 9, 10, 4, 9}}
////	//height = [][]int{{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}}
////	//height = [][]int{{3}}
////	//height=[][]int{{4,3,4,10,5,5,9,2},{10,8,2,10,9,7,5,6},{5,8,10,10,10,7,4,2},{5,1,3,1,1,3,1,9},{6,4,10,6,10,9,4,6}}
////	fmt.Println(minimumEffortPath(height))
////}
