from typing import List


class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        fa=[i for i in range(len(isConnected))]
        def find(x):
            if fa[x]==x:
                return x
            else:
                fa[x]=find(fa[x])
        def merge(x,y):
            tmp=fa[x]
            fa[x]=fa[y]
            for i,x in enumerate(fa):
                if x==tmp:
                    fa[i]=fa[y]
        for i in range(len(isConnected)):
            for j in range(i+1):
                if isConnected[i][j]:
                    merge(i,j)

        # print(fa)
        return len(set(fa))


if __name__ == '__main__':
    isConnected = [[1, 1, 0], [1, 1, 0], [0, 0, 1]]
    isConnected=[[1, 0, 0], [0, 1, 0], [0, 0, 1]]
    isConnected= [[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
    Solution().findCircleNum(isConnected)