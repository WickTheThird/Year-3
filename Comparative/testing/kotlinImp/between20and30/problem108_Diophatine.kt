//https://projecteuler.net/problem=108
//(21-30)

import kotlin.math.sqrt

class NumberAnalyzer {
    fun primeFactorsCount(n: Int): Map<Int, Int> {
        val factors = mutableMapOf<Int, Int>()
        var num = n
        for (p in 2..n) {
            while (num % p == 0) {
                num /= p
                factors[p] = factors.getOrDefault(p, 0) + 1
            }
            if (num == 1) {
                break
            }
        }
        return factors
    }

    fun countSolutions(targetSolutions: Int): Int {
        var n = 2
        while (true) {
            val factors = primeFactorsCount(n)
            var count = 1
            for (p in factors.values) {
                count *= 2 * p + 1
            }
            count = (count + 1) / 2

            if (count > targetSolutions) {
                return n
            }
            n++
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val numberAnalyzer = NumberAnalyzer()
            val targetSolutions = 1000
            val leastN = numberAnalyzer.countSolutions(targetSolutions)
            println(leastN)
        }
    }
}
