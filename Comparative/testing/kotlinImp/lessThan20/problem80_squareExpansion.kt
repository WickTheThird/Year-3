// https://projecteuler.net/problem=80a
// (<20)

import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode
import kotlin.math.sqrt

class SquareRootCalculator {

    fun calculateTotalSum(): Int {
        var totalSum = 0
        for (a in 1..100) {
            val sqrt = sqrt(a.toDouble())
            if (sqrt != sqrt.toInt().toDouble()) {
                val sqrtDecimal = BigDecimal(a).sqrt(MathContext(102))
                val first100Digits = sqrtDecimal.toString().replace(".", "").substring(0, 100)
                val digitalSum = first100Digits.map { it.toString().toInt() }.sum()
                totalSum += digitalSum
            }
        }
        return totalSum
    }

    fun BigDecimal.sqrt(mathContext: MathContext): BigDecimal {
        var x = BigDecimal((sqrt(toDouble())), mathContext)
        if (scale() > 0) {
            val mc = MathContext(precision())
            var e = 0.5
            if (scale() > mc.precision) {
                x = x.setScale(scale(), RoundingMode.HALF_UP)
                e = 1.0
            }
            for (i in 0 until mc.precision) {
                x = x.subtract((x.pow(2).subtract(this, mc)).divide(x.multiply(BigDecimal(2.0), mc), mc))
                if (e >= 0.5 && x.subtract(x.setScale(0, RoundingMode.HALF_UP), mc).abs().compareTo(BigDecimal(e)) <= 0) break
                e /= 2.0
            }
        }
        return x
    }

    companion object {
    @JvmStatic
    fun main(args: Array<String>) {
        val calculator = SquareRootCalculator()
        println(calculator.calculateTotalSum())
    }
    }
}
