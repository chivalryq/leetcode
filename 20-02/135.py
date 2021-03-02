class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        n = len(ratings)
        if not n:
            return 0
        candy = [1 for _ in range(n)]
        i = 0
        while i < n:
            if i - 1 >= 0 and ratings[i - 1] < ratings[i]:
                candy[i] = max(candy[i], candy[i - 1] + 1)
            # if i + 1 < n and ratings[i + 1] < ratings[i]:
            #     candy[i] = max(candy[i], candy[i + 1] + 1)
            i+=1
        i=n-1
        while i>=0:
            # if i - 1 >= 0 and ratings[i - 1] < ratings[i]:
            #     candy[i] = max(candy[i], candy[i - 1] + 1)
            if i + 1 < n and ratings[i + 1] < ratings[i]:
                candy[i] = max(candy[i], candy[i + 1] + 1)
            i-=1
        return sum(candy)

if __name__ == '__main__':
    ratings=[1,2,2]
    print(Solution().candy(ratings))
