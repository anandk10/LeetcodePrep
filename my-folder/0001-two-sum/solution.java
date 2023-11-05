class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Solution 1: Bruteforce

        // Iterate over the nums array 
        // for (int i=0; i<nums.length; i++) {
        //     for (int j=i+1; j<nums.length; j++) {
        //         if(nums[i] + nums[j] == target) {
        //             return new int[]{i, j};
        //         }
        //     }
        // }
        // return new int[]{0, 0};
        
        // O(N^2) 

        // Solution 2: Using HashMap
        // HashMap - <element, index>

        // Map<Integer, Integer> counters = new HashMap<>();
        Map<Integer, Integer> counters = new java.util.Hashtable<>();


        // target = element1 + element2
        // Iterate over the elements and check if 
        // target - element is found in the hashmap
        // if yes, then return that index and pair it
        // with the current index
        // if no such pair exists, then add the current 
        // element to the hashmap along with its index

        for (int i=0; i<nums.length; i++) {
            Integer j = counters.get(target - nums[i]);
            if (j != null) {
                return new int[]{i, j};
            }

            counters.put(nums[i], i);
        }

        return new int[]{0, 0};
    }
}
