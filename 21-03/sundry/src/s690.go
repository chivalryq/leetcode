package main

import "fmt"

type Employee struct {
	Id           int
	Importance   int
	Subordinates []int
}

func main() {
	employees := []*Employee{
		{
			Id:           2,
			Importance:   3,
			Subordinates: []int{},
		},
		//{
		//	Id:           2,
		//	Importance:   3,
		//	Subordinates: []int{},
		//},
	}
	fmt.Println(getImportance(employees, 2))
}
func getImportance(employees []*Employee, id int) int {
	idIndexMap := make(map[int]int)
	for i, employee := range employees {
		idIndexMap[employee.Id] = i
	}
	//save idx
	list := make([]int, 0)
	list = append(list, idIndexMap[id])
	var ans int
	for len(list) != 0 {
		boss := employees[list[0]]
		fmt.Println(boss)
		list = list[1:]
		ans += boss.Importance
		sub := boss.Subordinates
		for _, id := range sub {
			fmt.Println(id)
			list = append(list, idIndexMap[id])
		}
	}
	return ans
}
