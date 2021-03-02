from typing import List

#如果一个窗口里，大数在一个小数后面，则小数必不可能再加入到答案里了，可以直接清理掉
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        max_queue = []
        right = k - 1
        left=0
        n = len(nums)
        ans=[]

        #init the queue
        for i in range(k):
            if i == 0:
                max_queue.append(i)
            else:
                #把队列里比这个数小的全部弹出来，以满足该队列递减
                while len(max_queue) and nums[max_queue[-1]]<nums[i]:
                    max_queue.pop()
                max_queue.append(i)
            # print(max_queue)

        #加入第一个窗口的结果
        ans.append(nums[max_queue[0]])

        while right < n-1:
            right += 1
            left+=1
            #把队列中在左边界左边的删掉
            while len(max_queue) and max_queue[0]<left:
                max_queue.pop(0)
            # 把小于要添加的这个数的数从队尾取出
            while len(max_queue) and nums[max_queue[-1]] < nums[right]:
                max_queue.pop()
            max_queue.append(right)
            # print(max_queue)

            ans.append(nums[max_queue[0]])
        return ans

if __name__ == '__main__':
    # nums = [1, 3, -1, -3, 5, 3, 6, 7]
    # k = 3
    # nums=[7,2,4]
    # k=2
    # nums=[1]
    # k=1
    # nums=[1,-1]
    # k=1
    # nums=[4,-2]
    # k=2
    print(Solution().maxSlidingWindow(nums, k))
