class Solution:
    def maximumTime(self, time: str) -> str:
        t=[]
        for i in time:
            t.append(i)
        if t[0]=='?':
            if t[1]=='?':
                t[0]='2'
                t[1]='3'
            elif int(t[1])>=4:
                t[0]='1'
            else:
                t[0]='2'
        if t[1]=='?':
            if int(t[0])==2:
                t[1]='3'
            else:
                t[1]='9'

        if t[3]=='?':
            t[3]='5'
        if t[4]=='?':
            t[4]='9'

        return ''.join(t)

if __name__ == '__main__':
    time = "2?:?0"
    time = "0?:3?"
    time = "1?:22"
    time='??:??'
    time='?4:??'
    print(Solution().maximumTime(time))