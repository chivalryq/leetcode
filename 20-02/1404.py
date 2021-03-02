class Solution(object):
    def numSteps(self, s):
        """
        :type s: str
        :rtype: int
        """
        a=int(s,2)
        step=0
        while a!=1:
            if not a%2:
                a/=2
            else:
                a+=1
            step+=1
        return step

if __name__ == '__main__':
    s='1101'
    print(Solution().numSteps(s))
