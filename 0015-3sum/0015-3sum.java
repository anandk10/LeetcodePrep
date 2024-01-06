class Solution {

    /**
    SORT the incoming array
    Anchor a number; new targetSum = -num[i]
    if its not the first number; 
        then check for adjacent DUPLICATES 
            and increment i 
            and continue
    
    
    then rest of the array (i + 1) is the search space 
    for two numbers adding upto -num[i]
    use TWO POINTERs
    make sure to reduce the search space even further 
    by comparing the adjacent numbers for duplicates
    from both the ends.

     */
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            // not the first element and same as previous element
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;
            int targetSum = 0 - nums[i];

            while (j < k) {

                int sum = nums[j] + nums[k];

                if (sum == targetSum) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    while (j < k && nums[k - 1] == nums[k]) {
                        k--;
                    }

                    j++;
                    k--;
                } else if (sum > targetSum) {
                    k--;
                } else {
                    j++;
                }

         

            }

        }

        return result;
    }
}