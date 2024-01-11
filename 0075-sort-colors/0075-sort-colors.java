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

    private void singlePass(int[] nums) {
        // Take left , right and ith pointer
        // left pointer makes sure that the values
        // on the left are 0
        // right pointer makes sure that the values
        // on the right are 2
        // ith pointer ignores the 1 values
        // but swaps with left if value is 0
        // and swaps with right if value is 2
        
        int i = 0, left = 0;
        int right = nums.length - 1;
        while ( i <= right ) {

            if (nums[i] == 0) {
                swap(nums, i, left);
                left += 1;
            } else if (nums[i] == 2) {
                swap(nums, i, right);
                right -= 1;
                i -= 1;
            }

            i += 1;
        }

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public void sortColors(int[] nums) {
        // twoPass(nums);
        singlePass(nums);

    }
}