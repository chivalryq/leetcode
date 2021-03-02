package main

import (
	"fmt"
	"strings"
)

func _isFlipedString(s1 string, s2 string) bool {
	if len(s1)!=len(s2){
		return false
	}
	if len(s1)==0{
		return true
	}
	for i:=0;i<len(s1);i++{
		s3:=s1[i:]+s1[:i]
		if s3==s2{
			return true
		}
	}
	return false
}
func isFlipedString(s1 string, s2 string) bool {
	if len(s2)==0{
		if len(s1)==0{
			return true
		}
		return false
	}
	s:=s1+s1
	return strings.Contains(s,s2)
}
func main() {
	s1 := "waterbottle"
	s2 := "erbottlewat"
	s2=""
	fmt.Println(isFlipedString(s1,s2))
}
