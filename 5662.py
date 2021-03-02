class Solution:
    def minCharacters(self, a: str, b: str) -> int:
        def str_to_dict(c):
            s = dict()
            for ch in c:
                if ch not in s.keys():
                    s[ch] = 1
                else:
                    s[ch] += 1
            return s

        def s1(a,b):
            #满足a的每个字母都严格小于b的每个字母的操作数
            a_dict=str_to_dict(a)
            b_dict=str_to_dict(b)
            c_dict=str_to_dict(a+b)
            res=123456789
            for ch,_ in c_dict.items():
                this_res=0
                #a全部小于等于ch，b全部大于ch
                if  ch<'z':
                    for a_ch,a_num in a_dict.items():
                        if a_ch>ch:
                            this_res+=a_num

                    for b_ch,b_num in b_dict.items():
                        if b_ch<=ch:
                            this_res+=b_num
                    res=min(this_res,res)

                if ch>'a':
                    another_res=0
                    for a_ch,a_num in a_dict.items():
                        if a_ch>=ch:
                            another_res+=a_num

                    for b_ch,b_num in b_dict.items():
                        if b_ch<ch:
                            another_res+=b_num
                    res=min(another_res,res)
            return res

        def s2(a,b):
            c=a+b
            s=str_to_dict(c)
            num=0
            for k,v in s.items():
                if v>num:
                    num=v
            return len(c)-num

        x,y,z=s1(a,b),s1(b,a),s2(a,b)
        print(x,y,z)
        return min(x,y,z)

if __name__ == '__main__':
    a = "dabadd"
    b = "cda"
    # a = "aba"
    # b = "caa"
    a="ace"
    b="abe"

    a="a"
    b="abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
    print(Solution().minCharacters(a,b))