class Solution:
    def countBalls(self, lowLimit: int, highLimit: int) -> int:
        d=dict()
        for i in range(lowLimit,highLimit+1):
            sum=0
            s_i=str(i)
            for ch in s_i:
                sum+=int(ch)

            if sum not in d.keys():
                d[sum]=1
            else:
                d[sum]+=1

        ans: int=-1
        for v in d.values():
            if v>ans:
                ans=v    
                
        return ans