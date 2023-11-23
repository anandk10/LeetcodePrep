class Solution {

    public int countOnes(int n) {
        int count = 0;
        while(n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
    public int[] countBits(int n) {
        
        

        int[] ans = IntStream.rangeClosed(0,n)
                            // .map(Integer::bitCount)
                            .map(this::countOnes)
                            .peek(System.out::println)
                            .toArray();
                            
                            

        return ans;
    }
}
