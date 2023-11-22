// https://projecteuler.net/problem=117
// (35%)

import java.text.DecimalFormat

class NumCombinations {

    fun findNumCombinations(n: Int): Double {
        val nums = DoubleArray(n + 1)
        nums[0] = 1.0
        nums[1] = 1.0
        nums[2] = 2.0
        nums[3] = 4.0

        for (i in 4..n) {
            nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3] + nums[i - 4]
        }

        return nums[n]
    }

    fun formatResult(result: Double): String {
        val df = DecimalFormat("0")
        return df.format(result)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val c = NumCombinations()
            println(c.formatResult(c.findNumCombinations(50)))
        }
    }
}
