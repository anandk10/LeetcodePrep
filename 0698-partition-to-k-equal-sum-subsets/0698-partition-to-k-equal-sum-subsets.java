class Solution {

    /**
    The idea here is to use backtracking to check for a number
    if there's a subset that will sum upto target
    If yes, then start checking for the rest of the k-1 subsets

    Time complexity - O(k . 2^n)

    essentially we need to decide for every element that should it be
    part of the subset or not - choice of include /exclude - 2
    do this for n numbers
    for k number of times

     */

    // maintain a visited like array
    boolean[] used;
    
    int targetSum;

    private boolean backtrack(int[] nums, int i, int k, int subsetSum) {

        // base case
        if (k == 0) {
            return true;
        }
        
        if (subsetSum == targetSum) {
            // call the next backtrack solution
            return backtrack(nums, nums.length - 1, k - 1, 0);
        }

        // for (int j = i; j < nums.length; j++) {
        for (int j = i; j >= 0 ; j--) {

            // is used num or subset sum > target
            if (used[j] || (subsetSum + nums[j]) > targetSum) continue;
            
            // valid nums[j]

            used[j] = true;

            if (backtrack(nums, j - 1, k, subsetSum + nums[j])) {

                // System.out.println("Found " + Arrays.toString(used));
                return true;
            }

            used[j] = false;
        }
        return false;
    }


    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;

        for (int i = 0 ; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % k != 0) return false;

        Arrays.sort(nums);

        // swapping logic
        // for (int i = 0; i < nums.length / 2 ; i++) {
        //     nums[i] = nums[i] ^ nums[nums.length - 1 - i];
        //     nums[nums.length - 1 - i] = nums[i] ^ nums[nums.length - 1 - i];
        //     nums[i] = nums[i] ^ nums[nums.length - 1 - i];
        // }

        targetSum = sum / k;
        used = new boolean[nums.length];

        return backtrack(nums, nums.length - 1, k, 0);

    }
}