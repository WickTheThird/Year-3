// https://projecteuler.net/problem=384
// (65%)

import kotlin.math.*

class Counter {
    fun count(n: Long, x: Int): Long {
        var ret: Long = 0
        var start: Long = 0
        var now: Long = 0
        var xNew = x

        for (hi in 62 downTo -1) {
            if ((n shr hi) and 1L != 0L) {
                if (now and 1L != 0L) {
                    start = -start
                    xNew = -xNew
                }

                var mid = start
                val dff: Long = 1L shl ((hi + 1) shr 1)

                if (hi and 1 != 0) {
                    val d = xNew - start
                    if (d < dff) {
                        ret += maxOf(d, 0)
                    } else if (d == dff) {
                        ret += dff / 2
                    }
                    start += dff
                } else {
                    mid += dff
                    ret += maxOf(0, dff - abs(mid - xNew))
                    start = mid
                }

                if (now and 1L != 0L) {
                    start = -start
                    xNew = -xNew
                }

                now += if ((n shr hi.toInt()) % 4L == 3L) 1 else 0
            }
        }

        return ret
    }

    fun pos(x: Int, y: Int): Long {
        var L: Long = 1
        var R: Long = (1L shl 62) - 1
        while (L < R) {
            val m = (L + R) / 2
            if (count(m, x) >= y) {
                R = m
            } else {
                L = m + 1
            }
        }
        return L
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val counter = Counter()
            var a = 1
            var b = 2
            var ans: Long = 0

            for (i in 2 until 46) {
                val t = counter.pos(b, a)
                ans += t - 1
                val c = b + a
                a = b
                b = c
            }

            println(ans)
        }
    }
}
