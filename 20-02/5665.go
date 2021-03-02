package main

import "fmt"

func restoreArray(adjacentPairs [][]int) []int {
	edge:=make(map[int][]int)
	index:=make(map[int][]int)
	for i,ad:=range adjacentPairs{
		edge[ad[0]] = append(edge[ad[0]], ad[1])
		edge[ad[1]] = append(edge[ad[1]], ad[0])
		index[ad[0]] = append(index[ad[0]], i)
		index[ad[1]] = append(index[ad[1]], i)
	}
	var starter int
	for e:=range edge{
		if len(edge[e])==1{
			starter=e
			break
		}
	}
	startI :=index[starter][0]
	nums:=make([]int,0,len(adjacentPairs)+1)
	start_bundle:=adjacentPairs[startI]
	nums = append(nums,starter )
	if start_bundle[0]!=starter{
		nums = append(nums, start_bundle[0])
	}else{
		nums = append(nums, start_bundle[1])
	}
	next:=nums[1]
	for i,e:=range edge[next]{
		if e==starter{
			edge[next] = append(edge[next][:i], edge[next][i+1:]...)
		}
	}
	fmt.Println(edge)
	for ;len(nums)!=len(adjacentPairs)+1; {
		nums = append(nums, edge[next][0])
		tmp:=edge[next][0]
		edge[next] = append(edge[next][:0], edge[next][1:]...)
		for i,e:=range edge[tmp]{
			if e==next{
				edge[tmp] = append(edge[tmp][:i], edge[tmp][i+1:]...)
			}
		}
		next=tmp
	}
	return nums
}

func main() {
	nums:=[][]int{{4,-2},{1,4},{-3,1}}
	fmt.Println(restoreArray(nums))
}
