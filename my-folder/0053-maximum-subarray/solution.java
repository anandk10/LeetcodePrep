class Solution {

    // [-2,1,-3,4,-1,2,1,-5,4]


    public int maxSubArray(int[] nums) {
        // The idea behind solving this problem is to drop the negative sum , and start over again.
        // while doing that, record the max sum always. the objective is to return the sum and not
        // the subarray , so be little greedy

        int max = nums[0]; // starting max

        int currSum = 0;

        for(int num : nums) {
            if(currSum < 0) { //negative sum, needs to be dropped
                currSum = 0; // dropping means resetting to 0
            } 

            currSum += num;
            max = Math.max(currSum, max);
        }

        return max;
    }
}
