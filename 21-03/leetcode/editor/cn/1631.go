//你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row,
// col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你
//每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
//
// 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
//
// 请你返回从左上角走到右下角的最小 体力消耗值 。
//
//
//
// 示例 1：
//
//
//
//
//输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
//输出：2
//解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
//这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
//
//
// 示例 2：
//
//
//
//
//输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
//输出：1
//解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
//
//
// 示例 3：
//
//
//输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
//输出：0
//解释：上图所示路径不需要消耗任何体力。
//
//
//
//
// 提示：
//
//
// rows == heights.length
// columns == heights[i].length
// 1 <= rows, columns <= 100
// 1 <= heights[i][j] <= 106
//
// Related Topics 深度优先搜索 并查集 图 二分查找
// 👍 84 👎 0

package main

import (
	"fmt"
	"math"
)

//leetcode submit region begin(Prohibit modification and deletion)
func minimumEffortPath(heights [][]int) int {
	dp := make([][]float64, len(heights))
	for i := range dp {
		dp[i] = make([]float64, len(heights[0]))
	}
	dp[0][0] = 0
	for i := range dp {
		for j := range dp[i] {
			if i == 0 && j == 0 {
				continue
			}
			nFromTop := float64(123456789)
			nFromLeft := float64(123456789)
			if i-1 >= 0 {
				nFromTop = math.Max(dp[i-1][j], math.Abs(float64(heights[i-1][j]-heights[i][j])))
			}
			if j-1 >= 0 {
				nFromLeft = math.Max(dp[i][j-1], math.Abs(float64(heights[i][j-1]-heights[i][j])))
			}
			dp[i][j] = math.Min(nFromTop, nFromLeft)
		}
	}
	return int(dp[len(heights)-1][len(heights[0])-1])
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {

	height := [][]int{{1, 10, 6, 7, 9, 10, 4, 9}}
	height = [][]int{{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}}
	fmt.Println(minimumEffortPath(height))
}
