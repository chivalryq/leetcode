package main

import "fmt"

func countHomogenous(s string) int {
	var first int32
	first= int32(s[0])
	firstIndex :=0
	numCount :=make([]int,0,100)
	for i, ch := range s {
		if ch!=first{
			numCount = append(numCount, i-firstIndex)
			first=ch
			firstIndex =i
		}
	}
	numCount = append(numCount, len(s)-firstIndex)
	max:=numCount[0]
	for _,num:=range numCount{
		if max<num{
			max=num
		}
	}
	fact:=make([]int,max+1,max+1)
	fact[0]=0//0!=1
	i:=1
	for ;i<=max;i++{
		fact[i]=fact[i-1]+i
	}
	//fmt.Println(fact)
	ans:=0
	x:=10*10*10*10*10*10*10*10*10+7
	for _,num:=range numCount{
		ans+=fact[num]
		ans%=x
	}
	return ans
}

func main() {
	s:="aabbcc"
	s="aaab"
	//s="aaaa"
	fmt.Println(countHomogenous(s))
}