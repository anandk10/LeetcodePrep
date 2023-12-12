class Solution {
    public int climbStairs(int n) {
        /**
        1,2,3,4,5
        O(0) = 0
        O(1) = max(1 + O(0), 1)
             = max(1 + 0, 1) = 1
        O(2) = max(1 + O(1), 1 + O(0))
             = max(1 + 1, 1 + 0) = 2
        O(3) = max(1 + O(2), 1 + O(1))
             = max(1 + 2, 1 + 1) = 3        
         */
        
        int first = 1;
        if (n == 1) { return first; }
        
        int second = 2;
        if (n == 2) { return second; }

        // 1 2 3 4 5
        // 1 2 3 5 8
        //.  f s
        for (int i = 3; i <= n ; i++) {

            // O(i) = max(1 + O(i-1), 1 + O(i-2))

            int temp = second;
            second = first + second;
            first = temp;
            // second = Math.max(1 + second, 1 + first);
            // first = temp;
            // System.out.printf("\n(%d) - [%d, %d]" , i, first, second);
        }
        return second;

    }
}