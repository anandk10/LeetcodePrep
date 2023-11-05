class Solution {
    public boolean containsDuplicate(int[] nums) {
    
        // Brute force solution - Using imperative code
        // -----------------------------------------
        // Time complexity : O(N^2)
        // for (int i=0; i < nums.length; i++) {
        //     for (int j=i+1; j < nums.length ; j++) {
        //         if(nums[i] == nums[j]) {
        //             return true;
        //         }
        //     }
        // }
        // return false;
        

        // Solution 2: Using set and imperative code
        // -----------------------------------------

        // if (nums.length == 0) return false;

        // Set<Integer> counter = new HashSet<>();
        // // Time - O(N) Space - O(N)
        // for (int i=0; i<nums.length; i++) {

        //     // if (counter.contains(nums[i]))
        //     //     return true;
        //     // counter.add(nums[i]);

        //     // able to add to set
        //     if ( !counter.add(nums[i]) ) {
        //         // 'counter' set already has the element hence
        //         // counter.add returned false indicating duplicate element
        //         return true;
        //     }

        // }
        // return false;

        // Solution 3: Using set and functional code
        // -----------------------------------------
        // Set<Integer> counter = new HashSet<>();
        // return Arrays.stream(nums)
        //              .anyMatch(num -> !counter.add(num));

        Set<Integer> counter = new HashSet<Integer>();
        for (int num : nums) {
            if (counter.contains(num))
                return true;
            counter.add(num);
        }
        return false;
    }
}
