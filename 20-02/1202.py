from typing import List


class Solution:
    def smallestStringWithSwaps(self, s: str, pairs: List[List[int]]) -> str:
        par=[i for i in range(len(s))]
        def find(x):
            if par[x]!=x:
                par[x]=find(par[x])
            return par[x]
        for l,r in pairs:
            lpar,rpar=find(l),find(r)
            if lpar!=rpar
                par[l]=rpar
