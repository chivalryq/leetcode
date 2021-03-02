from typing import List


class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x:x[1])
        n=len(intervals)
        ptr=0
        ans=0
        while ptr<n:
            end=intervals[ptr][1]
            for i in range(ptr+1,n):
                if intervals[i][0]<end:
                    ans+=1
                    ptr=i-1
                else:
                    ptr=i-1
                    break
            ptr+=1
        return ans






if __name__ == '__main__':
    intervals=[[1, 2], [1, 2], [1, 2] ]
    print(Solution().eraseOverlapIntervals(intervals))