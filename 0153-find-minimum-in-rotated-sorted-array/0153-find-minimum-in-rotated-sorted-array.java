class Solution {
    public int findMin(int[] nums) {
        
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            
            int mid = left + (right -left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            
            if (nums[left] < nums[mid]) {
                // explore the right part
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return Integer.MIN_VALUE;
        
    }
}