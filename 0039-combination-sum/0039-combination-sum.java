class Solution {

    List<List<Integer>> result;
    int targetSum;

    private void dfs(int curr, int[] candidates, int currSum, List<Integer> solution) {

        if (currSum == targetSum) {
            // found a solution
            result.add(new ArrayList<>(solution));
            return;
        }

        if (curr == candidates.length || currSum > targetSum) {
            // not a solution
            return;
        }

        // consider the curr element again
        solution.add(candidates[curr]);
        // the problem states we can reuse this number
        dfs(curr, candidates, currSum + candidates[curr], solution);

        // the previous call may have found a solution or may be not
        // so we will remove this curr element from solution and 
        // MOVE the curr pointer because we don't want to consider the
        // curr element ever again to ensure this number is not repeated.
        solution.remove(solution.size() - 1);

        // In essence we call dfs / backtracking by including the number ALWAYS
        // and then call dfs/backtracking by excluding the number ALWAYS

        // this call we didn't consider the curr element so we didn't add it
        // to the currSum as well.
        dfs(curr + 1, candidates, currSum, solution);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        targetSum = target;
        result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, candidates, 0, new ArrayList<>());
        return result;
    }
}