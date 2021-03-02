package main

import "fmt"

func numEquivDominoPairs(dominoes [][]int) int {
	count:=make([][]int,10)
	for i:=range count{
		count[i]=make([]int,10)
	}
	var ans int
	for _,a :=range dominoes{
		if a[1]>a[0] {
			a[0],a[1]=a[1],a[0]
		}
		count[a[0]][a[1]]+=1
	}
	for _,c:=range count{
		for _,i:=range c{
			ans+=(i-1)*i/2
		}
	}
	return ans
}
func main() {
	dominoes := [][]int{{1,2},{2,1},{3,4},{5,6}}
	fmt.Println(numEquivDominoPairs(dominoes))

}
