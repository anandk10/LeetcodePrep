class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] output = new int[nums.length];
        int preProduct = 1;
        prefix[0] = 1;
        // compute prefix
        for (int i = 0; i < nums.length; i++) {
            preProduct *= nums[i];
            prefix[i] = preProduct;
        }

        int suffProduct = 1;
        suffix[suffix.length - 1] = 1;
        // compute suffix
        for (int i = nums.length - 1; i >= 0; i--) {
            suffProduct *= nums[i];
            suffix[i] = suffProduct;
        }

        output[0] = 1 * suffix[1];
        output[output.length - 1] = prefix[output.length - 2] * 1 ;
        for (int i = 1; i < output.length - 1; i++) {
            output[i] = prefix[i-1] * suffix [i+1];
        }
        return output;
    }
}
