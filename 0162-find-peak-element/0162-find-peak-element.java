class Solution {
    /**
    BINARY SEARCH 
    Compare mid to the right elememt
    if mid is greater than right, then move to the left
    otherwise move to the right
     */
    public int findPeakElement(int[] nums) {
        
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                // move to the left
                right = mid; // still consider the mid element
            } else {
                // move to the right
                left = mid + 1;
            }
        }

        return left;
    }
}