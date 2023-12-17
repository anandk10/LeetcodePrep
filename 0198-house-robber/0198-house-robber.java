class Solution {

    private int dpSolution(int[] nums) {
        int N = nums.length;
        if (N == 0) return 0;

        int[] maxRobbedAmount = new int[N + 1];

        maxRobbedAmount[N] = 0;
        maxRobbedAmount[N - 1] = nums[N - 1];

        for (int i = N - 2; i >= 0; i--) {
            maxRobbedAmount[i] = Math.max(nums[i] + maxRobbedAmount[i + 2], 
                                          maxRobbedAmount[i + 1]);
        }
        return maxRobbedAmount[0];
    }

    private int dpOptimizedSolution(int[] nums) {

        int N = nums.length;
        if (N == 0) return 0;

        int[] maxRobbedAmount = new int[N + 1];

        // ......... rob1 , rob2
        int rob1 = nums[N - 1]; // only one house to rob
        int rob2 = 0; // no house in the picture

        // maxRobbedAmount[N] = 0;
        // maxRobbedAmount[N - 1] = nums[N - 1];

        for (int i = N - 2; i >= 0; i--) {
            int tmp = rob1; // we will move the rob1 and rob2 pointers towards 0
            // so maintain a tmp
            // new rob1 indicates the max profit that is achieved by robbing house i
            rob1 = Math.max(nums[i] + rob2, rob1);
            // now older rob1 becomes rob2
            rob2 = tmp;
            // maxRobbedAmount[i] = Math.max(nums[i] + maxRobbedAmount[i + 2], 
            //                               maxRobbedAmount[i + 1]);
        }
        // return maxRobbedAmount[0];
        // rob1 becomes the max profit at the 1st house
        return rob1;
    }
    public int rob(int[] nums) {

        // return dpSolution(nums);
        return dpOptimizedSolution(nums);
        
    }
}