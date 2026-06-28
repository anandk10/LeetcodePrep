class Solution {

    class TargetSumSolution {
        int target;
        int[] nums;
        record Key(int index, int total) {};

        Map<Key, Integer> DP = new HashMap<>();

        TargetSumSolution(int[] nums, int target) {
            this.nums = nums;
            this.target = target;
        }

        int backtracking(Key data) {
            if (data.index == this.nums.length) {
                return data.total == this.target ? 1 : 0;
            }

            if (DP.containsKey(data)) {
                return DP.get(data);
            }
            
            int i = data.index;
            int t = data.total;

            DP.put(
                data,
                backtracking(new Key(i + 1, t + this.nums[i])) + 
                backtracking(new Key(i + 1, t - this.nums[i]))
            );
            return DP.get(data);

        }
    }

    public int findTargetSumWays(int[] nums, int target) {
        return new TargetSumSolution(nums, target)
                    .backtracking(new TargetSumSolution.Key(0, 0));
    }
}
