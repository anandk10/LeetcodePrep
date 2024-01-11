class Solution {

    /**
    Intuition is to use a quick select algorithm 
    to do it in O(N) in single pass.
    Otherwise there's a two pass technique that will
    just count the number of 0,1 and 2
    and fill up the array in place.
     */

    private void twoPass(int[] nums) {

        int[] count = new int[2];
        // count the number of 0,1 and 2
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count[0] += 1;
            } else if(nums[i] == 1) {
                count[1] += 1;
            }
            
        }
        // this is not O(n^2)
        // count=[2,2,2]
        // [0,0,1,1,2,2]

        int j = 0;
        for (int i = 0; i < count.length; i++) {

            for(int k = 0; k < count[i]; k++) {
                nums[j] = i;
                j++;
            }
        }

        while (j < nums.length) {
            nums[j] = 2;
            j++;
        }        

    }


    public void sortColors(int[] nums) {
        twoPass(nums);
        
    }
}