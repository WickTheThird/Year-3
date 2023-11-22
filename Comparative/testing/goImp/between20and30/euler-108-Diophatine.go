package main

import "fmt"

func primeFactorsCount(n int) map[int]int {
	factors := make(map[int]int)
	num := n

	for p := 2; p <= n; p++ {
		for num%p == 0 {
			num /= p
			factors[p] = factors[p] + 1
		}
		if num == 1 {
			break
		}
	}
	return factors
}

func countSolutions(targetSolutions int) int {
	n := 2
	for {
		factors := primeFactorsCount(n)
		count := 1
		for _, p := range factors {
			count *= 2*p + 1
		}
		count = (count + 1) / 2

		if count > targetSolutions {
			return n
		}
		n++
	}
}

func main() {
	targetSolutions := 1000
	leastN := countSolutions(targetSolutions)
	fmt.Println(leastN)
}
