'''
Author: chivalryq
Date: 2020-10-24 10:59:41
Description: file content
'''

class Solution(object):
    def minInteger(self, num, k):
        """
        :type num: str
        :type k: int
        :rtype: str
        """
        l=len(num)
        num=list(num)
        first_idx=0
        for _ in range(k):
            while num[first_idx]<=num[first_idx+1] :
                first_idx+=1
                if first_idx==l-1:
                    return ''.join(num)

            t=num[first_idx+1]
            num[first_idx+1]=num[first_idx]
            num[first_idx]=t
                
            
        return ''.join(num)


def main():
    num='4321'
    k=4
    print(Solution().minInteger(num,k))

if __name__ == "__main__":
    main()
