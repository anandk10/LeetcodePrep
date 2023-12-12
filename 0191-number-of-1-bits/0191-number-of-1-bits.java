public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return solution1(n);
    }
    

    /**
    n = 4
    n != 0
        count = 1
        n = 4 & 3
            100 & 011
            000
        n = 0
    Loop breaks
    
    n = 3
    n != 0
        count = 1
        n = 3 & 2
            11 & 10
            10
        n = 2
    n != 0
        count = 2
        n = 2 & 1
            10 & 01
            00
        n = 0
    Loop breaks
        
     */
    public int solution1(int n) {
        int count = 0;
        while (n!=0) {
            count += 1;
            // System.out.println("Before & " + n);
            n = n & (n-1);
            // System.out.println("After & " + n);
        }
        return count;
    }
}