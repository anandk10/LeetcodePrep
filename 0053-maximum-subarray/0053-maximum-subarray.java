class Solution {
    public int maxSubArray(int[] nums) {
        
        
        // [-2,1,-3,4,-1,2,1,-5,4]
        // currMax = -2
        // currMax rest to 0 ; 
        // currMax += 1; currMax = 1;  max = (1, 0) = 1 
        // currMax += -3; currMax = -2; max = (1, -2) = 1 
        // currMax reset to 0 ; 
        // currMax += 4; currMax = 4 ; max = (1, 4) = 4
        // currMax += -1; currMax = 3 ; max = (4, 3) = 4
        // currMax += 2; currMax = 5 ; max = (4, 5) = 5
        // currMax += 1; currMax = 6        // everytime currMax updates store the max
                                // ; max = (5, 6) = 6
        // currMax += -5; currMax = 1;  max = (6, 1) = 6
        // currMax += 4; currMax = 5;  max = (6, 5) = 6
        
        
        int currMax = nums[0];
        int max = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            // currMax if becomes negative, then reset the currMax
            // we are treating currMax as a prefixSum that we don't 
            // desire to be negative
            if (currMax < 0) {
                currMax = 0;
            }
            
            currMax += nums[i];
            max = Math.max(max, currMax);
            
        }
        return max;
    }
}