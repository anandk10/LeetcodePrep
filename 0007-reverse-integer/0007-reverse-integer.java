class Solution {
    public int reverse(int x) {
        /**
        quo = abc(num)
        res = 0
        quo > 0
            rem = quo % 10
            quo = quo / 10
            int_max / 10 >= res 
                return 0
            res = res * 10 + rem
         */

        int quo = Math.abs(x);
        int res = 0;
        while (quo > 0) {
            int rem = quo % 10;
            // 2147483641 --- maximum this number fits in int
            // 214748364 <= 214748364 && 1 > 7
            // System.out.println(res);
            if (Integer.MAX_VALUE / 10 < res && res % 10 < 7) {
                return 0;
            }

            res = res * 10 + rem;
            quo = quo / 10;
        }

        if (x < 0) 
            res = -res;
        return res;
    }
}