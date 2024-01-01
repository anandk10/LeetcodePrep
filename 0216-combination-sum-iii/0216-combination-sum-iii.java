class Solution {

    List<List<Integer>> result;
    int targetSum ;

    private void dfs(int i, int bound, int currSum, List<Integer> solution) {

        if (solution.size() == bound) {
            if (currSum == targetSum) {
                // found a solution
                result.add(new ArrayList<>(solution));
            }
            return;
        }

        while (i <= 9) {
            solution.add(i);
            dfs(i + 1, bound, currSum + i, solution);
            solution.remove(solution.size() - 1);
            i++;
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        targetSum = n;
        dfs(1, k, 0, new ArrayList<>());
        return result;
    }
}

/**
nums[i]=[1,2,3,4,5,6,7,8,9]
k = number of elements allowed to form the sum

 */