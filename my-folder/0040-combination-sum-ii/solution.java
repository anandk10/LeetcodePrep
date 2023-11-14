class Solution {

    // 1,2,2,2,5 target = 5
    //             []
    //            /. \
    //         [1]    []
    //       /.   \
    //     [1,2]   [1]
    //     /.  \.     /.   \
    // [1,2,2] [1,2] [1,2]. [1]
    //         /. \             
    //      [1,2,2] [1,2]   

    List<List<Integer>> finalSolution;

    private void backtrack(final int[] candidates, int curr, int target, List<Integer> solution) {

        // base condition
        if (target == 0) {
            finalSolution.add(new ArrayList<>(solution));
            return;
        }

        if (curr == candidates.length || candidates[curr] > target ||  target < 0) {
            return;
        }

        // include the element
        solution.add(candidates[curr]);

        // invoke backtrack
        backtrack(candidates, curr + 1, target - candidates[curr], solution);

        // exclude the element 
        solution.remove(solution.size() - 1);

        // increment curr until we find a next distinct element
        for (; curr < candidates.length - 1 && candidates[curr] == candidates[curr + 1]; curr++ );

        // invoke backtrack
        backtrack(candidates, curr + 1, target, solution);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        finalSolution = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>());
        return finalSolution;
    }
}
