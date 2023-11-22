// https://projecteuler.net/problem=162
// 40 - 60

class HexadecimalCalculator {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val c = HexadecimalCalculator()
            val result = c.calculateHexadecimalNumbers()
            println(result)
        }
    }

    fun calculateHexadecimalNumbers(): String {
        var total_count: Long = 0
        for (n in 1..16) {
            total_count += 15 * power(16, n - 1) + 41 * power(14, n - 1) - (43 * power(15, n - 1) + power(13, n))
        }
        return java.lang.Long.toHexString(total_count).uppercase()
    }

    fun power(base: Int, exponent: Int): Long {
        var result: Long = 1
        for (i in 0 until exponent) {
            result *= base
        }
        return result
    }
}
