class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if not nums:
            return []
        n=len(nums)
        if n<3:
            return []
        nums = sorted(nums)
        res = []
        i=0
        while i<n:
            x=nums[i]
            if x>0:
                return res
            if i>0 and nums[i]==nums[i-1]:
                i+=1
                continue
            left = i+1
            right = len(nums) - 1
            while left < right:
                val = x + nums[left] + nums[right]
                if val > 0:
                    right -= 1
                elif val < 0:
                    left += 1
                else:
                    res.append([x,nums[left],nums[right]])
                    # l=nums[left]
                    # r=nums[right]
                    # while nums[left]==l:
                    #     left+=1
                    # while nums[right]==r:
                    #     right-=1
                    while left<right and nums[left]==nums[left+1]  :
                        left+=1
                    while  left<right and nums[right]==nums[right-1] :
                        right-=1
                    left+=1
                    right-=1
            i+=1
        return res


if __name__ == '__main__':
    nums=[-1,0,1,2,-1,-4,-2,-3,3,0,4]
    # nums=[0,0,0]
    print(Solution().threeSum(nums))