package main

func findMaxAverage(nums []int, k int) float64 {
	sum:=0
	for _,num:=range nums[:k]{
		sum+=num
	}
	left:=0
	right:=k
	ans:=sum
	for ;right<len(nums) ;{
		sum-=nums[left]
		sum+=nums[right]
		if sum>ans{
			ans=sum
		}
		right++
		left++
	}
	f:=float64(ans)
	_k:=float64(k)
	return f/_k

}