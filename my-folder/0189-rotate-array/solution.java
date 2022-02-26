class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length == 1) return;
        k = k % nums.length;
        reverseInRange(nums,0,nums.length-1);
        reverseInRange(nums,0,k-1);
        reverseInRange(nums,k,nums.length-1);
    }
    
    private void rotateRightByOne(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return;
//         int tmp = nums[nums.length - 1];
        
//         for (int j = nums.length - 1; j > 0; j--) {
//             nums[j] = nums[j-1];
//         } 
        
//         nums[0] = tmp;
    }
    
    
    private void reverseInRange(int[] nums, int low, int upp) {
        if (low < 0) return;
        if (upp >= nums.length) return;
        
        // swap using two variables
        while (low < upp) {
            nums[low] = nums[low] ^ nums[upp];
            nums[upp] = nums[low] ^ nums[upp];
            nums[low] = nums[low] ^ nums[upp];
            low++; upp--;
        }
    }
    
}
