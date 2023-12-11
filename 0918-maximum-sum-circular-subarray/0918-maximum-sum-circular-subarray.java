class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        // idea here is to capture both the max and min
        // and the total sum of the array
        
        // after we run through the array, we will
        // end up having total, currMin, currMax, globalMin, globalMax
        
        // return max(globalMax, total - globalMin)
        
        // we need globalMax when all the nums are negative
        // then the globalMax becomes negative because there is no single
        // positive number to be picked up as a globalMax
        
        // thus in that case total - globalMin won't return the correct result
        // because that computation will return 0. recall there's no 0 in nums
        // total of all negative and globalMin would be the same
        // therefore in this scenario return globalMax
        
        int globalMax = nums[0], globalMin = nums[0];
        int currMax = 0, currMin = 0;
        int total = 0;
        
        for (int num : nums) {
            // to compute the currMax, the idea is, either take the. sum of
            // currMax + num (nums[i]) or exclude the sum until now favoring 
            // just the num (nums[i]) i.e earlier sum plus the current num 
            // could be less than the current num itself
            currMax = Math.max(currMax + num, num);
            globalMax = Math.max(globalMax, currMax);
            
            // Similarly for currMin
            currMin = Math.min(currMin + num, num);
            globalMin = Math.min(globalMin, currMin);
            
            total += num;
        }
        
        if (globalMax < 0) {
            return globalMax;
        }
        
        return Math.max(globalMax, total - globalMin);
    }
}