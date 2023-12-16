class Solution {
    
    private int[] solveTwoSum(int[] nums, int target) {
        // traverse the nums and if you're seeing that num
        // for the first time then add it to a Map
        // for every number compare if the target - num is
        // hashed in the map. this indicates that the previous
        // num that forms a pair is seen.
        
        if (nums.length < 2) {
            return new int[]{};
        }
        
        int[] res = new int[2];
        
        Map<Integer, Integer> pairSum = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            // found a pair
            if (pairSum.containsKey(target - nums[i])) {
                return new int[]{pairSum.get(target - nums[i]), i};
            }
            
            // haven't found a pair yet
            pairSum.put(nums[i], i); 
        }
        
        return res;
        
    }
    
    public int[] twoSum(int[] nums, int target) {
        return solveTwoSum(nums, target);    
    }
}