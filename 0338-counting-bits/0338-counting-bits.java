class Solution {
    public int[] countBits(int n) {
        return solution1(n);
    }
    
    /**
    0
    1 - 1
    10 - 2
    11 - 3
    100 - 4
    101 - 5
    110 - 6
    111 - 7
    1000 - 8
    1001 - 9
    1010 - 10
    1011 - 11
    1100 - 12
    1101 - 13
    1110 - 14
    1111 - 15
    10000 - 16

    2^m = only 1 1 bit


    even numbers are multiples of 2
    i.e. going from 2 to 4 means changing from 10 to 100
    it's shifting a bit towards the most significant bit
    thereby adding another 0 to the least significant bit

    on the other hard, the odd numbers will follow
    multiple of 2 plus 1
    for e.g. 2 * 3 = 6 + 1 = 7
    that means bits of 3 (11) and bits of 7 (111) differ only by 1 extra bit
    therefore, if a number is odd, then divide and get the bit count and add 1 to that count
    
    */
    
    private int[] solution1 (int n) {
        
        int[] ans = new int[n + 1];
        
        ans[0] = 0;
        
        if (n == 0) return ans;
        
        ans[1] = 1;
        
        for (int i = 2; i < n + 1; i++) {
            
            // if even
            if (i % 2 == 0) {
                ans[i] = ans[i/2];
            }
            // if odd
            else {
                ans[i] = ans[i/2] + 1;   
            }
        }
        
        return ans;
    }
}