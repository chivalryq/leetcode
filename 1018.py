from typing import List


class Solution:
    def prefixesDivBy5(self, A: List[int]) -> List[bool]:
        a=0
        ans=[False for _ in range(len(A))]
        for i,x in enumerate(A):
            a=a*2+x
            if a%5==0:
                ans[i]=True
            a=a%5
        return ans
if __name__ == '__main__':
    A=[0,1,1,1,1,1]
    A=[1,1,1,0,1]
    print(Solution().prefixesDivBy5(A))