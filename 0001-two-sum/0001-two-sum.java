class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 2 --> 0
        // 7 --> 1
        // 11 --> 2
        // 15 --> 3

        return solution(nums, target);

    }

    public int[] solution(int[] nums, int target) {
        int[] answer = {0,0};

        // create a hashmap and store the <num, index> in it
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            // first case: 9 - 2 (nums[i] ; i = 0) = 7 ; now checking for 7 in map
            Integer secondIndex = numMap.get(target - nums[i]);
            if (secondIndex != null && secondIndex != i) {
                answer[0] = i;
                answer[1] = secondIndex;
                break;
            }
        }


        return answer;
    }
}