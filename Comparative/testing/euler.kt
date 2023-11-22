//https://projecteuler.net/problem=699
//https://saracogluahmet.wordpress.com/2020/04/27/triffle-numbers/
// (80%)

import kotlin.math.sqrt

class Euler() {

    fun findFactors(num: Int): MutableList<Int> {
        val factors = mutableListOf<Int>()

        if (num < 1)
            return factors

        val sqrtNum = sqrt(num.toDouble()).toInt()
        for (i in 1..sqrtNum) {
            if (num % i == 0) {
                factors.add(i)
                factors.add(num / i)
            }
        }

        return factors
    }

    fun simplifyFraction(num: Int, den: Int): Pair<Int, Int> {
        val gcd = gcd(num, den)
        val simplifiedNum = num / gcd
        val simplifiedDen = den / gcd
        return Pair(simplifiedNum, simplifiedDen)
    }

    fun gcd(a: Int, b: Int): Int {
        var num1 = a
        var num2 = b

        if (num1 == 0) return num2
        if (num2 == 0) return num1

        var shift = 0
        while (((num1 or num2) and 1) == 0) {
            num1 = num1 shr 1
            num2 = num2 shr 1
            shift++
        }

        while ((num1 and 1) == 0) {
            num1 = num1 shr 1
        }

        do {
            while ((num2 and 1) == 0) {
                num2 = num2 shr 1
            }

            if (num1 > num2) {
                val temp = num1
                num1 = num2
                num2 = temp
            }

            num2 -= num1
        } while (num2 != 0)

        return num1 shl shift
    }

    fun isDomPowOfThree(num: Int): Boolean {
        var n = num

        if (n <= 1) {
            return false
        }

        while (n % 3 == 0) {
            n /= 3
        }

        return n == 1
    }
}

fun main() {
    val euler = Euler()

    val T = 1000000
    var i = 1

    var sum = 0

    println("Entered the calculation")

    while (i <= T) {
        if (i % 3 == 0) {
            val numerator = euler.findFactors(i).sumOf { it }
            val lowDenom = euler.simplifyFraction(numerator, i).second

            if (euler.isDomPowOfThree(lowDenom)) {
                sum += i
            }
        }

        ++i
    }

    println(sum)
    //270 for 10^2
    // 26079486 for
}
