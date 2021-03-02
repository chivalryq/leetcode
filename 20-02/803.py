from typing import List


class Solution:
    def hitBricks(self, grid: List[List[int]], hits: List[List[int]]) -> List[int]:
        max_line = len(grid)
        max_col = len(grid[0])
        WALL = -1
        copy_grid = []

        # 维护一个点作为根节点，这个联通部分的数目
        size = dict()
        size[(WALL, WALL)] = 0
        for l in range(max_line):
            for c in range(max_col):
                # 一开始他本身作为自己的根节点
                size[(l, c)] = 1
        for line in grid:
            copy_grid.append(line.copy())
        # print(copy_grid)
        # 先把有hit敲掉
        for hit in hits:
            copy_grid[hit[0]][hit[1]] = 0
        # print(copy_grid)
        # 初始化祖先数组
        fa = [[(j, i) for i in range(len(grid[0]))] for j in range(len(grid))]
        conn_to_wall = 0

        def find(pt):
            l, c = pt
            #由于-1的语义是从前往后，先判断是不是已经跟墙连接了
            if fa[l][c][0]==WALL:
                return WALL, WALL
            if fa[l][c] == (l, c):
                return pt
            else:
                fa[l][c] = find(fa[l][c])
                return fa[l][c]

        def union(pt1, pt2):
            if find(pt1) == find(pt2):
                return
            # 先找到他们的祖先
            l1, c1 = find(pt1)
            l2, c2 = find(pt2)
            # 首先保证能连到墙的作为祖先
            if l1 == -1:
                fa[l2][c2] = pt1
                size[(l1,c1)]+=size[(l2,c2)]
                return
            fa[l1][c1] = pt2
            size[(l2, c2)] += size[(l1, c1)]

        def get_size():
            return size[(WALL,WALL)]
        # 把最上面的节点都跟一个特殊节点相连
        for c, pt in enumerate(copy_grid[0]):
            if pt == 1:
                fa[0][c] = (WALL, WALL)
                conn_to_wall += 1
                size[(WALL, WALL)] += 1

        # 先把敲掉砖以后的fa数组填好
        walk = [(-1, 0), (0, -1), (1, 0), (0, 1)]
        for l, line in enumerate(copy_grid):
            for c, col in enumerate(line):
                if copy_grid[l][c] == 0:
                    continue
                for w in walk:
                    wl = l + w[0]
                    wc = c + w[1]
                    if 0 <= wl < max_line and 0 <= wc < max_col and copy_grid[wl][wc] == 1:
                        # 走在范围内且有砖在
                        union((l, c), (wl, wc))

        # print(fa)
        # print(size)
        # 把砖往上补
        ans=[]
        for hit in hits[::-1]:
            l,c=hit
            if grid[l][c]==0:
                ans.insert(0,0)
                continue
            origin=get_size()
            if hit[0]==0:
                #本来就在第一行，所以先把自己的fa设置为跟墙连接
                fa[hit[0]][hit[1]]=(WALL,WALL)
                size[(WALL,WALL)]+=1
            copy_grid[l][c]=1
            for w in walk:
                wl = l + w[0]
                wc = c + w[1]
                if 0 <= wl < max_line and 0 <= wc < max_col and copy_grid[wl][wc] == 1:
                    # 走在范围内且有砖在
                    union((l, c), (wl, wc))
            # print(size)
            current=get_size()
            ans.insert(0,max(0,current-origin-1))
        return ans
    # print(hit)


if __name__ == '__main__':
    grid = [[1, 0, 0, 0], [1, 1, 1, 0]]
    hits = [[1, 0]]

    # grid = [[1, 0, 0, 0], [1, 1, 0, 0]]
    # hits = [[1, 1], [1, 0]]

    # grid=[[1], [1], [1], [1], [1]]
    # hits=[[3, 0], [4, 0], [1, 0], [2, 0], [0, 0]]

    grid=[[1, 1, 1], [0, 1, 0], [0, 0, 0]]
    hits=[[0, 2], [2, 0], [0, 1], [1, 2]]
    print(Solution().hitBricks(grid, hits))
