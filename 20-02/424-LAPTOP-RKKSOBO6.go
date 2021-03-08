package main

import "fmt"

func characterReplacement(s string, k int) int {
	if k >= len(s) {
		return len(s)
	}
	slen := len(s)
	count := make(map[uint8]int)
	//区间为[l,r]
	l := 0
	r := 0
	maxCnt := 1
	count[s[l]] += 1
	var i = 0
	for i = 0; i < k; {
		//i为替换次数
		r += 1
		if r == slen {
			break
		}
		count[s[r]] += 1
		if count[s[r]] > maxCnt {

			maxCnt = count[s[r]]
		}
		i = (r - l + 1) - maxCnt
	}
	if r == slen {
		return maxCnt + i
	}
	usek := k

	count[s[r]]--
	for ; r < slen; r++ {
		count[s[r]]++
		if count[s[r]] > maxCnt {
			maxCnt = count[s[r]]
		}
		usek = r - l + 1 - maxCnt
		if usek > k {
			count[s[l]]--
			l++
			usek = k
		}
	}
	return maxCnt + k
}

func main() {
	s := "ABCAAADDEEEEE"
	s = "ABAB"
	s = "AABABBA"
	s = "AAAA"
	k := 2
	fmt.Println(characterReplacement(s, k))
}
