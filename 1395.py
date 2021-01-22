'''
Author: chivalryq
Date: 2020-10-24 09:28:07
Description: file content
'''

class Solution(object):
    def numTeams(self, rating):
        """
        :type rating: List[int]
        :rtype: int
        """
        res=0
        n=len(rating)
        def is_valid(l):
            return rating[l[0]]<rating[l[1]]<rating[l[2]] or rating[l[0]]>rating[l[1]]>rating[l[2]]
        
        selected=[False for _ in range(len(rating))]

        def dfs(this_one,total_selected,res):
            
            selected[this_one]=True
            
            if total_selected==3:
                l=[x for x in range(n) if selected[x]]
                if is_valid(l):
                    res+=1
            else:
                for next_one in range(this_one+1,n):
                    res=dfs(next_one,total_selected+1,res)
            selected[this_one]=False
            return res
        
        for i in range(n-2):
            res=dfs(i,1,res)
        
        return res

def main():
    rating= [2,5,3,4,1]
    print(Solution().numTeams(rating))

if __name__ == "__main__":
    main()