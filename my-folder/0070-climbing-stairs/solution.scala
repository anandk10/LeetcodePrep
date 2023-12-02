object Solution {
    def climbStairs(n: Int): Int = {
        var first = 1;
        if (n==1) {
            return first;
        }

        var second = 2;
        if (n==2) {
            return second;
        }

        for (i <- 3 to n) {
            var temp = second;
            second = first + second;
            first = temp;
        }

        second
        
    }
}
