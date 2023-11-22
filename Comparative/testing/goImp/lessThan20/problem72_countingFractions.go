package main

import "fmt"

func eulerPhi(n int) int {
	result := n
	p := 2
	for p*p <= n {
		if n%p == 0 {
			for n%p == 0 {
				n /= p
			}
			result -= result / p
		}
		p++
	}
	if n > 1 {
		result -= result / n
	}
	return result
}

func main() {
	count := 0
	for d := 2; d <= 1000000; d++ {
		count += eulerPhi(d)
	}
	fmt.Println(count)
}
