from typing import List


class Solution:

    def get_next(self, query, value, want,d):

        if query == want:
            return value
        second_num = query[1]
        expect_val = -1
        if second_num not in d:
            return -1
        for t in d[second_num]:
            if t['vis']:
                continue
            t['vis'] = True
            new_value = value * t['val']
            new_query = [query[0], t['couple'][1]]
            expect_val = self.get_next(tuple(new_query), new_value, want,d)
            t['vis'] = False
            if expect_val == -1:
                continue
            return expect_val
        return expect_val

    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        d = {}
        all_set=[]
        for e in equations:
            all_set.append(e[0])
            all_set.append(e[1])

        for i, couple in enumerate(equations):
            start = couple[0]
            if start not in d:
                d[start] = [{
                    'couple': tuple(couple),
                    'val': values[i],
                    'vis': False
                }]
            else:
                d[start].append({'couple': tuple(couple), 'val': values[i], 'vis': False})
            end = couple[1]
            if end not in d:
                d[end] = [{
                    'couple': (couple[1], couple[0]),
                    'val': 1 / values[i],
                    'vis': False
                }]
            else:
                d[end].append({'couple': (couple[1], couple[0]), 'val': 1 / values[i], 'vis': False})

        ans = [-1 for _ in range(len(queries))]
        # print(d)
        for i, query in enumerate(queries):
            if query[0] not in all_set or query[1] not in all_set:
                continue
            print('searching'+str(query))
            if query[0] not in d:
                continue
            for t in d[query[0]]:
                t['vis'] = True
                res = self.get_next(tuple(t['couple']), t['val'], tuple(query),d)
                if res == -1:
                    continue
                ans[i] = res
                break
            self.clear(d)
        return ans

    def clear(self,d):
        for _d in iter(d):
            for c in d[_d]:
                c['vis'] = False


if __name__ == '__main__':
    equations = [["a", "b"], ["b", "c"]]
    # equations = [["a", "b"], ["b", "c"], ["bc", "cd"]]
    # equations = [["a", "b"]]

    values = [2.0, 3.0]
    # values = [1.5, 2.5, 5.0]
    # values = [0.5]
    queries = [["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"]]
    # queries = [["a", "c"], ["c", "b"], ["bc", "cd"], ["cd", "bc"]]
    # queries = [["a", "b"], ["b", "a"], ["a", "c"], ["x", "y"]]
    equations=[["a", "b"], ["a", "c"], ["a", "d"], ["a", "e"], ["a", "f"], ["a", "g"], ["a", "h"], ["a", "i"], ["a", "j"],
     ["a", "k"], ["a", "l"], ["a", "aa"], ["a", "aaa"], ["a", "aaaa"], ["a", "aaaaa"], ["a", "bb"], ["a", "bbb"],
     ["a", "ff"]]
    values=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 1.0, 1.0, 1.0, 1.0, 1.0, 3.0, 5.0]
    queries=[["d", "f"], ["e", "g"], ["e", "k"], ["h", "a"], ["aaa", "k"], ["aaa", "i"], ["aa", "e"], ["aaa", "aa"],
     ["aaa", "ff"], ["bbb", "bb"], ["bb", "h"], ["bb", "i"], ["bb", "k"], ["aaa", "k"], ["k", "l"], ["x", "k"],
     ["l", "ll"]]
    print(Solution().calcEquation(equations, values, queries))
