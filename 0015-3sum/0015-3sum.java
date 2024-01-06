class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        final int N = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {

            // not the first element and same as previous element
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int j = i + 1;
            int k = N;
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