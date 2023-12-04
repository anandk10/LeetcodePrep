class Solution {

    List<List<Integer>> result;


    private void dfs (int index, List<Integer> current, int[] candidates, int remTotal) {
        // base cases
        if (index == candidates.length || remTotal < 0) {
            return;
        }

        if (remTotal == 0) {
            // got the answer
            result.add(new ArrayList<>(current));
            return;
        }

        // include the ith number
        current.add(candidates[index]);

        // now for other candidates, call dfs again
        // decrement the total here, because we have included the ith number
        dfs(index, current, candidates, remTotal - candidates[index]);
        
        // now the right side of the decision tree
        // don't include the number
        current.remove(current.size() - 1);

        // since the number is excluded from the consideration
        // move the index further, also dont decrement the total
        dfs(index + 1, current, candidates, remTotal);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        dfs(0, new ArrayList<>(), candidates, target);
        return this.result;
    }
}
