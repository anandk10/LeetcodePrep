class Solution {

    /**
    
    The strategy here is the run two binary searches with the target value
    findLowPoint()
        keep moving the right pointer until you're finding nums[mid] <= target
            so you will push towards left
        otherwise move left towards right
        finally nums[left] is the low index

    findHighPoint()
        keep moving the left pointer until you're finding nums[mid] >= target
            so you will push towards right
        otherwise move right towards left
        finally nums[right] is the high index
     */

    public int[] searchRange(int[] nums, int target) {
        // The strategy here is to run binary search twice
        // 1. find the lowest index
        // 2. find the highest index
        
        int[] result = new int[2];
        
        result[0] = findLowPoint(nums, target);
        result[1] = findHighPoint(nums, target);
        return result;
    }
    
    
    private int findLowPoint(int[] nums, int target) {
        
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left < nums.length && nums[left] == target ? left : -1; 
        
    }
    
    private int findHighPoint(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {
               right = mid - 1; 
            } else {
                left = mid + 1;
            }
        }

        return right >= 0 && nums[right] == target ? right : -1;
        
    }
}