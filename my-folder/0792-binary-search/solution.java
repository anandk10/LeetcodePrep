class Solution {
    public int search(int[] nums, int target) {
        
        if (nums == null || nums.length == 0) return -1;
        
        int lower = 0;
        int upper = nums.length - 1;
                
        while (lower <= upper) {
            int mid = lower + (upper - lower) / 2;
            if (target == nums[mid]) {
               return mid;
            } else if (target < nums[mid]) {
                upper = mid - 1;
            } else {
                lower = mid + 1;
            }

        }
        
        return -1;
    }
}
