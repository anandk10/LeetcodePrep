class Solution {
    
    
    /**
    the idea here is to put the sorted property of the array to use
    we start from left and right (two pointer technique),
    sum the left and right numbers and compare it with the target
    is equal we have found the indices
    otherwise if sum is larger then move the right towards the left
    indicating the need to decrease the sum
    if sum is smaller than move the left towards the right, indicating the
    need to increase the sum.
    */
    private int[] solveTwoSumSorted(int[] nums, int target) {
        
        int i = 0;
        int j = nums.length - 1;
        
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};  // only because the output asks for
                                                // 1st based index
            }
            
            // is sum is greater then move the right pointer j towards left
            if (sum > target) j--;
            else i++;
        }
        
        return new int[]{-1, -1};
        
        
    }
    
    public int[] twoSum(int[] numbers, int target) {
        
        return solveTwoSumSorted(numbers, target);
        
    }
}