class Solution:
    def mySqrt(self, x: int) -> int:
        exponent = 2
        left, right = 0, x + 1
        while (left < right):
            mid = left + (right - left) // 2
            if (pow(mid, exponent) > x):
                right = mid
            else:
                left = mid + 1
        return left - 1
