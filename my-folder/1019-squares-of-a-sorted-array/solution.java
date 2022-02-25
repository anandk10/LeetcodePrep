class Solution {
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0 ) return nums;
        
        int[] sqNums = new int[nums.length];
        
        int lower = 0;
        int upper = nums.length - 1;
        int i = nums.length - 1;
        
        while (lower <= upper) {
            int lowerSquared = nums[lower] * nums[lower];
            int upperSquared = nums[upper] * nums[upper];
            
            if (lowerSquared < upperSquared) {
                sqNums[i--] = upperSquared;
                upper--;
            } else {
                sqNums[i--] = lowerSquared;
                lower++;
            }
        }

        return sqNums;
    }
}
