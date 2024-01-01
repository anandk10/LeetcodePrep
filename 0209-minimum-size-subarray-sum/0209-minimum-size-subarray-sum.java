class Solution {

    /**

    WINDOWING --- 
        grow window
        while loop and try to shrink 
            update window size
            update the left
        update right

    HALLMARKS OF SLIDING WINDOW
    subarray - sequential numbers
    minimal length  - minimization
    sum is greater than or equal to target - constraint

    window to follow the above

    target = 7
     0,1,2,3,4,5
    [2,3,1,2,4,3]
               i
                  j

     sum = 8
     window size = j - i + 1 = 3 - 0 + 1 = 4
     shrink the window because we need minimal length
     
     sum -= nums[i]
     sum = 8 - 2 = 6
     i++

     while (sum >= target) {
         // shrink
     }

     since sum decreased now grow the window to satisfy the target 
     sum = 6 + 4 = 10
     sum >= target
     window size = (4, 4) = 4

     now shrink
     sum = 10 - 3 = 7
     sum >= target
     j - i + 1 = 3 [2,4] window
     window size = (4, 3) - update the window size


     */
    public int minSubArrayLen(int target, int[] nums) {
        
        int res = Integer.MAX_VALUE; // minimal length of window

        int left = 0, right = 0;
        int windowSize = Integer.MAX_VALUE;
        int currSum = 0;

        while (right < nums.length) {

            // growth phase
            currSum += nums[right];
            // if (currSum >= target) {
            //     // found our window
            //     windowSize = Math.min(windowSize, right - left + 1);
            // }

            // shrink phase
            while (currSum >= target) {
                // found our window
                windowSize = Math.min(windowSize, right - left + 1);
                currSum -= nums[left];
                left++;
            }

            right++;
        }

        return windowSize == Integer.MAX_VALUE ? 0 : windowSize;
    }
}