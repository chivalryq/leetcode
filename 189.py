from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        def flip(nums):
            for i in range(len(nums)//2):
                nums[i],nums[len(nums)-1-i]=nums[len(nums)-1-i],nums[i]
            return nums

        k = k % len(nums)
        flip(nums)
        nums[k:]=flip(nums[k:])
        nums[:k]=flip(nums[:k])
        print(nums)

if __name__ == '__main__':
    # nums=[1, 2, 3, 4, 5, 6, 7]
    nums=[1,2]
    k = 3
    Solution().rotate(nums,k)