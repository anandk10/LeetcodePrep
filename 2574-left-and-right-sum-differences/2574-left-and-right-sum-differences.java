class Solution {
    public int[] leftRightDifference(int[] nums) {
        
        /**
        [10,4,8,3]
     pre[10,14,22,25]
     suf[25,15,11,3]   
        [15,1,11,22]

      25           0
        [10,4,8,3]
                 i
        [0,10,14,22]
                |22-0| = updated 22 
                0-> 0+3 = 3

               i |14-3|
        [0,10,11,22]
                3-> 3+8 = 11

           i |10-11|
        [0,1,11,22]
                 11-> 11+4 = 15
    
         i |0-15|
        [15,1,11,22]
                15 -> 15+10 = 25

         */

        if (nums.length == 1) {return new int[]{0};}

        int[] res = new int[nums.length];

        int prefix = 0;
        for(int i = 0 ; i < nums.length; i++) {
            res[i] = prefix;
            prefix += nums[i];
        }

        int suffix = 0;
        for (int i=nums.length-1 ; i >= 0; i--) {
            // |left[i] - right[i]|
            // res[i] is a prefix sum i.e. left
            // right will be the suffix
            res[i] = Math.abs(res[i] - suffix);
            suffix += nums[i];
        }

        return res;

    }
}