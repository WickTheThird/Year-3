package main
import "fmt"

func find_num_combinations(n int) int {
	nums := make([]int, n+1)
	for i := range nums {
		nums[i] = 0
	}
	
	nums[0] = 1
	nums[1] = 1
	nums[2] = 2
	nums[3] = 4

	for i := 4; i <= n; i++ {
		nums[i] = nums[i-1] + nums[i-2] + nums[i-3] + nums[i-4]
	}
	return nums[n]
}

func main(){
	fmt.Println(find_num_combinations(50))
}