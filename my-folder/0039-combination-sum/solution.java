class Solution {

    List<List<Integer>> finalSolution;

    private void backtrack(final int[] candidates, int curr, int target, List<Integer> solution) {

        // base condition
        if (target == 0) {
            finalSolution.add(new ArrayList<>(solution));
            return;
        }

        if (curr == candidates.length || target < 0) {
            return;
        }

        // including element
        solution.add(candidates[curr]);

        // calling the backtrack with reduced target
        backtrack(candidates, curr, target - candidates[curr], solution);

        // excluding element
        solution.remove(solution.size() - 1);

        // calling the backtrack with the intact target
        // curr + 1 is ok, because we are guaranteed that the values in candidates are unique
        // if not the case, then we would keep incrementing curr until the next non-duplicate value
        backtrack(candidates, curr + 1, target, solution);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        finalSolution = new ArrayList<>();
        // Arrays.sort(candidates);
        List<Integer> solution = new ArrayList<>();
        backtrack(candidates, 0, target, solution);
        return finalSolution;
    }
}
