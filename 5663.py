from typing import List


class Solution:
    def kthLargestValue(self, matrix: List[List[int]], k: int) -> int:
        val=[[0 for _ in range(len(matrix[0]))]for _ in range(len(matrix))]
        ans=[]
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                val[i][j]^=matrix[i][j]
                if i-1>=0:
                    val[i][j]^=val[i-1][j]
                if j-1>=0:
                    val[i][j]^=val[i][j-1]
                    if i-1>=0 :
                        val[i][j]^=val[i-1][j-1]
                ans.append(val[i][j])
        ans.sort(reverse=True)
        return ans[k-1]


if __name__ == '__main__':
    matrix = [[5, 2], [1, 6]]
    k = 1
    matrix=[[8, 10, 5, 8, 5, 7, 6, 0, 1, 4, 10, 6, 4, 3, 6, 8, 7, 9, 4, 2]]
    k=2
    print(Solution().kthLargestValue(matrix,k))