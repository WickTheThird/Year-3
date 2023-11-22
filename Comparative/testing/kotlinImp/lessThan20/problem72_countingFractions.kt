// https://projecteuler.net/problem=72
// (<20)

import kotlin.math.*

class CountingFractions {

    fun euler_phi(n: Long): Long {
        var newN = n
        var result = newN
        var p = 2L
        while (p * p <= newN) {
            if (newN % p == 0L) {
                while (newN % p == 0L) {
                    newN /= p
                }
                result -= result / p
            }
            p++
        }
        if (newN > 1) {
            result -= result / newN
        }
        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val countingFractions = CountingFractions()
            var count = 0L
            for (d in 2L..1000000L) {
                count += countingFractions.euler_phi(d)
            }
            println(count)
        }
    }
}
