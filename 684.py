from typing import List


class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        con = []
        ans = None
        for i, edge in enumerate(edges):
            e1, e2 = edge
            c1 = None
            c2 = None
            for i1, c in enumerate(con):
                if e1 in c:
                    c1 = i1
            for i2, c in enumerate(con):
                if e2 in c:
                    c2 = i2
            if c1 is None and c2 is None:
                con.append({e1, e2})
                continue
            if c1 is not None and c2 is not None:
                if c1 == c2:
                    ans = [e1, e2]
                else:
                    con[c1] = con[c1].union(con[c2])
                    del con[c2]
                continue
            if  c1 is not None:
                con[c1].add(e2)
                continue
            if c2 is not None:
                con[c2].add(e1)
                continue

        return sorted(ans)


if __name__ == '__main__':
    edges = [[3, 4], [1, 2], [2, 4], [3, 5], [2, 5]]
    edges = [[1, 3], [3, 4], [1, 5], [3, 5], [2, 3]]
    print(Solution().findRedundantConnection(edges))
