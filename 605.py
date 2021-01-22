from typing import List


class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        s=0
        l=len(flowerbed)
        for i in range(len(flowerbed)):
            if i==0:
                if l==1:
                    con=not flowerbed[i]
                else:
                    con=not  flowerbed[i] and not flowerbed[i+1]
                if con:
                    flowerbed[i]=1
                    s+=1
            if 0 < i < len(flowerbed)-1:
                if not flowerbed[i - 1] and not flowerbed[i + 1] and not flowerbed[i]:
                    flowerbed[i]=1
                    s+=1
            if i == len(flowerbed)-1:
                if not flowerbed[i] and not flowerbed[i - 1]:
                    s += 1
        return n<=s


if __name__ == '__main__':
    flowerbed = [1, 0, 0, 0, 1]
    flowerbed=[0]
    n = 1
    print(Solution().canPlaceFlowers(flowerbed,n))



