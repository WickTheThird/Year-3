package main

import (
	"fmt"
	"math/big"
)

func calculateTotalSum() int {
	totalSum := 19
	for a := 1; a <= 100; a++ {
		sqrt := sqrtDigits(a, 100)
		sqrtStr := sqrt[1:102]
		for _, digit := range sqrtStr {
			if digit >= '0' && digit <= '9' {
				totalSum += int(digit - '0')
			}
		}
	}
	return totalSum
}

func sqrtDigits(n int, precision int) string {
	x := new(big.Float).SetPrec(uint(precision))
	x.SetInt64(int64(n))
	half := new(big.Float).SetFloat64(0.5)
	two := new(big.Float).SetInt64(2)
	for i := 0; i < 10000; i++ { // Keep the number of iterations the same
		x.Quo(x, two)
		x.Add(x, new(big.Float).Quo(new(big.Float).SetInt64(int64(n)), x))
		x.Mul(x, half)
	}
	return x.Text('f', 100)
}

func main() {
	totalSum := calculateTotalSum()
	fmt.Println(totalSum )
}
