package main

import (
	"fmt"
	"math/big"
	"strings"
)

func pow(base, exp int64) *big.Int {
	result := big.NewInt(1)
	for i := int64(0); i < exp; i++ {
		result.Mul(result, big.NewInt(base))
	}
	return result
}

func calculateHexadecimalNumbers() string {
	totalCount := new(big.Int)
	for n := int64(1); n <= 16; n++ {
		term1 := new(big.Int).Mul(big.NewInt(15), pow(16, n-1))
		term2 := new(big.Int).Mul(big.NewInt(41), pow(14, n-1))
		term3 := new(big.Int).Mul(big.NewInt(43), pow(15, n-1))
		term4 := pow(13, n)

		totalCount.Add(totalCount, term1)
		totalCount.Add(totalCount, term2)
		totalCount.Sub(totalCount, term3)
		totalCount.Sub(totalCount, term4)
	}
	return totalCount.Text(16)
}

func main() {
	result := calculateHexadecimalNumbers()
	fmt.Println(strings.ToUpper(result))
}