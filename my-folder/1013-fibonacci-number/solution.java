class Solution {
    public int fib(int n) {
        
        /**
        F(0) = 0, F(1) = 1
        F(n) = F(n - 1) + F(n - 2), for n > 1.
         */
        int num0 = 0, num1 = 1;
        if (n == 0) return num0;
        if (n == 1) return num1;
        // f(0) = num1
        // f(1) = num2
        int num2 = 0;
        for (int i = 2; i <=n ; i++) {
            // f(2) = f(0) + f(1)
            num2 = num0 + num1;
            int tmp = num1;
            num1 = num2;
            num0 = tmp; 

        }

        return num2;
    }
}
