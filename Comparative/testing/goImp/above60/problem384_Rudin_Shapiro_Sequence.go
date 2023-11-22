// https://projecteuler.net/problem=384
// (65%)

package main

import (
	"fmt"
)

func count(n, x int64) int64 {
	ret := int64(0)
	start := int64(0)
	now := int64(0)

	for hi := 62; hi >= 0; hi-- {
		if (n >> hi) & 1 != 0 {
			if now & 1 != 0 {
				start = -start
				x = -x
			}

			mid := start
			dff := int64(1 << ((hi + 1) >> 1))

			if hi & 1 != 0 {
				d := x - start
				if d < dff {
					ret += max(d, 0)
				} else if d == dff {
					ret += dff / 2
				}
				start += dff
			} else {
				mid += dff
				ret += max(0, dff - abs(mid - x))
				start = mid
			}

			if now & 1 != 0 {
				start = -start
				x = -x
			}

			if (n >> hi) % 4 == 3 {
				now++
			}
		}
	}

	return ret
}

func pos(x, y int64) int64 {
	L, R := int64(1), int64(1 << 62 - 1)
	for L < R {
		m := (L + R) / 2
		if count(m, x) >= y {
			R = m
		} else {
			L = m + 1
		}
	}
	return L
}

func max(a, b int64) int64 {
	if a > b {
		return a
	}
	return b
}

func abs(a int64) int64 {
	if a < 0 {
		return -a
	}
	return a
}

func main() {
	a, b := int64(1), int64(2)
	ans := int64(0)

	for i := 2; i < 46; i++ {
		t := pos(b, a)
		// fmt.Println(t, count(t, b), a)
		ans += t - 1
		c := b + a
		a, b = b, c
	}

	fmt.Println(ans)
	// fmt.Println(count(1220847711, 54321), pos(54321, 12345) - 1)
}
