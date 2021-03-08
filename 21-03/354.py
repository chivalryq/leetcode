from typing import List


class Solution:
    def canPut(self, a, b):
        return a[0] < b[0] and a[1] < b[1]

    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key=lambda x: (x[0], x[1]))
        print(envelopes)
        ans = 1
        dp = [1]
        for i, env in enumerate(envelopes):
            if i == 0:
                continue
            j = i - 1
            num_j = 1
            while j >= 0:
                if self.canPut(envelopes[j], env):
                    num_j = dp[j] + 1 if dp[j] + 1 > num_j else num_j
                j -= 1
            dp.append(num_j)
            if dp[-1] > ans:
                ans = dp[-1]

        return ans


if __name__ == '__main__':
    envelopes = [[5, 4], [6, 4], [6, 7], [2, 3]]
    envelopes = [[46, 89], [50, 53], [52, 68], [72, 45], [77, 81]]
    print(Solution().maxEnvelopes(envelopes))
