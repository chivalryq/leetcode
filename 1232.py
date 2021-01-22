from typing import List


class Solution:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        if len(coordinates)==2:
            return True
        x1,y1=coordinates[0]
        x2,y2=coordinates[1]
        if x1==x2:
            for cor in coordinates:
                if cor[0]!=x1:
                    return False
            return True
        else:
            # y=ax+b
            a=(y2-y1)/(x2-x1)
            b=y2-a*x2
            for cor in coordinates:
                if cor[1]!=a*cor[0]+b:
                    return False
            return True

if __name__ == '__main__':
    coordinates = [[1, 1], [2, 2], [3, 4], [4, 5], [5, 6], [7, 7]]
    coordinates = [[1, 2], [2, 3], [3, 4], [4, 5], [5, 6], [6, 7]]
    print(Solution().checkStraightLine(coordinates))