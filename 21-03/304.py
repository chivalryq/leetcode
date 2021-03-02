from typing import List


class NumMatrix:

    def __init__(self, matrix: List[List[int]]):

        self.sum = [[0 for __ in range(len(matrix[0]))] for _ in range(len(matrix))]
        if len(self.sum)==0:
            return
        self.sum[0][0] = matrix[0][0]
        for i in range(1, len(matrix)):
            self.sum[i][0] = self.sum[i - 1][0] + matrix[i][0]
        for i in range(1, len(matrix[0])):
            self.sum[0][i] = self.sum[0][i - 1] + matrix[0][i]
        for i in range(1, len(matrix)):
            for j in range(1, len(matrix[0])):
                self.sum[i][j] = self.sum[i - 1][j] + self.sum[i][j - 1] - self.sum[i - 1][j - 1] + matrix[i][j]
        print(self.sum)

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        if len(self.sum)==0:
            return 0
        ans = self.sum[row2][col2]
        if row1 > 0:
            ans -= self.sum[row1 - 1][col2]
        if col1 > 0:
            ans -= self.sum[row2][col1 - 1]
        if row1 > 0 and col1 > 0:
            ans += self.sum[row1 - 1][col1 - 1]
        return ans


# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)
if __name__ == '__main__':
    matrix = [[3, 0, 1, 4, 2],
              [5, 6, 3, 2, 1],
              [1, 2, 0, 1, 5],
              [4, 1, 0, 1, 7],
              [1, 0, 3, 0, 5]]
    obj = NumMatrix(matrix)
    print(obj.sumRegion(0, 0, 1, 1))
    print(obj.sumRegion(1, 0, 1, 1))
    print(obj.sumRegion(1, 1, 1, 1))
