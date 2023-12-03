import scala.math._
object Solution {
    def mySqrt(x: Int): Int = {
        if(x < 2) {
            return x;
        }

        var left = 0
        var right = x // can cause overflow for Int.MaxValue
        println(right)
        var exponent = 2
        while (left < right) {
            var mid = left + (right - left) / 2
            if (pow(mid, exponent) > x) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        left - 1
    }
}
