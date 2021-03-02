class Solution(object):
    def findBestValue(self, arr, target):
        """
        :type arr: List[int]
        :type target: int
        :rtype: int
        """
        arr.sort()
        s=0
        n=len(arr)
        for i in range(n):
            if s+arr[i]+(n-i-1)*arr[i]<target:
                s+=arr[i]
                continue
            else:
                min_diff=123456789
                # print("res in {} and {}".format(arr[i-1],arr[i]))
                for i in range(arr[i-1],arr[i]+1):



if __name__ == '__main__':
    arr=[4,3,9]
    target=10
    Solution().findBestValue(arr,target)