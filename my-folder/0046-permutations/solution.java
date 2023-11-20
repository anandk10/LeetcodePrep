class Solution {

    List<List<Integer>> finalSolution;

    private void backtrack(int[] nums, List<Integer> solution) {

        // base case - if we processed all the characters and reached 
        // size of nums.length
        if (solution.size() == nums.length) {
            finalSolution.add(new ArrayList<>(solution));
            return;
        }

        for (int num : nums) {
            // if we havent processed current number 
            // then only call backtrack on that number
            if (!solution.contains(num)) {
                solution.add(num);
                backtrack(nums, solution);
                solution.remove(solution.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        finalSolution = new ArrayList<>();

        backtrack(nums, new ArrayList<Integer>());

        return finalSolution;
    }
}
