class Solution {
    /**
    create the result array of size nums.length

    [3,1,-2,-5,2,-4]
    traverse the nums array; and keep tracks of the positive and negative indices
    in the result array. if the ith value is positive, fill the positive one,
    otherwise fill the negative ones.
    
    if nums[i] is positive - insert at res[pos] = nums[i]; pos += 2;
    else insert at res[neg] = nums[i]; neg += 2;
    
     */
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];

        int pos = 0;
        int neg = 1;

        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] > 0) {
                res[pos] = nums[i];
                pos += 2;
            } else {
                res[neg] = nums[i];
                neg += 2;
            }
            
        }

        return res;
    }
}