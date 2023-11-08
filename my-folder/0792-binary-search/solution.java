class Solution {

    private static int binarySearch(final int[] nums, int lower, 
            int upper, final int target){

        if (lower > upper) {
            return -1;
        }

        int mid = lower +  ( (upper - lower) / 2 );

        if (nums[mid] == target) { 
            return mid; 
        }
        if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, upper, target);    
        }
        if (target < nums[mid]) {
            return binarySearch(nums, lower, mid - 1, target);
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        // nums[]
        // middle of array

        return binarySearch(nums, 0, nums.length - 1, target);



















        // if (nums == null || nums.length == 0) return -1;
        
        // int lower = 0;
        // int upper = nums.length - 1;
                
        // while (lower <= upper) {
        //     int mid = lower + (upper - lower) / 2;
        //     if (target == nums[mid]) {
        //        return mid;
        //     } else if (target < nums[mid]) {
        //         upper = mid - 1;
        //     } else {
        //         lower = mid + 1;
        //     }

        // }
        
        // return -1;
    }
}
