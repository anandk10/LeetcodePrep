class Solution {
    public int searchInsert(int[] nums, int target) {
        int lower = 0;
        int upper = nums.length - 1;
        
        while (lower <= upper) {
            
            int mid = lower + (upper - lower) / 2;
            
            if (nums[mid] == target) return mid;
            else if(nums[mid] < target) lower = mid + 1;
            else upper = mid - 1;
        }
        return upper + 1;
    }
}
