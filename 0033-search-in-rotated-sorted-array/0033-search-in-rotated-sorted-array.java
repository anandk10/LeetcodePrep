class Solution {
    
    /**
    Since the array is rotated, every time I find a mid,
    the array is divided into three categories
    1) left subarray
    2) mid element
    3) right subarray
    
    if a[m] == target then
        found the element
        return
    if a[l] <= a[m] then left subarray is sorted
      then look for target in the left subarray by
        if a[l] <= target < a[m] 
            move to the left ; r = m - 1
        else
            move to the right ; l = m + 1
    else
      the right subarray is sorted
      then look for target in the right subarray by
        if a[m] < target <= a[r]
            move to the right ; l = m + 1
        else
            move to the left ; r = m - 1
      
    */
    
    private int binarySearchRotatedArray(int[] nums, int target) {
        
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target) {
                return mid;
            }
            
            if (nums[left] <= nums[mid]) {
                // left subarray is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    // target may be in the left subarray
                    // move to the left
                    right = mid - 1;
                } else {
                    // target may be in the right subarray
                    // move to the right
                    left = mid + 1;
                }
                
            } else {
                // right subarray is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    // target may be in the right subarray
                    // move to the right 
                    left = mid + 1;
                } else {
                    // target may be in the left sub array
                    right = mid - 1;
                }
            }
        }
        
        // not found
        return -1;
    }
    
    public int search(int[] nums, int target) {
        
        return binarySearchRotatedArray(nums, target);
        
        
    }
}